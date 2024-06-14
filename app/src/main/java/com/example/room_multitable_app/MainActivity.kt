package com.example.room_multitable_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.get
import com.example.room_multitable_app.databinding.ActivityMainBinding
import com.example.room_multitable_app.entities.Director
import com.example.room_multitable_app.entities.School
import com.example.room_multitable_app.entities.Student

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val viewModel:MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var studentSchoolSelected = "Army Public"
        var directorSchoolSelected = "Army Public"

        val schoolAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.schools,
            android.R.layout.simple_spinner_item
        ).also {adapter ->  
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }


        // Spinner on click listener
        binding.spinnerSchool.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                studentSchoolSelected = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }


        binding.spinnerDirectorSchool.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                directorSchoolSelected = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }


        binding.spinnerSchool.adapter = schoolAdapter

        binding.spinnerDirectorSchool.adapter = schoolAdapter

        binding.btnAddSchool.setOnClickListener {
            val name = binding.etSchoolName.text.toString()
            if (name.isNotBlank()){
                viewModel.addSchool(
                    School(name)
                )
                Toast.makeText(this, "School Added", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "School Name cannot be empty", Toast.LENGTH_LONG).show()
            }
        }

        binding.btnAddDirector.setOnClickListener {
            val name = binding.etDirectorName.text.toString()
            if (name.isNotBlank()){
                viewModel.addDirector(
                    Director(name, directorSchoolSelected)
                )
                Toast.makeText(this, "Director Added", Toast.LENGTH_LONG).show()

            }else{
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_LONG).show()
            }
        }

        binding.btnAddStudent.setOnClickListener {
            val name = binding.etStudentName.text.toString()
            val semester = binding.etSemester.text.toString()
            if (name.isNotBlank() && semester.isNotBlank()){
                viewModel.addStudent(
                    Student(name, semester.toInt(), studentSchoolSelected)
                )
                Toast.makeText(this, "Student Added", Toast.LENGTH_LONG).show()

            }else{
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_LONG).show()
            }
        }

        binding.btnAddSubjects.setOnClickListener {
            Intent(this,SubjectActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}