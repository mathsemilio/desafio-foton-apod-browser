package com.github.mathsemilio.apodbrowser.infrastructure.networking.gateway

import com.github.mathsemilio.apodbrowser.features.apodlist.model.Apod
import com.github.mathsemilio.apodbrowser.infrastructure.networking.mediator.ApodResourceMediator
import com.github.mathsemilio.apodbrowser.infrastructure.networking.wrapper.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ApodGateway(private var apodResourceMediator: ApodResourceMediator) {

    suspend fun fetchLatestApods(): Result<List<Apod>> {
        return withContext(Dispatchers.IO) {
            try {
                Result.Completed(data = apodResourceMediator.fetchApods())
            } catch (exception: Exception) {
                Result.Failed(exception = exception)
            }
        }
    }
}
