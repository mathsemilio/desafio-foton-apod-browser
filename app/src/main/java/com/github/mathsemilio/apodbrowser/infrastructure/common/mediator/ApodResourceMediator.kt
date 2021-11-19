package com.github.mathsemilio.apodbrowser.infrastructure.common.mediator

import android.content.Context
import com.github.mathsemilio.apodbrowser.common.util.hasNetworkConnection
import com.github.mathsemilio.apodbrowser.common.util.toApodList
import com.github.mathsemilio.apodbrowser.features.apodlist.model.Apod
import com.github.mathsemilio.apodbrowser.infrastructure.networking.api.ApodApi
import com.github.mathsemilio.apodbrowser.infrastructure.storage.manager.ApodCacheManager

class ApodResourceMediator(
    private val context: Context,
    private val apodApi: ApodApi,
    private val apodCacheManager: ApodCacheManager
) {
    sealed class ApodResourceMediatorResult {
        data class FetchedFromNetwork(val apods: List<Apod>) : ApodResourceMediatorResult()

        data class FetchedFromCache(val apods: List<Apod>) : ApodResourceMediatorResult()

        object NetworkError : ApodResourceMediatorResult()
    }

    suspend fun fetchApods(): ApodResourceMediatorResult {
        return if (hasNetworkConnection(context)) {
            val response = apodApi.fetchLatestApods()

            return if (response.isSuccessful) {
                val apodsFromResponse = response.body()?.toApodList()?.reversed() ?: emptyList()

                if (apodCacheManager.isCacheEmpty()) {
                    apodCacheManager.updateCache(apodsFromResponse)
                    ApodResourceMediatorResult.FetchedFromNetwork(apodsFromResponse)
                } else {
                    apodCacheManager.invalidateCache()
                    apodCacheManager.updateCache(apodsFromResponse)
                    ApodResourceMediatorResult.FetchedFromCache(apodCacheManager.fetchCachedData())
                }
            } else {
                if (apodCacheManager.isCacheEmpty()) {
                    ApodResourceMediatorResult.NetworkError
                } else {
                    ApodResourceMediatorResult.FetchedFromCache(apodCacheManager.fetchCachedData())
                }
            }
        } else {
            if (apodCacheManager.isCacheEmpty()) {
                ApodResourceMediatorResult.NetworkError
            } else {
                ApodResourceMediatorResult.FetchedFromCache(apodCacheManager.fetchCachedData())
            }
        }
    }
}
