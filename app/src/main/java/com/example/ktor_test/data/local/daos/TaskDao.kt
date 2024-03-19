package com.example.ktor_test.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.ktor_test.data.local.entities.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Insert
    suspend fun insert(task: Task)

    @Query("SELECT * FROM Task")
    fun getAllEntities(): Flow<List<Task>>
}