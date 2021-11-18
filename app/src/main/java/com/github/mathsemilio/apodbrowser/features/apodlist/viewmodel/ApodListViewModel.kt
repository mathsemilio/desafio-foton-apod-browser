package com.github.mathsemilio.apodbrowser.features.apodlist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.mathsemilio.apodbrowser.features.apodlist.model.Apod
import com.github.mathsemilio.apodbrowser.infrastructure.networking.gateway.ApodGateway
import com.github.mathsemilio.apodbrowser.infrastructure.networking.wrapper.Result
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
                    is Result.Completed ->
                        ViewState.FetchApodsCompleted(apods = result.data ?: emptyList())
                    is Result.Failed ->
                        ViewState.FetchApodsFailed
                }
            }
        }
    }
}
