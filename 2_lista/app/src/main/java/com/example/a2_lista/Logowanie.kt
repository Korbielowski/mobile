package com.example.a2_lista

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class Logowanie : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_logowanie, container, false)
        view.findViewById<Button>(R.id.frag_log_log).setOnClickListener {
            val login = view.findViewById<EditText>(R.id.frag_log_login).text.toString()
            val password = view.findViewById<EditText>(R.id.frag_log_haslo).text.toString()
            val password_form_state = arguments?.getString(login).toString()
            println(login)
            println(password)
            println(password_form_state)
            if(password.equals(password_form_state)){
                arguments?.putString("LOGIN", login)
                val fragment = WelcomeScreen()
                fragment.arguments = arguments
                val transaction = fragmentManager?.beginTransaction()
                transaction?.replace(R.id.nav_container, fragment)?.commit()
            }
        }
        view.findViewById<Button>(R.id.frag_log_menu).setOnClickListener {
            val fragment = MainScreen()
            fragment.arguments = arguments
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_container, fragment)?.commit()
        }
        return view
    }
}