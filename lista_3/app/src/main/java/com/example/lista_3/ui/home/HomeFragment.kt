package com.example.lista_3.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lista_3.databinding.FragmentHomeBinding
import com.example.lista_3.ui.data.Exercise
import com.example.lista_3.ui.data.ExercisesList
import com.example.lista_3.ui.data.Subject
import com.example.lista_3.ui.recycle.ExercisesListAdapter
import com.example.lista_3.ui.SharedViewModel
import kotlin.random.Random

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var sharedViewModel: SharedViewModel

    private val subjects: List<String> = listOf("Matematyka", "Pum", "Fizyka", "Elektronika", "Algorytmy")

    private fun createExerciseList(): MutableList<ExercisesList> {
        val exercisesList: MutableList<ExercisesList> = mutableListOf()
        for (i in 0..20) {
            val subject = subjects[Random.nextInt(subjects.size)]
            val exercises: MutableList<Exercise> = mutableListOf()
            val grade = 3.0f + Random.nextInt(((5.0f - 3.0f) / 0.5f).toInt() + 1) * 0.5f
            for (j in 1..Random.nextInt(1, 11)) {
                val randomScore = Random.nextInt(1, 11)
                exercises.add(Exercise("Exercise $j", randomScore))
            }
            exercisesList.add(ExercisesList(exercises, Subject(subject), grade))
        }
        return exercisesList
    }

    private fun assignListNumbersBySubject(exerciseLists: MutableList<ExercisesList>) {
        val subjectCountMap = mutableMapOf<String, Int>()
        for (exerciseList in exerciseLists) {
            val subjectName = exerciseList.subject.name
            val listNumber = subjectCountMap.getOrDefault(subjectName, 0) + 1
            subjectCountMap[subjectName] = listNumber
            exerciseList.listNumber = listNumber
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Initialize SharedViewModel
        sharedViewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]

        // Populate exercise list in SharedViewModel
        if (sharedViewModel.exerciseList.isEmpty()) {
            sharedViewModel.exerciseList.addAll(createExerciseList())
            assignListNumbersBySubject(sharedViewModel.exerciseList)
        }

        // Set up RecyclerView
        val recyclerView = binding.recyclerViewExercises
        recyclerView.adapter = ExercisesListAdapter(sharedViewModel.exerciseList)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
