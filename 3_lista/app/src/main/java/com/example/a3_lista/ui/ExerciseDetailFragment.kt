package com.example.a3_lista.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a3_lista.databinding.FragmentExerciseDetailBinding

class ExerciseDetailFragment : Fragment() {

    private var _binding: FragmentExerciseDetailBinding? = null
    private val binding get() = _binding!!

    // Retrieve the ExerciseList passed to the fragment
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExerciseDetailBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Get the ExerciseList passed from the previous fragment
//        val exerciseList = arguments?.getParcelable<ExerciseList>("exerciseList")

        // Check if exerciseList is null (this shouldn't happen unless an error occurs)
//        if (exerciseList != null) {
//            // Populate the UI with the exercises data
//            val exerciseAdapter = ExerciseAdapter(exerciseList.exercises)
//            binding.recyclerViewExercises.adapter = exerciseAdapter
//            binding.recyclerViewExercises.layoutManager = LinearLayoutManager(requireContext())
//        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

