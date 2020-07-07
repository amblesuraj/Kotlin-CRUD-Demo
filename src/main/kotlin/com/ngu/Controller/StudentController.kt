package com.ngu.Controller

import com.ngu.Model.Student
import com.ngu.Service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import java.lang.IllegalArgumentException
import java.util.*
import javax.validation.Valid

@Controller
class StudentController {
    @Autowired
    lateinit var studentService: StudentService


    @GetMapping(value = ["","/","index"])
    fun index(model: Model) :String {
        model.addAttribute("student",Student())
        model.addAttribute("students",studentService.findAllStudents())
        return "index"
    }

    @GetMapping(value = ["/addStudent"])
    fun addStudent(model: Model) :String {
        model.addAttribute("student",Student())
        model.addAttribute("students",studentService.findAllStudents())
        return "addStudent"
    }

    @PostMapping("/save")
    fun addStudent(@ModelAttribute("student") @Valid student: Student, model: Model,
                   errors : Errors, redirectAttributes: RedirectAttributes) : String{
        if(errors.hasErrors())
        {
            model.addAttribute("error","Something went wrong")
            return "addStudent"
        }
        if(student.id == null){
            studentService.addStudent(student)
            redirectAttributes.addFlashAttribute("msg","Student added Successfully")
            return "redirect:/addStudent?added=${student.id}"
        }
        studentService.addStudent(student)
        redirectAttributes.addFlashAttribute("msg","${student.name} your data Updated Successfully")
        return "redirect:/addStudent?updated=${student.id}"

    }

    @GetMapping("/delete/{id}")
    fun deleteStudent(@PathVariable id : Int , model: Model) : String
    {

        studentService.deleteById(id)

        return "redirect:/?deleted=$id"
    }

    @GetMapping("/update/{id}")
    fun showStudentDetails(@PathVariable id: Int,model: Model) : String {
        model.addAttribute("student",studentService.findById(id))
        return "addStudent"
    }

}