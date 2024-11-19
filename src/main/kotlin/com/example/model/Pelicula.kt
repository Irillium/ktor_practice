package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class Pelicula (
    val id:Int,
    val titulo:String,
    val sinopsis:String,
    val duracion:Int,
    val genero:List<Genero>,
    val fecha_estreno:String,
    val directores: List<Director>,
    val guionistas:List<Gionista>,
    val elenco:List<Actor>
    )
enum class Genero {
    ACCION, DRAMA, ANIMACION, TERROR, MISTERIO,COMEDIA
}
enum class Pais{
    ESPANIA, EEUU, UK,ITALIA,INDIA,COREA,JAPON, ARGENTINA
}
enum class Director{
    Scorcesse, Spieilverg, Scott
}
enum class Gionista{
    Gionista1,Gionista2,Gionista3,Gionista4
}
enum class Actor{
    Actor1,Actor2,Actor3,Actriz1,Actriz2,Actriz3
}