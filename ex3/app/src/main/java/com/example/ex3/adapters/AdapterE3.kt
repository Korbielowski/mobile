package com.example.ex3.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ex3.data.ExerciseList
import com.example.ex3.databinding.ExerciseBinding
import com.example.ex3.views.ViewHolderE3


class AdapterE3(private val exerciseList: ExerciseList) :
    RecyclerView.Adapter<ViewHolderE3>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderE3 {
        return ViewHolderE3(
            ExerciseBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ))
    }

    override fun getItemCount(): Int {return exerciseList.exercises.count()}

    override fun onBindViewHolder(holder: ViewHolderE3, position: Int) {
        val currentItem = exerciseList.exercises[position]
        holder.bind(currentItem, position)
    }

}