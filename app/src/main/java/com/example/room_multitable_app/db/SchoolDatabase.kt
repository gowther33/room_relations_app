package com.example.room_multitable_app.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.room_multitable_app.entities.Director
import com.example.room_multitable_app.entities.School
import com.example.room_multitable_app.entities.Student
import com.example.room_multitable_app.entities.Subject
import com.example.room_multitable_app.entities.relations.StudentSubjectCrossRef

@Database(
    entities = [
        Director::class,
        School::class,
        Student::class,
        Subject::class,
        StudentSubjectCrossRef::class
    ],
    version = 1
)
abstract class SchoolDatabase:RoomDatabase() {

    abstract val schoolDao:SchoolDao

    companion object{

        @Volatile
        private var INSTANCE:SchoolDatabase? = null

        fun getInstance(context: Context):SchoolDatabase{
            synchronized(this){
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    SchoolDatabase::class.java,
                    "school_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }

}