package com.example.lista_3.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.lista_3.databinding.FragmentDashboardBinding
import com.example.lista_3.ui.data.ExercisesList
import com.example.lista_3.ui.SharedViewModel

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Access SharedViewModel
        sharedViewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
        val exerciseList = sharedViewModel.exerciseList

        // Calculate average grades per subject
        val averagesBySubject = calculateAverageGradesBySubject(exerciseList)

        // Display averages in a TextView
        val averageText = averagesBySubject.entries.joinToString("\n") { (subject, average) ->
            "$subject: ${"%.2f".format(average)}"
        }
        binding.textDashboard.text = averageText

        return root
    }

    private fun calculateAverageGradesBySubject(exerciseLists: List<ExercisesList>): Map<String, Float> {
        val subjectToGrades = mutableMapOf<String, MutableList<Float>>()

        for (exerciseList in exerciseLists) {
            val subjectName = exerciseList.subject.name
            subjectToGrades.computeIfAbsent(subjectName) { mutableListOf() }.add(exerciseList.grade)
        }

        return subjectToGrades.mapValues { (_, grades) ->
            grades.average().toFloat()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
