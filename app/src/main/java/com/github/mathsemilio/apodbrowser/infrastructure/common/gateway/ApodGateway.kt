package com.github.mathsemilio.apodbrowser.infrastructure.common.gateway

import com.github.mathsemilio.apodbrowser.infrastructure.common.mediator.ApodResourceMediator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ApodGateway(private var apodResourceMediator: ApodResourceMediator) {

    suspend fun fetchLatestApods() = withContext(Dispatchers.IO) {
        apodResourceMediator.fetchApods()
    }
}
