package com.github.mathsemilio.apodbrowser.features.apodlist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.mathsemilio.apodbrowser.features.apodlist.model.Apod
import com.github.mathsemilio.apodbrowser.infrastructure.common.gateway.ApodGateway
import com.github.mathsemilio.apodbrowser.infrastructure.common.mediator.ApodResourceMediatorResult.FetchedFromNetwork
import com.github.mathsemilio.apodbrowser.infrastructure.common.mediator.ApodResourceMediatorResult.FetchedFromCache
import com.github.mathsemilio.apodbrowser.infrastructure.common.mediator.ApodResourceMediatorResult.NetworkError

import kotlinx.coroutines.launch

class ApodListViewModel(private val apodGateway: ApodGateway) : ViewModel() {

    sealed class ViewState {
        data class FetchApodsCompleted(val apods: List<Apod>) : ViewState()

        object FetchApodsFailed : ViewState()
    }

    private val _viewState: MutableLiveData<ViewState> = MutableLiveData()

    val viewState: LiveData<ViewState>
        get() = _viewState

    fun fetchApods() {
        viewModelScope.launch {
            apodGateway.fetchLatestApods().also { result ->
                _viewState.value = when (result) {
                    is FetchedFromCache -> ViewState.FetchApodsCompleted(result.apods)
                    is FetchedFromNetwork -> ViewState.FetchApodsCompleted(result.apods)
                    NetworkError -> ViewState.FetchApodsFailed
                }
            }
        }
    }
}
