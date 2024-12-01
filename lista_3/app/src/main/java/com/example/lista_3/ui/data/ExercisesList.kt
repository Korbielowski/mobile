package com.example.lista_3.ui.data

data class ExercisesList(
    val exercises: List<Exercise>,
    val subject: Subject,
    val grade: Float,
    var listNumber: Int = 0 // New property to store the list number
)

