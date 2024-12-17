package com.example.ex3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ex3.adapters.AdapterE3
import com.example.ex3.data.ExerciseList
import com.example.ex3.databinding.E3Binding


class E3 : Fragment() {
    private lateinit var binding: E3Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = E3Binding.inflate(inflater)

        val exerciseList = arguments?.getParcelable<ExerciseList>("exerciseList")

        binding.recyclerView.apply {
            adapter = exerciseList?.let { AdapterE3(it) }
            layoutManager = LinearLayoutManager(context)
        }
        binding.TextView.text = exerciseList?.subject?.name + "\nLista " + exerciseList?.index.toString()


        return binding.root
    }
}