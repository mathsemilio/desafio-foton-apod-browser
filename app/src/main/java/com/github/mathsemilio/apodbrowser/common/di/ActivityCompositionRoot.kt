package com.github.mathsemilio.apodbrowser.common.di

import androidx.appcompat.app.AppCompatActivity
import com.github.mathsemilio.apodbrowser.infrastructure.storage.database.ApodCacheDatabase

class ActivityCompositionRoot(
    private val activity: AppCompatActivity,
    private val compositionRoot: CompositionRoot
) {
    private val cachedApodDatabase
        get() = ApodCacheDatabase.getDatabase(compositionRoot.application)

    val apodCacheDao
        get() = cachedApodDatabase.apodCacheDao

    val apodApi
        get() = compositionRoot.apodApi
}
