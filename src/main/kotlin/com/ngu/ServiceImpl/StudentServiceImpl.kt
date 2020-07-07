package com.ngu.ServiceImpl

import com.ngu.Model.Student
import com.ngu.Repository.StudentRepository
import com.ngu.Service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class StudentServiceImpl : StudentService {

    @Autowired
    lateinit var studentRepository: StudentRepository

    override fun saveAll(students : MutableList<Student>): List<Student> = studentRepository.saveAll(students)

    override fun addStudent(student: Student): Student = studentRepository.save(student)

    override fun findAllStudents(): List<Student> = studentRepository.findAll()

    override fun deleteById(id : Int) {
        studentRepository.deleteById(id)
    }

    override fun findById(id : Int): Student {
        return studentRepository.getOne(id)
    }


}