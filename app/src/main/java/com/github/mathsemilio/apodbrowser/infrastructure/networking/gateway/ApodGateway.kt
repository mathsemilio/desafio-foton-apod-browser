package com.github.mathsemilio.apodbrowser.infrastructure.networking.gateway

import com.github.mathsemilio.apodbrowser.common.util.toApodList
import com.github.mathsemilio.apodbrowser.features.apodlist.model.Apod
import com.github.mathsemilio.apodbrowser.infrastructure.networking.api.ApodApi
import com.github.mathsemilio.apodbrowser.infrastructure.networking.model.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ApodGateway(private val api: ApodApi) {

    suspend fun fetchLastestApods(): Result<List<Apod>> {
        return withContext(Dispatchers.IO) {
            try {
                Result.Completed(data = api.fetchLatestApods().body()?.toApodList())
            } catch (exception: Exception) {
                Result.Failed(exception = exception)
            }
        }
    }
}
