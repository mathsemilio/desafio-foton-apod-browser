package com.github.mathsemilio.apodbrowser.infrastructure.common.gateway

import com.github.mathsemilio.apodbrowser.infrastructure.common.mediator.ApodResourceMediator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ApodGatewayImpl(private var apodResourceMediator: ApodResourceMediator) : ApodGateway {

    override suspend fun fetchLatestApods() = withContext(Dispatchers.IO) {
        apodResourceMediator.fetchApods()
    }
}
