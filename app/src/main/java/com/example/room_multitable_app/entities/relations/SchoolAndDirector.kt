package com.example.room_multitable_app.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.room_multitable_app.entities.Director
import com.example.room_multitable_app.entities.School



// This is an intermediate class for one to one relation
// A school can only have one director and a director can be associated with only one school

// embedded field is the parent
// relation field is the child
data class SchoolAndDirector(
    @Embedded
    val school:School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val director:Director
)