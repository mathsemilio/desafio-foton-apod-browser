package com.github.mathsemilio.apodbrowser.infrastructure.common.mediator

import com.github.mathsemilio.apodbrowser.features.apodlist.model.Apod

sealed class ApodResourceMediatorResult {
    data class FetchedFromNetwork(val apods: List<Apod>) : ApodResourceMediatorResult()

    data class FetchedFromCache(val apods: List<Apod>) : ApodResourceMediatorResult()

    object NetworkError : ApodResourceMediatorResult()
}
