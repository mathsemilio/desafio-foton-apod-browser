package com.github.mathsemilio.apodbrowser.features.apodlist.model

data class Apod(
    val id: Int = 0,
    val title: String,
    val url: String,
    val date: String,
    val mediaType: String,
    val thumbnailUrl: String?
)
