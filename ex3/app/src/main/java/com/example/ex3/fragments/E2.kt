package com.example.ex3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ex3.adapters.AdapterE2
import com.example.ex3.databinding.E2Binding
import com.example.ex3.views.MainViewModel

class E2 : Fragment() {

    private lateinit var binding: E2Binding
    private val model: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = E2Binding.inflate(inflater)

        binding.recyclerView.apply {
            adapter = AdapterE2(model.getSubjectsSummaryList())
            layoutManager = LinearLayoutManager(context)
        }

        return binding.root
    }
}