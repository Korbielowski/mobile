package com.example.a3_lista.ui
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a3_lista.R
import com.example.a3_lista.ui.ExerciseList

class ExerciseListAdapter(private val exerciseLists: List<ExerciseList>) ://private val onClick: (ExerciseList) -> Unit) :
    RecyclerView.Adapter<ExerciseListAdapter.ExerciseViewHolder>() {

    // ViewHolder for ExerciseList items
    class ExerciseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val subjectTextView: TextView = itemView.findViewById(R.id.textViewSubject)
        val gradeTextView: TextView = itemView.findViewById(R.id.textViewGrade)
        val exercisesTextView: TextView = itemView.findViewById(R.id.textViewExercises)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_exercise_list, parent, false)
        return ExerciseViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        val exerciseList = exerciseLists[position]
        holder.subjectTextView.text = exerciseList.subject.name
        holder.gradeTextView.text = "Grade: ${exerciseList.grade}"
        holder.exercisesTextView.text = exerciseList.exercises.joinToString(", ") {
            "${it.points} (${it.content})"
        }

        // Set a click listener to notify when the item is clicked
//        holder.itemView.setOnClickListener {
//            onClick(exerciseList)
//        }
    }

    override fun getItemCount(): Int = exerciseLists.size
}

