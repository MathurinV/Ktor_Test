package com.example.ktor_test.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Message(
    @PrimaryKey
    val messageId: String,
    val userId: String,
    val content: String
)