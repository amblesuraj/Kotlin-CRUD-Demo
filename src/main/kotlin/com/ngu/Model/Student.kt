package com.ngu.Model

import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
@Table(name = "student")
data class Student(
                    @get: NotBlank(message = "Student Name Should not be empty")
                    var name : String = "",
                    @get:NotNull(message = "Student Roll nuber Should not be empty")
                    var roll : Int = 0,

                    var address : String? = null
            ) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Int? = null

    @get:NotBlank(message = "Enable Should be checked")
    var enable : Boolean = false
}