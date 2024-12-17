package com.example.ex3.views

import androidx.recyclerview.widget.RecyclerView
import com.example.ex3.data.ExerciseList
import com.example.ex3.databinding.ListBinding

class ViewHolderE1(
    private val binding: ListBinding,
    onItemClick: (Int) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {
    init {
        itemView.setOnClickListener {
            onItemClick(adapterPosition)
        }
    }

    fun bind(list_of_exercises: ExerciseList){
        binding.subjectTextView.text = list_of_exercises.subject.name
        binding.listNumTextView.text = "Lista: " + list_of_exercises.listNum.toString()
        binding.exerNumTextView.text = "Liczba zadań: " + list_of_exercises.exercises.count().toString()
        binding.gradeTextView.text = "Ocena: " + list_of_exercises.grade.toString()
    }
}
