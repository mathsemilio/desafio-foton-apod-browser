package com.github.mathsemilio.apodbrowser.common.di

import android.app.Application
import com.github.mathsemilio.apodbrowser.common.BASE_URL
import com.github.mathsemilio.apodbrowser.infrastructure.networking.api.ApodApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CompositionRoot(val application: Application) {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apodApi: ApodApi
        get() = retrofit.create(ApodApi::class.java)
}
