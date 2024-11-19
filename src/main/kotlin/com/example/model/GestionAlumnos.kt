package com.example.model

object GestionAlumnos {
    private val alumnos = mutableListOf(
        Alumno(
            1, "Juan", "10/04/2003", Curse.DAM1,
            "juan@example.com", listOf<Subject>(Subject.AAD, Subject.EIE, Subject.PSP)
        ),
        Alumno(
            2, "Kai", "04/10/2000", Curse.DAM2,
            "kai@example.com", listOf<Subject>(Subject.AAD, Subject.PMDM)
        ),
        Alumno(
            3, "Alicia", "29/07/2002", Curse.DAM1,
            "alicia@example.com", listOf<Subject>(Subject.DDI, Subject.PSP)
        )
    )

    //si se pone igual no hace falta indicar que devuelve con los :
    fun getStudents() = alumnos
    fun getStudentsporCurso(curso: Curse) = alumnos.filter {
        it.curse == curso
    }

    fun getAlumnoNombre(nombre: String) = alumnos.find {
        it.name.equals(nombre, ignoreCase = true)
    }

    fun getAlumnoId(id: Int) = alumnos.find {
        it.id == id
    }

    fun nuevoAlumno(alumno: Alumno) :Alumno{
        val alumnoFinal=alumno
        //Se comprueba si tiene id y
        //luego te comprueba que no haya otro con el mismo id
        //Si llega nulo se calcula max+1
        // quito esto porque siempre es true:alumno.id != null
        if ( alumno.id>0) {
            val alumnoTmp = getAlumnoId(alumno.id)
            if (alumnoTmp!=null){
                //alumno existe, ya repetido
                throw IllegalArgumentException("¡Este alumno ya existe!")
            }else {
                alumnos.add(alumno)
            }
        } else{
            val maxId = alumnos.maxWith(Comparator.comparingInt{
                it.id
            }).id
            alumno.id= maxId +1
            alumnos.add(alumno)
        }
        return alumnoFinal
    }

    fun deleteAlumno(id:Int) :Boolean{
        for(alumno in alumnos){
            if(alumno.id==id){
                alumnos.remove(alumno)
                return true
            }
        }
        return false
    }
}