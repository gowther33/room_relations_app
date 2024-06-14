package com.example.room_multitable_app.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.room_multitable_app.entities.Student
import com.example.room_multitable_app.entities.Subject

data class StudentWithSubjects(
    @Embedded val student:Student,
    @Relation(
        parentColumn = "studentName",
        entityColumn = "subjectName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    ) val subjects:List<Subject>
)