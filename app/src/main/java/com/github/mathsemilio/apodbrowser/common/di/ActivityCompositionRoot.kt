package com.github.mathsemilio.apodbrowser.common.di

import androidx.appcompat.app.AppCompatActivity

class ActivityCompositionRoot(
    private val activity: AppCompatActivity,
    private val compositionRoot: CompositionRoot
) {
    val apodApi
        get() = compositionRoot.apodApi
}
