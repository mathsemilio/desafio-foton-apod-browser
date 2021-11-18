package com.github.mathsemilio.apodbrowser.features.common

import androidx.appcompat.app.AppCompatActivity
import com.github.mathsemilio.apodbrowser.ApodBrowserApplication
import com.github.mathsemilio.apodbrowser.common.di.ActivityCompositionRoot
import com.github.mathsemilio.apodbrowser.common.di.PresentationCompositionRoot

class BaseActivity : AppCompatActivity() {

    private val activityCompositionRoot by lazy {
        ActivityCompositionRoot(
            activity = this,
            compositionRoot = (application as ApodBrowserApplication).compositionRoot
        )
    }

    val compositionRoot by lazy {
        PresentationCompositionRoot(activityCompositionRoot)
    }
}
