package com.github.mathsemilio.apodbrowser.infrastructure.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.github.mathsemilio.apodbrowser.features.apodlist.model.Apod

@Dao
interface ApodCacheDao {

    @Insert
    suspend fun add(apod: Apod)

    @Query("SELECT * FROM cached_apod_table")
    suspend fun fetchCachedApods(): List<Apod>

    @Query("DELETE FROM cached_apod_table")
    suspend fun deleteCache()
}
