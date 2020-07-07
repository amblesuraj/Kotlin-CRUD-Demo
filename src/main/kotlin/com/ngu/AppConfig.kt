package com.ngu

import com.ngu.Model.Student
import com.ngu.Repository.StudentRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class AppConfig(val studentRepository: StudentRepository) : CommandLineRunner{
    override fun run(vararg args: String?) {
        var student1 : Student = Student("The UnderTaker",101,"Ny")
        var student2 : Student = Student("John Cena",102,"America")
        var student3 : Student = Student("Roman Reigns",103,"Florida")
        var student4 : Student = Student("Seth Rolins",104,"Queens")

        var students = mutableListOf<Student>()
        students.add(student1)
        students.add(student2)
        students.add(student3)
        student4.enable=true
        students.add(student4)

        var rock : Student = Student()
        rock.name="The Rock"
        rock.address="miami"
        rock.roll=501
        studentRepository.save(rock)
        println("Rock Saved Successfully ${rock.name}")


        studentRepository.saveAll(students)
        println("Students Saved Successfully ")

        var suraj : Student  = studentRepository.getOne(2)
        suraj.enable=true
        studentRepository.save(suraj)
        println("$student1 Updated Successfully")

    }

}