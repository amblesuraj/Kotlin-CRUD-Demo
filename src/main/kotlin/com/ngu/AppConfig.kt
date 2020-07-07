package com.ngu

import com.ngu.Model.Student
import com.ngu.Repository.StudentRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class AppConfig(val studentRepository: StudentRepository) : CommandLineRunner{
    override fun run(vararg args: String?) {
        var student1 : Student = Student("Suraj Amble",101,"kuruli")
        var student2 : Student = Student("John Cena",102,"America")
        var student3 : Student = Student("Priya Sharma",103,"Pune")
        var student4 : Student = Student("Tanvi Hegde",104,"Mumbai")

        var students = mutableListOf<Student>()
        students.add(student1)
        students.add(student2)
        students.add(student3)
        students.add(student4)

        var rock : Student = Student()
        rock.name="Rock Dwyene Johnson"
        rock.address="miami"
        rock.roll=501
        studentRepository.save(rock)
        println("Rock Saved Successfully ${rock.name}")


        studentRepository.saveAll(students)
        println("Students Saved Successfully ")

        var suraj : Student  = studentRepository.getOne(2)
        suraj.enable=true
        studentRepository.save(suraj)
        println("Suraj Updated Successfully")

    }

}