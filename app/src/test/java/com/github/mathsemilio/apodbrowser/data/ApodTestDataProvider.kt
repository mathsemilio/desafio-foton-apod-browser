package com.github.mathsemilio.apodbrowser.data

import com.github.mathsemilio.apodbrowser.features.apodlist.model.Apod

object ApodTestDataProvider {

    val apods = listOf(
        Apod(
            id = 1,
            title = "Geminids from Gemini",
            url = "https://apod.nasa.gov/apod/image/2111/Geminids2020_WangJin_960.jpg",
            date = "2021-11-16",
            mediaType = "image",
            thumbnailUrl = null
        ),
        Apod(
            id = 2,
            title = "NGC 3314: When Galaxies Overlap",
            url = "https://apod.nasa.gov/apod/image/2111/NGC3314_HubbleOstling_960.jpg",
            date = "2021-11-17",
            mediaType = "image",
            thumbnailUrl = null
        ),
        Apod(
            id = 3,
            title = "Full Moonlight",
            url = "https://apod.nasa.gov/apod/image/2111/moonwalk1c1024.jpg",
            date = "2021-11-18",
            mediaType = "image",
            thumbnailUrl = null
        )
    )
}
