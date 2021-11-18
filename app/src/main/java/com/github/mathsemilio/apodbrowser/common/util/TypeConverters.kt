package com.github.mathsemilio.apodbrowser.common.util

import com.github.mathsemilio.apodbrowser.features.apodlist.model.Apod
import com.github.mathsemilio.apodbrowser.features.apodlist.model.ApodSchema
import com.github.mathsemilio.apodbrowser.features.apodlist.model.CachedApod

fun ApodSchema.toApod(): Apod {
    return Apod(
        title = title,
        url = url,
        date = date,
        mediaType = mediaType,
        thumbnailUrl = thumbnailUrl
    )
}

fun CachedApod.toApod(): Apod {
    return Apod(
        id = id,
        title = title,
        url = url,
        date = date,
        mediaType = mediaType,
        thumbnailUrl = thumbnailUrl
    )
}

@JvmName("toApodListApodSchema")
fun List<ApodSchema>.toApodList(): List<Apod> {
    val apodList = mutableListOf<Apod>()

    this.forEach { apodSchema ->
        apodList.add(apodSchema.toApod())
    }

    return apodList.toList()
}

@JvmName("toApodListCachedApod")
fun List<CachedApod>.toApodList(): List<Apod> {
    val apodList = mutableListOf<Apod>()

    this.forEach { cachedApod ->
        apodList.add(cachedApod.toApod())
    }

    return apodList.toList()
}
