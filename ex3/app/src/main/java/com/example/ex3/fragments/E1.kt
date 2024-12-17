package com.example.ex3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ex3.adapters.AdapterE1
import com.example.ex3.databinding.E1Binding
import com.example.ex3.views.MainViewModel

class E1 : Fragment() {
    private lateinit var binding: E1Binding
    private val exerciseList: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = E1Binding.inflate(inflater)

        binding.recyclerView.apply {
            adapter = AdapterE1(exerciseList.getList()){
//                Toast.makeText(context, "Clicked + ${it.subject.name} + ${it.index}", Toast.LENGTH_SHORT).show()
                val action = E1Directions.actionE1ToE3(it)
                Navigation.findNavController(requireView()).navigate(action)
            }
            layoutManager = LinearLayoutManager(context)
        }



        return binding.root
    }
}