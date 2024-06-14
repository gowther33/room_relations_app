package com.example.room_multitable_app.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.room_multitable_app.entities.School
import com.example.room_multitable_app.entities.Student

// This is an intermediate class for one to many relation
// A school can have many students but a student can only be in one school

// embedded field is the one with multiple holding entity (school)
// relation field is one associated with many
data class SchoolWithStudents(
    @Embedded
    val school:School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    ) val student:List<Student>
)
