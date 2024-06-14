package com.example.room_multitable_app.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(
    tableName = "director"
)
data class Director(
    @PrimaryKey(false)
    val directorName:String,
    val schoolName:String
)
