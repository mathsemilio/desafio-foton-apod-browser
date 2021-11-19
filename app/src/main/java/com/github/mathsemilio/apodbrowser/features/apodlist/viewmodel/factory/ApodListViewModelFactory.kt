package com.github.mathsemilio.apodbrowser.features.apodlist.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.mathsemilio.apodbrowser.features.apodlist.viewmodel.ApodListViewModel
import com.github.mathsemilio.apodbrowser.infrastructure.common.gateway.ApodGateway

@Suppress("UNCHECKED_CAST")
class ApodListViewModelFactory(private val apodGateway: ApodGateway) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ApodListViewModel(apodGateway) as T
    }
}
