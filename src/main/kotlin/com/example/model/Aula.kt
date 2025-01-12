package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class Aula (
    val id:Int,
    val denominacion:String,
    val curso:Curso,
    val piso:Int,
    val pabellon:String
)
