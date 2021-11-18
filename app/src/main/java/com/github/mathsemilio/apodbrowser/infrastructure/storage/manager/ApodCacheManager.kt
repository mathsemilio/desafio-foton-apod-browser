package com.github.mathsemilio.apodbrowser.infrastructure.storage.manager

import com.github.mathsemilio.apodbrowser.features.apodlist.model.Apod
import com.github.mathsemilio.apodbrowser.infrastructure.storage.dao.ApodCacheDao

class ApodCacheManager(private val apodCacheDao: ApodCacheDao) {

    suspend fun isCacheEmpty() = apodCacheDao.fetchCachedApods().isEmpty()

    suspend fun fetchCachedData() = apodCacheDao.fetchCachedApods()

    suspend fun updateCache(apods: List<Apod>) {
        apods.forEach { apod ->
            apodCacheDao.add(apod)
        }
    }

    suspend fun invalidateCache() = apodCacheDao.deleteCache()
}
