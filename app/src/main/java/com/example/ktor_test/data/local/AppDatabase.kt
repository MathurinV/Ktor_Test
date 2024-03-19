package com.example.ktor_test.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.ktor_test.data.local.daos.TaskDao
import com.example.ktor_test.data.local.entities.Task

@Database(entities = [Task::class], version = 1)
@TypeConverters(UUIDTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun myEntityDao(): TaskDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) {
                Room.databaseBuilder(context, AppDatabase::class.java, "app_database")
                    .build()
                    .also { instance = it }
            }
    }
}