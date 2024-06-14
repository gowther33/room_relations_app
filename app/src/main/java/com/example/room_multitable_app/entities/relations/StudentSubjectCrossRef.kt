package com.example.room_multitable_app.entities.relations

import androidx.room.Entity


// This is an intermediate class for many to many relation
// A student can take many subjects and a subject can be associated with many students

// We make a bridge table to hold reference to both the entities pk

// For this we need to create two more intermediate classes

@Entity(
    primaryKeys = [
    "studentName",
    "subjectName"
                  ],
    tableName = "studentSubjects"
)
data class StudentSubjectCrossRef(
    val studentName:String,
    val subjectName:String
)
