package com.example.room_multitable_app.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(
    tableName = "student"
)
data class Student(
    @PrimaryKey(false)
    val studentName:String,
    val semester:Int,
    val schoolName: String
)
