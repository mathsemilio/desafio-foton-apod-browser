package com.github.mathsemilio.apodbrowser.features.apodlist.view

import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.github.mathsemilio.apodbrowser.common.DEFAULT_APOD_LIST_ITEM_CACHE
import com.github.mathsemilio.apodbrowser.databinding.ActivityApodListBinding
import com.github.mathsemilio.apodbrowser.features.apodlist.model.Apod
import com.github.mathsemilio.apodbrowser.features.apodlist.view.adapter.ApodListAdapter
import com.github.mathsemilio.apodbrowser.features.apodlist.viewmodel.ApodListViewModel
import com.github.mathsemilio.apodbrowser.features.apodlist.viewmodel.ApodListViewModel.ViewState
import com.github.mathsemilio.apodbrowser.features.apodlist.viewmodel.factory.ApodListViewModelFactory
import com.github.mathsemilio.apodbrowser.features.common.BaseActivity

class ApodListActivity : BaseActivity() {

    private lateinit var binding: ActivityApodListBinding

    private lateinit var viewModelFactory: ApodListViewModelFactory
    private lateinit var viewModel: ApodListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityApodListBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setupViewModel()

        setupObserver()

        attachSwipeToRefreshOnRefreshListener()
    }

    private fun setupViewModel() {
        viewModelFactory = compositionRoot.apodListViewModelFactory
        viewModel = ViewModelProvider(this, viewModelFactory)[ApodListViewModel::class.java]
    }

    private fun setupObserver() {
        viewModel.viewState.observe(this, { viewState ->
            when (viewState) {
                is ViewState.FetchApodsCompleted -> onFetchApodsCompleted(viewState.apods)
                ViewState.FetchApodsFailed -> showScreenErrorState()
            }
        })
    }

    private fun onFetchApodsCompleted(apods: List<Apod>) {
        if (apods.isEmpty())
            showScreenErrorState()
        else
            setupApodListRecyclerView(apods)
    }

    private fun setupApodListRecyclerView(apods: List<Apod>) {
        hideScreenLoadingState()
        hideScreenErrorState()

        val apodListAdapter = ApodListAdapter()
        apodListAdapter.submitList(apods)

        binding.recyclerViewApodList.apply {
            adapter = apodListAdapter
            setHasFixedSize(true)
            setItemViewCacheSize(DEFAULT_APOD_LIST_ITEM_CACHE)
        }
    }

    private fun hideScreenLoadingState() {
        binding.apply {
            swipeRefreshLayoutApodList.isRefreshing = false
            recyclerViewApodList.isVisible = true
        }
    }

    private fun hideScreenErrorState() {
        binding.apply {
            swipeRefreshLayoutApodList.isRefreshing = false
            layoutApodErrorState.root.isVisible = false
            recyclerViewApodList.isVisible = true
        }
    }

    private fun showScreenErrorState() {
        binding.apply {
            swipeRefreshLayoutApodList.isRefreshing = false
            layoutApodErrorState.root.isVisible = true
            recyclerViewApodList.isVisible = false
        }
    }

    private fun attachSwipeToRefreshOnRefreshListener() {
        binding.swipeRefreshLayoutApodList.setOnRefreshListener {
            fetchApods()
        }
    }

    private fun fetchApods() {
        showScreenLoadingState()
        viewModel.fetchApods()
    }

    private fun showScreenLoadingState() {
        binding.apply {
            swipeRefreshLayoutApodList.isRefreshing = true
            recyclerViewApodList.isVisible = false
        }
    }

    override fun onStart() {
        super.onStart()
        fetchApods()
    }
}
