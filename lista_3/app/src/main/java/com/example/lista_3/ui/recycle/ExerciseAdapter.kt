//package com.example.lista_3.ui.recycle
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.example.lista_3.R
//import com.example.lista_3.ui.recycle.ExercisesListAdapter.ExerciseViewHolder
//
//class ExerciseAdapter {
//    class ExerciseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val subjectTextView: TextView = itemView.findViewById(R.id.textViewSubject)
//        val gradeTextView: TextView = itemView.findViewById(R.id.textViewGrade)
//        val exercisesTextView: TextView = itemView.findViewById(R.id.textViewExerciseCount)
//        val listNumberTextView: TextView = itemView.findViewById(R.id.textViewListNumber) // Nowe pole
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): com.example.lista_3.ui.recycle.ExercisesListAdapter.ExerciseViewHolder {
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.item_exercises_list, parent, false)
//        return ExerciseViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: com.example.lista_3.ui.recycle.ExercisesListAdapter.ExerciseViewHolder, position: Int) {
//
//        // Map to track list numbering for each subject
////        val subjectCountMap = mutableMapOf<String, Int>()
//
//        // Subject name
////        val subjectName = exerciseList.subject.name
//
//        // Increment or initialize the count for this subject
////        val listNumber = subjectCountMap.getOrDefault(subjectName, 0) + 1
////        subjectCountMap[subjectName] = listNumber
//
//        val exerciseList = exerciseLists[position]
//        holder.subjectTextView.text = exerciseList.subject.name
//        holder.gradeTextView.text = "Ocena: ${exerciseList.grade}"
//        holder.exercisesTextView.text = "Liczba zadań: ${exerciseList.exercises.size}"
//        holder.listNumberTextView.text = "Lista ${exerciseList.listNumber}" // Use the precomputed list number
//    }
//
//}