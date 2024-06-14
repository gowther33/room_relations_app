package com.example.room_multitable_app.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.room_multitable_app.entities.Director
import com.example.room_multitable_app.entities.School
import com.example.room_multitable_app.entities.Student
import com.example.room_multitable_app.entities.Subject
import com.example.room_multitable_app.entities.relations.SchoolAndDirector
import com.example.room_multitable_app.entities.relations.SchoolWithStudents
import com.example.room_multitable_app.entities.relations.StudentSubjectCrossRef
import com.example.room_multitable_app.entities.relations.StudentWithSubjects
import com.example.room_multitable_app.entities.relations.SubjectWithStudents

@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school:School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director:Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student:Student)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(subject: Subject)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudentSubjectCrossRef(crossRef:StudentSubjectCrossRef)


    @Transaction
    @Query("SELECT * FROM school WHERE schoolName =:schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName:String):List<SchoolAndDirector>


    @Transaction
    @Query("SELECT * FROM school WHERE schoolName =:schoolName")
    suspend fun getSchoolWithStudents(schoolName:String):List<SchoolWithStudents>


    @Transaction
    @Query("SELECT * FROM subject WHERE subjectName =:subjectName")
    suspend fun getStudentsOfSubject(subjectName:String):List<SubjectWithStudents>


    @Transaction
    @Query("SELECT * FROM student WHERE studentName =:studentName")
    suspend fun getSubjectsOfStudent(studentName:String):List<StudentWithSubjects>
}