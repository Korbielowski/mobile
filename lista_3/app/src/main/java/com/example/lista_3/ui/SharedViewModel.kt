package com.example.lista_3.ui

import androidx.lifecycle.ViewModel
import com.example.lista_3.ui.data.ExercisesList

class SharedViewModel : ViewModel() {
    val exerciseList: MutableList<ExercisesList> = mutableListOf()
}