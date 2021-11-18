package com.github.mathsemilio.apodbrowser.infrastructure.networking.mediator

import com.github.mathsemilio.apodbrowser.common.util.toApodList
import com.github.mathsemilio.apodbrowser.features.apodlist.model.Apod
import com.github.mathsemilio.apodbrowser.infrastructure.networking.api.ApodApi
import com.github.mathsemilio.apodbrowser.infrastructure.storage.manager.ApodCacheManager

class ApodResourceMediator(
    private val apodApi: ApodApi,
    private val apodCacheManager: ApodCacheManager
) {
    suspend fun fetchApods(): List<Apod> {
        val apods: List<Apod>

        val response = apodApi.fetchLatestApods()

        if (response.isSuccessful) {
            val apodsFromResponse = response.body()?.toApodList()?.reversed() ?: emptyList()

            apods = if (apodCacheManager.isCacheEmpty()) {
                apodCacheManager.updateCache(apodsFromResponse)
                apodsFromResponse
            } else {
                apodCacheManager.invalidateCache()
                apodCacheManager.updateCache(apodsFromResponse)
                apodCacheManager.fetchCachedData()
            }
        } else {
            apods = if (apodCacheManager.isCacheEmpty())
                emptyList()
            else
                apodCacheManager.fetchCachedData()
        }

        return apods
    }
}
