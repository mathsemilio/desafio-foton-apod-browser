package com.github.mathsemilio.apodbrowser.infrastructure.storage.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.github.mathsemilio.apodbrowser.common.APOD_CACHE_DATABASE
import com.github.mathsemilio.apodbrowser.features.apodlist.model.Apod
import com.github.mathsemilio.apodbrowser.infrastructure.storage.dao.ApodCacheDao

@Database(entities = [Apod::class], version = 1, exportSchema = false)
abstract class ApodCacheDatabase : RoomDatabase() {

    abstract val apodCacheDao: ApodCacheDao

    companion object {
        private val LOCK = Any()

        @Volatile
        private var INSTANCE: ApodCacheDatabase? = null

        fun getDatabase(context: Context): ApodCacheDatabase {
            val tempInstance = INSTANCE

            if (tempInstance != null)
                return tempInstance

            synchronized(LOCK) {
                val databaseInstance = Room.databaseBuilder(
                    context.applicationContext,
                    ApodCacheDatabase::class.java,
                    APOD_CACHE_DATABASE
                ).build()

                INSTANCE = databaseInstance
                return INSTANCE!!
            }
        }
    }
}
