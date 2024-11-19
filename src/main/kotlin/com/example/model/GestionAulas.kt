package com.example.model

object GestionAulas {
    private val aulas: MutableList<Aula> = mutableListOf(
        Aula(1, "Aula 101", Curso.DAM1, 1, "Pabellón A"),
        Aula(2, "Aula 202", Curso.DAM2, 2, "Pabellón B"),
        Aula(3, "Aula 303", Curso.DAW1, 3, "Pabellón C"),
        Aula(4, "Aula 404", Curso.DAW2, 4, "Pabellón D")
    )

    fun getAulas()= aulas
    fun getAulaPorId(id:Int)= aulas.filter {
        it.id==id
    }
    fun getAulasPorCurso(curso:Curso)= aulas.find {
        it.curso==curso
    }

    fun addAula(aula: Aula){
        aulas.add(aula)
    }
    fun deleteAulaPorId(id:Int){
        aulas.removeIf { it.id==id }
    }
}