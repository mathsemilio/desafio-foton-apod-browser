package com.github.mathsemilio.apodbrowser.features.apodlist.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.mathsemilio.apodbrowser.R
import com.github.mathsemilio.apodbrowser.common.APOD_TYPE_IMAGE
import com.github.mathsemilio.apodbrowser.common.APOD_TYPE_VIDEO
import com.github.mathsemilio.apodbrowser.common.EXCEPTION_ILLEGAL_APOD_TYPE
import com.github.mathsemilio.apodbrowser.databinding.ApodListItemBinding
import com.github.mathsemilio.apodbrowser.features.apodlist.model.Apod
import com.github.mathsemilio.apodbrowser.features.common.manager.ImageResourceManager

class ApodListAdapter : ListAdapter<Apod, ApodListAdapter.ViewHolder>(ApodListDiffUtilCallback()) {

    inner class ViewHolder(
        private val binding: ApodListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(apod: Apod) {
            loadApodImageBasedOnApodType(apod)

            binding.textViewApodTitle.text = apod.title

            setApodMediaTypeFrom(apod.mediaType)
        }

        private fun loadApodImageBasedOnApodType(apod: Apod) {
            when (apod.mediaType) {
                APOD_TYPE_IMAGE -> ImageResourceManager.loadFrom(apod.url, binding.imageViewApod)
                APOD_TYPE_VIDEO -> {
                    apod.thumbnailUrl?.let { url ->
                        ImageResourceManager.loadFrom(url, binding.imageViewApod)
                    }
                }
            }
        }

        private fun setApodMediaTypeFrom(mediaType: String) {
            binding.textViewApodType.text = when (mediaType) {
                APOD_TYPE_IMAGE -> itemView.context.getString(R.string.apod_type_image)
                APOD_TYPE_VIDEO -> itemView.context.getString(R.string.apod_type_video)
                else -> throw IllegalArgumentException(EXCEPTION_ILLEGAL_APOD_TYPE)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ApodListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
