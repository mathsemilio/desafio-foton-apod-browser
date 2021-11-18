package com.github.mathsemilio.apodbrowser.infrastructure.networking.api

import com.github.mathsemilio.apodbrowser.common.APOD_ENDPOINT
import com.github.mathsemilio.apodbrowser.common.DEMO_API_KEY
import com.github.mathsemilio.apodbrowser.common.util.formatTimeInMillis
import com.github.mathsemilio.apodbrowser.features.apodlist.model.ApodSchema
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApodApi {

    @GET(APOD_ENDPOINT)
    suspend fun fetchLatestApods(
        @Query("api_key") key: String = DEMO_API_KEY,
        @Query("start_date") startDate: String = System.currentTimeMillis().formatTimeInMillis(),
        @Query("thumbs") includeThumbnail: Boolean = true
    ): Response<List<ApodSchema>>
}
