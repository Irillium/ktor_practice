package com.example.model
import kotlinx.serialization.Serializable

enum class Curse { DAM1, DAM2 }
enum class Subject { EIE, PSP, AAD, PMDM, DDI }
@Serializable
data class Alumno(
    var id: Int,
    val name: String,
    val dateBirth: String,
    val curse: Curse,
    val email: String,
    val subject: List<Subject>
)