package com.example.lista_3.ui.recycle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lista_3.R
import com.example.lista_3.ui.data.ExercisesList

class ExercisesListAdapter(private val exerciseLists: List<ExercisesList>) ://private val onClick: (ExerciseList) -> Unit) :
    RecyclerView.Adapter<ExercisesListAdapter.ExerciseViewHolder>() {

    // ViewHolder for ExerciseList items
    class ExerciseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val subjectTextView: TextView = itemView.findViewById(R.id.textViewSubject)
        val gradeTextView: TextView = itemView.findViewById(R.id.textViewGrade)
        val exercisesTextView: TextView = itemView.findViewById(R.id.textViewExerciseCount)
        val listNumberTextView: TextView = itemView.findViewById(R.id.textViewListNumber) // Nowe pole
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_exercises_list, parent, false)
        return ExerciseViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        val exerciseList = exerciseLists[position]
        holder.subjectTextView.text = exerciseList.subject.name
        holder.gradeTextView.text = "Ocena: ${exerciseList.grade}"
        holder.exercisesTextView.text = "Liczba zadań: ${exerciseList.exercises.size}"
        holder.listNumberTextView.text = "Lista ${position + 1}" // Przykładowo numer listy
    }



    override fun getItemCount(): Int = exerciseLists.size
}