package com.example.ex3.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ex3.data.ExerciseList
import com.example.ex3.databinding.ListBinding
import com.example.ex3.views.ViewHolderE2


class AdapterE2(private val exerciseListList: List<ExerciseList>) :
    RecyclerView.Adapter<ViewHolderE2>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderE2 {
        return ViewHolderE2(
            ListBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ))
    }

    override fun getItemCount(): Int {
        return exerciseListList.size
    }

    override fun onBindViewHolder(holder: ViewHolderE2, position: Int) {
        val currentItem = exerciseListList[position]
        holder.bind(currentItem)
    }

}