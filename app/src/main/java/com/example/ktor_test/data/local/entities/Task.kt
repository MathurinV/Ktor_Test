package com.example.ktor_test.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity
data class Task(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val title: String = "new title",
    val description: String = "new description",
    val isDone: Boolean = false
)