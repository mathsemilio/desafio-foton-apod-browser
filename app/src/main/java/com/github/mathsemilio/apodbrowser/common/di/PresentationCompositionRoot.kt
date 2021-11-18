package com.github.mathsemilio.apodbrowser.common.di

import com.github.mathsemilio.apodbrowser.features.apodlist.viewmodel.factory.ApodListViewModelFactory
import com.github.mathsemilio.apodbrowser.infrastructure.networking.gateway.ApodGateway
import com.github.mathsemilio.apodbrowser.infrastructure.networking.mediator.ApodResourceMediator
import com.github.mathsemilio.apodbrowser.infrastructure.storage.manager.ApodCacheManager

class PresentationCompositionRoot(private val activityCompositionRoot: ActivityCompositionRoot) {

    private val apodCacheManager
        get() = ApodCacheManager(activityCompositionRoot.apodCacheDao)

    private val apodResourceMediator
        get() = ApodResourceMediator(
            activityCompositionRoot.apodApi,
            apodCacheManager
        )

    private val apodGateway
        get() = ApodGateway(apodResourceMediator)

    val apodListViewModelFactory
        get() = ApodListViewModelFactory(apodGateway)
}
