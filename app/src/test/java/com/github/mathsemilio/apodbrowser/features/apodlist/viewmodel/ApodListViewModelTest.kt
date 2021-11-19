package com.github.mathsemilio.apodbrowser.features.apodlist.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.github.mathsemilio.apodbrowser.data.ApodTestDataProvider
import com.github.mathsemilio.apodbrowser.infrastructure.common.gateway.ApodGateway
import com.github.mathsemilio.apodbrowser.infrastructure.common.mediator.ApodResourceMediatorResult
import com.github.mathsemilio.apodbrowser.rule.MainDispatcherCoroutineRule
import com.github.mathsemilio.apodbrowser.util.getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class ApodListViewModelTest {

    companion object {
        private val APODS = ApodTestDataProvider.apods
    }

    @get:Rule
    val mainDispatcherCoroutineRule = MainDispatcherCoroutineRule()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var apodGatewayMock: ApodGateway

    private lateinit var SUT: ApodListViewModel

    @Before
    fun setUp() {
        SUT = ApodListViewModel(apodGatewayMock)
    }

    @Test
    fun fetchApods_success_dataFetchedFromNetwork_viewStateSetToFetchApodsCompleted() = runBlockingTest {
        arrangeFetchedFromNetworkSuccess()

        SUT.fetchApods()

        val viewState = SUT.viewState.getOrAwaitValue()
        assertTrue(viewState == ApodListViewModel.ViewState.FetchApodsCompleted(APODS))
    }

    @Test
    fun fetchApods_success_dataFetchedFromCache_viewStateSetToFetchApodsCompleted() = runBlockingTest {
        arrangeFetchedFromCacheSuccess()

        SUT.fetchApods()

        val viewState = SUT.viewState.getOrAwaitValue()
        assertTrue(viewState == ApodListViewModel.ViewState.FetchApodsCompleted(APODS))
    }

    @Test
    fun fetchApods_error_cacheEmpty_viewStateSetToFetchApodsFailed() = runBlockingTest {
        arrangeNetworkError()

        SUT.fetchApods()

        val viewState = SUT.viewState.getOrAwaitValue()
        assertTrue(viewState == ApodListViewModel.ViewState.FetchApodsFailed)
    }

    @Test
    fun fetchApods_error_cachedDataAvailable_viewStateSetToFetchApodsCompleted() = runBlockingTest {
        arrangeCachedDataAvailable()

        SUT.fetchApods()

        val viewState = SUT.viewState.getOrAwaitValue()
        assertTrue(viewState == ApodListViewModel.ViewState.FetchApodsCompleted(APODS))
    }

    private suspend fun arrangeFetchedFromNetworkSuccess() {
        `when`(apodGatewayMock.fetchLatestApods()).thenReturn(
            ApodResourceMediatorResult.FetchedFromNetwork(APODS)
        )
    }

    private suspend fun arrangeFetchedFromCacheSuccess() {
        `when`(apodGatewayMock.fetchLatestApods()).thenReturn(
            ApodResourceMediatorResult.FetchedFromCache(APODS)
        )
    }

    private suspend fun arrangeNetworkError() {
        `when`(apodGatewayMock.fetchLatestApods()).thenReturn(
            ApodResourceMediatorResult.NetworkError
        )
    }

    private suspend fun arrangeCachedDataAvailable() {
        `when`(apodGatewayMock.fetchLatestApods()).thenReturn(
            ApodResourceMediatorResult.FetchedFromCache(APODS)
        )
    }
}
