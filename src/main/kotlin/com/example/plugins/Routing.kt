package com.example.plugins

import com.example.model.Curse
import com.example.model.GestionAlumnos
import com.example.model.Alumno
import com.example.model.Genero
import com.example.model.GestionPeliculas
import io.ktor.serialization.JsonConvertException
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.request.receive
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        // Static plugin. Try to access `/static/index.html`
        staticResources("/static", "static")
        get("/") {
            call.respondText("HEY CLASSS!!!")
        }

        route("/alumnos") {
            get("/alumnos") {
                call.respond(
                    GestionAlumnos.getStudents()
                )
            }
            get("/alumnos/{curso}") {
                val cursoTxt = call.pathParameters["curso"]
                val curso = Curse.valueOf(cursoTxt!!)
                val alumnos = GestionAlumnos.getStudentsporCurso(curso)
                if (alumnos.isEmpty()) {
                    call.respondText(" No se han encontrado alumnos ")
                } else {
                    call.respond(alumnos)
                }
            }
            get("/nombre/{paramNombre}") {
                val nombre = call.parameters["paramNombre"]
                if (nombre == null) {
                    call.respondText("El parámetro de búsqueda es obligatorio")
                } else {
                    val alumno = GestionAlumnos.getAlumnoNombre(nombre)
                    if (alumno == null) {
                        call.respondText("No se ha encontrado ningún resultado.")
                    } else {
                        call.respond(alumno)
                    }
                }
            }
            get("/delete/{idAlumno}") {
                val idAlumno = call.pathParameters["idAlumno"]
                if (idAlumno != null) {
                    if (GestionAlumnos.deleteAlumno(idAlumno.toInt())) {
                        call.respondText("Alumno con id $idAlumno se ha eliminado correctamente")
                    } else {
                        call.respondText("No se encuentra el alumno con id $idAlumno")
                    }
                } else {
                    call.respondText("No se han introducido datos")
                }
            }
            delete("/eliminar/{idAlumno}") {
                val idAlumno = call.parameters["idAlumno"]
                if (idAlumno != null) {
                    if (GestionAlumnos.deleteAlumno(idAlumno.toInt())) {
                        call.respondText("Alumno con id $idAlumno se ha eliminado correctamente")
                    } else {
                        call.respondText("No se encuentra el alumno con id $idAlumno")
                    }
                } else {
                    call.respondText("No se han introducido datos")
                }
            }
            post {
                try {
                    val alumno = call.receive<Alumno>()
                    val alumnoInsertado = GestionAlumnos.nuevoAlumno(alumno)
                    call.respond(alumnoInsertado)
                } catch (jsone: JsonConvertException) {
                    call.respondText("¡Datos inválidos!")
                } catch (ise: IllegalStateException) {
                    call.respondText(ise.message.toString())
                }
            }
        }

        route("/peliculas")
        {
            get() {
                call.respond(GestionPeliculas.getPeliculas())
            }
            get("/peliculas/genero/{genero}"){
                val gereroTxt= call.pathParameters["genero"]
                val genero=Genero.valueOf(gereroTxt!!)
                val peliculas = GestionPeliculas.getPeliculaPorGenero(genero)
                if (peliculas.isEmpty()) {
                    call.respondText(" No se han encontrado peliculas con ese genero ")
                } else {
                    call.respond(peliculas)
                }
            }
        }
    }
}
