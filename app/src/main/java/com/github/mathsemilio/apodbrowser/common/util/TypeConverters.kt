package com.github.mathsemilio.apodbrowser.common.util

import com.github.mathsemilio.apodbrowser.features.apodlist.model.Apod
import com.github.mathsemilio.apodbrowser.features.apodlist.model.ApodSchema

fun ApodSchema.toApod(): Apod {
    return Apod(
        title = title,
        url = url,
        date = date,
        mediaType = mediaType,
        thumbnailUrl = thumbnailUrl
    )
}

fun List<ApodSchema>.toApodList(): List<Apod> {
    val apodList = mutableListOf<Apod>()

    this.forEach { apodSchema ->
        apodList.add(apodSchema.toApod())
    }

    return apodList.toList()
}
