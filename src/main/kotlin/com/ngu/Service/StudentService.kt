package com.ngu.Service

import com.ngu.Model.Student
import java.util.*

interface StudentService {
    fun saveAll(students : MutableList<Student>) : List<Student>
    fun addStudent(student : Student) :Student
    fun findAllStudents() : List<Student>
    fun deleteById(id : Int)
    fun findById(id : Int): Student
    fun findByStudentId(id : Int): Optional<Student>

}