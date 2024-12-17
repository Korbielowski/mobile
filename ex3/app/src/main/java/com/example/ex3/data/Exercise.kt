package com.example.ex3.data


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Exercise(var content : String, var points : Int) : Parcelable