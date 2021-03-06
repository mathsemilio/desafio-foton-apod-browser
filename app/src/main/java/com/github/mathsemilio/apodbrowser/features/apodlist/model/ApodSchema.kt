package com.github.mathsemilio.apodbrowser.features.apodlist.model

import com.google.gson.annotations.SerializedName

data class ApodSchema(
    @SerializedName("concept_tags")
    val conceptTags: Boolean,
    val title: String,
    val url: String,
    val date: String,
    @SerializedName("media_type")
    val mediaType: String,
    val explanation: String,
    @SerializedName("thumbnail_url")
    val thumbnailUrl: String?,
    val concepts: List<String>,
    val copyright: String?
)
