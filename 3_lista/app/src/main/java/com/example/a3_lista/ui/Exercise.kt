package com.example.a3_lista.ui

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Exercise(val content: String, val points: Int) : Parcelable
