package com.example.room_multitable_app.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "subject"
)
data class Subject(
    @PrimaryKey
    val subjectName:String
)
