package com.github.mathsemilio.apodbrowser.features.apodlist.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.github.mathsemilio.apodbrowser.common.CACHED_APOD_TABLE_NAME

@Entity(tableName = CACHED_APOD_TABLE_NAME)
data class Apod(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val url: String,
    val date: String,
    val mediaType: String,
    val thumbnailUrl: String?
)
