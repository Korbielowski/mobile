package com.example.ex3.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ex3.data.ExerciseList
import com.example.ex3.databinding.ListBinding
import com.example.ex3.views.ViewHolderE1


class AdapterE1(
    private val exerciseListList: List<ExerciseList>,
    private val onItemClick: (ExerciseList) -> Unit
) : RecyclerView.Adapter<ViewHolderE1>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderE1 {
        return ViewHolderE1(
            ListBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        ){onItemClick(exerciseListList[it])}
    }

    override fun getItemCount(): Int {
        return exerciseListList.size
    }

    override fun onBindViewHolder(holder: ViewHolderE1, position: Int) {
        val currentItem = exerciseListList[position]
        holder.bind(currentItem)
    }

}