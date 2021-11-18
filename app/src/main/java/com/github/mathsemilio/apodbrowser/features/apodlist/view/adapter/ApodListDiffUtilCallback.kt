package com.github.mathsemilio.apodbrowser.features.apodlist.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.github.mathsemilio.apodbrowser.features.apodlist.model.Apod

class ApodListDiffUtilCallback : DiffUtil.ItemCallback<Apod>() {

    override fun areItemsTheSame(oldItem: Apod, newItem: Apod): Boolean {
        return oldItem.date == newItem.date
    }

    override fun areContentsTheSame(oldItem: Apod, newItem: Apod): Boolean {
        return oldItem == newItem
    }
}
