package com.example.room_multitable_app.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(
    tableName = "school"
)
data class School(
    @PrimaryKey(false)
    val schoolName:String
)
