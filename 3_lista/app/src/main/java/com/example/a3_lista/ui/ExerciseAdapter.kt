package com.example.a3_lista.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a3_lista.R

//class ExerciseAdapter(private val exercises: List<Exercise>) :
//    RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder>() {
//
//    // ViewHolder for exercises
//    class ExerciseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val taskNameTextView: TextView = itemView.findViewById(R.id.textViewTaskName)
//        val pointsTextView: TextView = itemView.findViewById(R.id.textViewPoints)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.item_exercise, parent, false)
//        return ExerciseViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
//        val exercise = exercises[position]
//        holder.taskNameTextView.text = exercise.content
//        holder.pointsTextView.text = "Points: ${exercise.points}"
//    }
//
//    override fun getItemCount(): Int = exercises.size
//}
