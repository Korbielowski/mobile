package com.example.ex3.views

import androidx.recyclerview.widget.RecyclerView
import com.example.ex3.data.ExerciseList
import com.example.ex3.databinding.ListBinding

class ViewHolderE2(private val binding: ListBinding) :
    RecyclerView.ViewHolder(binding.root){

    fun bind(list_of_exercises: ExerciseList){
        binding.subjectTextView.text = list_of_exercises.subject.name
        binding.listNumTextView.text = "Średnia: " + list_of_exercises.grade.toString()
        binding.exerNumTextView.text = "Liczba list: " + list_of_exercises.listNum.toString()
        binding.gradeTextView.text = ""
    }
}

