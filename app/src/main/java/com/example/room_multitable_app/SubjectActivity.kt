package com.example.room_multitable_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.room_multitable_app.databinding.ActivitySubjectBinding
import com.example.room_multitable_app.entities.Subject
import com.example.room_multitable_app.entities.relations.StudentSubjectCrossRef

class SubjectActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySubjectBinding
    private val viewModel:MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubjectBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnAddSubject.setOnClickListener {
            val name = binding.etAddSubjectName.text.toString()
            if (name.isNotBlank()){
                viewModel.addSubject(
                    Subject(name)
                )
                Toast.makeText(this, "Subject Added", Toast.LENGTH_LONG).show()
            } else{
                    Toast.makeText(this, "Subject name cannot be empty", Toast.LENGTH_LONG).show()
            }
        }

        binding.btnAddStudentSubject.setOnClickListener {
            val studentName = binding.etStudentSubjectName.text.toString()
            val subjectName = binding.etSubjectName.text.toString()
            if (studentName.isNotBlank() && subjectName.isNotBlank()){
                viewModel.addStudentSubject(
                    StudentSubjectCrossRef(studentName, subjectName)
                )
                Toast.makeText(this, "Student Subject Added", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_LONG).show()
            }
        }


    }
}
