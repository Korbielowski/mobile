package com.example.a2_lista

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class WelcomeScreen : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        println(arguments?.getString("LOGIN").toString())
        val view = inflater.inflate(R.layout.fragment_welcome_screen, container, false)
        view.findViewById<TextView>(R.id.user).text = arguments?.getString("LOGIN").toString()
        view.findViewById<Button>(R.id.frag_welcome_menu).setOnClickListener {
            val fragment = MainScreen()
            fragment.arguments = arguments
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_container, fragment)?.commit()
        }
        return view
    }
}