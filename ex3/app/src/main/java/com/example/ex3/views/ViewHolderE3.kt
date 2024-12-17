package com.example.ex3.views

import androidx.recyclerview.widget.RecyclerView
import com.example.ex3.data.Exercise
import com.example.ex3.databinding.ExerciseBinding

class ViewHolderE3(private val binding: ExerciseBinding) :
    RecyclerView.ViewHolder(binding.root){

    fun bind(exercise: Exercise, position: Int){
        binding.taskNumTextView.text = "Zadanie " + (position+1).toString()
        binding.pointsTextView.text = "pkt: " + exercise.points
        binding.exerciseTextView.text = exercise.content
    }
}

