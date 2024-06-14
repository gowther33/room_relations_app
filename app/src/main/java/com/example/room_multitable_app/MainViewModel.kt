package com.example.room_multitable_app

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.room_multitable_app.db.SchoolDatabase
import com.example.room_multitable_app.entities.Director
import com.example.room_multitable_app.entities.School
import com.example.room_multitable_app.entities.Student
import com.example.room_multitable_app.entities.Subject
import com.example.room_multitable_app.entities.relations.StudentSubjectCrossRef
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(app:Application):AndroidViewModel(app) {

    private val db = SchoolDatabase.getInstance(app.applicationContext)

    fun addSchool(school:School){
        viewModelScope.launch(Dispatchers.IO) {
            db.schoolDao.insertSchool(school)
        }
    }

    fun addDirector(director:Director){
        viewModelScope.launch(Dispatchers.IO) {
            db.schoolDao.insertDirector(director)
        }
    }

    fun addStudent(student:Student){
        viewModelScope.launch(Dispatchers.IO) {
            db.schoolDao.insertStudent(student)
        }
    }

    fun addSubject(subject:Subject){
        viewModelScope.launch(Dispatchers.IO) {
            db.schoolDao.insertSubject(subject)
        }
    }

    fun addStudentSubject(row:StudentSubjectCrossRef){
        viewModelScope.launch(Dispatchers.IO) {
            db.schoolDao.insertStudentSubjectCrossRef(row)
        }
    }

}