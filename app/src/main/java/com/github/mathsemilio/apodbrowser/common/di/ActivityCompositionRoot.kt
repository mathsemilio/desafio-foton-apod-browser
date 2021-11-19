package com.github.mathsemilio.apodbrowser.common.di

import com.github.mathsemilio.apodbrowser.infrastructure.storage.database.ApodCacheDatabase

class ActivityCompositionRoot(private val compositionRoot: CompositionRoot) {

    private val apodCacheDatabase
        get() = ApodCacheDatabase.getDatabase(compositionRoot.application)

    val apodCacheDao
        get() = apodCacheDatabase.apodCacheDao

    val application
        get() = compositionRoot.application

    val apodApi
        get() = compositionRoot.apodApi
}
