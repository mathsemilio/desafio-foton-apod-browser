package com.github.mathsemilio.apodbrowser.features.common.manager

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

object ImageResourceManager {

    fun loadFrom(url: String, targetImageView: ImageView) {
        Glide.with(targetImageView)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(targetImageView)
    }
}
