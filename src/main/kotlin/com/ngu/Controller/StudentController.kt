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
import javax.validation.Valid

@Controller
class StudentController {
    @Autowired
    lateinit var stduentService: StudentService


    @GetMapping(value = ["","/","index"])
    fun index(model: Model) :String {
        model.addAttribute("student",Student())
        model.addAttribute("students",stduentService.findAllStudents())
        return "index"
    }
    @PostMapping("/save")
    fun addStudent(@ModelAttribute("student") @Valid student: Student, model: Model,
                   errors : Errors, redirectAttributes: RedirectAttributes) : String{
        if(errors.hasErrors())
        {
            model.addAttribute("msg","Something went wrong")
            return "index"
        }

        stduentService.addStudent(student)
        redirectAttributes.addFlashAttribute("msg","Student added Successfully")
        return "redirect:/?added=${student.id}"
    }

    @DeleteMapping("/delete/{id}")
    fun deleteStudent(@PathVariable id : Int , model: Model) : String
    {
        stduentService.deleteById(id)
        return "redirect:/?deleted=$id"
    }
}