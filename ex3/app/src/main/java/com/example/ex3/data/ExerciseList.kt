package com.example.ex3.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ExerciseList(
    var exercises: MutableList<Exercise> = mutableListOf(),
    var subject: Subject = Subject(),
    var grade: Float = 0.0f,
    var listNum: Int = 0,
    var index: Int = 0
) : Parcelable