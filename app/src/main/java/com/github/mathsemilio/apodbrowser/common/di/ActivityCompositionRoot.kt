package com.github.mathsemilio.apodbrowser.common.di

import com.github.mathsemilio.apodbrowser.infrastructure.storage.database.ApodCacheDatabase

class ActivityCompositionRoot(private val compositionRoot: CompositionRoot) {

    private val cachedApodDatabase
        get() = ApodCacheDatabase.getDatabase(compositionRoot.application)

    val apodCacheDao
        get() = cachedApodDatabase.apodCacheDao

    val application
        get() = compositionRoot.application

    val apodApi
        get() = compositionRoot.apodApi
}
