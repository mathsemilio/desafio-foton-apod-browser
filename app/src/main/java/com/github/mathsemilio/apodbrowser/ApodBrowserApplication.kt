package com.github.mathsemilio.apodbrowser

import android.app.Application
import com.github.mathsemilio.apodbrowser.common.di.CompositionRoot
import kotlinx.coroutines.IO_PARALLELISM_PROPERTY_NAME

class ApodBrowserApplication : Application() {

    lateinit var compositionRoot: CompositionRoot

    override fun onCreate() {
        super.onCreate()

        System.setProperty(IO_PARALLELISM_PROPERTY_NAME, Int.MAX_VALUE.toString())

        compositionRoot = CompositionRoot(this)
    }
}
