package com.example.model

object GestionPeliculas {
    private val peliculas = mutableListOf(
        Pelicula(
            id = 1,
            titulo = "El Misterio en la Niebla",
            sinopsis = "Un pequeño pueblo queda envuelto en un misterio tras la desaparición de varios habitantes en una noche de niebla densa.",
            duracion = 120,
            genero = listOf(Genero.MISTERIO, Genero.DRAMA),
            fecha_estreno = "2023-10-15",
            directores = listOf(Director.Scott),
            guionistas = listOf(Gionista.Gionista1, Gionista.Gionista3),
            elenco = listOf(Actor.Actor1, Actor.Actriz1, Actor.Actor3)
        ),
        Pelicula(
            id = 2,
            titulo = "Rápido y Letal",
            sinopsis = "Un agente secreto debe infiltrarse en una organización criminal que utiliza autos de alta velocidad para ejecutar sus planes.",
            duracion = 110,
            genero = listOf(Genero.ACCION, Genero.TERROR),
            fecha_estreno = "2024-06-10",
            directores = listOf(Director.Spieilverg),
            guionistas = listOf(Gionista.Gionista2, Gionista.Gionista4),
            elenco = listOf(Actor.Actor2, Actor.Actriz2, Actor.Actor3)
        ),
        Pelicula(
            id = 3,
            titulo = "Sueños de Papel",
            sinopsis = "Una joven escritora lucha por encontrar su voz en una industria despiadada mientras enfrenta sus propios demonios internos.",
            duracion = 95,
            genero = listOf(Genero.DRAMA, Genero.COMEDIA),
            fecha_estreno = "2024-02-20",
            directores = listOf(Director.Scorcesse),
            guionistas = listOf(Gionista.Gionista3, Gionista.Gionista4),
            elenco = listOf(Actor.Actor1, Actor.Actriz3, Actor.Actriz1)
        )
    )

    fun getPeliculas() = peliculas
    fun getPeliculaPorGenero(generoParam:Genero)= peliculas.filter {
      it.genero.contains(generoParam)
    }
}