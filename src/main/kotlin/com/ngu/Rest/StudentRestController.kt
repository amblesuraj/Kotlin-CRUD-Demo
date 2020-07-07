package com.ngu.Rest

import com.ngu.Model.Student
import com.ngu.Service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.util.MimeTypeUtils
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/student/")
class StudentRestController {

    @Autowired
    lateinit var studentService: StudentService

    @PostMapping("saveAll" ,consumes = [MimeTypeUtils.APPLICATION_JSON_VALUE],produces =  [MimeTypeUtils.APPLICATION_JSON_VALUE])
    fun addStudent(@RequestBody students: MutableList<Student>) : String {

        studentService.saveAll(students);
        return "added"
    }

    @PostMapping("addStudent")
    fun addStudent(@RequestBody student: Student) : String {
        student.enable=true
        studentService.addStudent(student);
        return "added"
    }

    @PutMapping("/update")
    fun update(@RequestBody student: Student) : String
    {
        student.enable=true
        studentService.addStudent(student)
        return "updated"
    }



    @GetMapping("/all")
    fun allStudents() : List<Student> = studentService.findAllStudents()

    @GetMapping("/student/{id}")
    fun allStudents(@PathVariable id : Int) : Student = studentService.findById(id)

    @GetMapping("/delete/{id}")
    fun deleteStudent(@PathVariable id : Int) : String {

        studentService.deleteById(id)
        return "deleted"
    }
}