package com.example.lista_3.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.lista_3.databinding.FragmentHomeBinding
import com.example.lista_3.ui.data.Exercise
import com.example.lista_3.ui.data.ExercisesList
import com.example.lista_3.ui.data.Subject
import com.example.lista_3.ui.recycle.ExercisesListAdapter
import kotlin.random.Random

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    fun create_exercise_list(): MutableList<ExercisesList>{
        val exercises_list : MutableList<ExercisesList> = mutableListOf()
        for(i in 0..20){
            val subject: String = subjects[Random.nextInt(0, 5)]
            val exercises: MutableList<Exercise> = mutableListOf()
            val grade = 3.0f + Random.nextInt(((5.0f - 3.0f) / 0.5f).toInt() + 1) * 0.5f
            for(j in 1..Random.nextInt(1, 11)){
                val ranscore = Random.nextInt(1, 11)
                exercises.add(Exercise("prodigy", ranscore))
            }
            exercises_list.add(ExercisesList(exercises, Subject(subject), grade))
        }
        return exercises_list
    }

    private val binding get() = _binding!!
    private val subjects : List<String> = listOf("Matematyka", "Pum", "Fizyka", "Elektronika", "Algorytmy")
    private val exercise_list : MutableList<ExercisesList> = create_exercise_list()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        val recyclerView = binding.recyclerViewExercises
        recyclerView.adapter = ExercisesListAdapter(exercise_list)
        recyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(requireContext())
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}