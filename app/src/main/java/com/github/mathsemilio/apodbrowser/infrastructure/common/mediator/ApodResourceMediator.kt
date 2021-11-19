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
    suspend fun fetchApods(): ApodResourceMediatorResult {
        return if (hasNetworkConnection(context)) {
            val response = apodApi.fetchLatestApods()
            val apodsFromResponse = response.body()?.toApodList()?.reversed() ?: emptyList()

            if (response.isSuccessful) {
                onSuccessfulResponse(apodsFromResponse)
            } else {
                onNetworkError()
            }
        } else {
            onNetworkError()
        }
    }

    private suspend fun onNetworkError(): ApodResourceMediatorResult {
        return if (apodCacheManager.isCacheEmpty()) {
            ApodResourceMediatorResult.NetworkError
        } else {
            ApodResourceMediatorResult.FetchedFromCache(apodCacheManager.fetchCachedData())
        }
    }

    private suspend fun onSuccessfulResponse(response: List<Apod>): ApodResourceMediatorResult {
        return if (apodCacheManager.isCacheEmpty()) {
            apodCacheManager.updateCache(response)
            ApodResourceMediatorResult.FetchedFromNetwork(response)
        } else {
            apodCacheManager.invalidateCache()
            apodCacheManager.updateCache(response)
            ApodResourceMediatorResult.FetchedFromCache(apodCacheManager.fetchCachedData())
        }
    }
}
