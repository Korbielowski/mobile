package com.example.ex3.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Subject(var name : String = "") : Parcelable