package com.github.mathsemilio.apodbrowser.infrastructure.common.gateway

import com.github.mathsemilio.apodbrowser.infrastructure.common.mediator.ApodResourceMediatorResult

interface ApodGateway {
    suspend fun fetchLatestApods(): ApodResourceMediatorResult
}
