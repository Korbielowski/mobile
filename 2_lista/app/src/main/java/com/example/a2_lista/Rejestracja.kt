package com.example.a2_lista

import android.icu.util.BuddhistCalendar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.FragmentActivity


class Rejestracja : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_rejestracja, container, false)
        view.findViewById<Button>(R.id.frag_rej_rej).setOnClickListener {
            val password = view.findViewById<EditText>(R.id.frag_rej_haslo).text.toString()
            val repeat_password = view.findViewById<EditText>(R.id.frag_rej_pow_haslo).text.toString()
            val login = view.findViewById<EditText>(R.id.frag_rej_login).text.toString()

            if(password.equals(repeat_password)){
                val fragment = Logowanie()
                if(arguments == null) {
                    val bundle = Bundle()
                    bundle.putString(login, password)
                    fragment.arguments = bundle
                }else{
                    arguments?.putString(login, password)
                    fragment.arguments = arguments
                }
                val transaction = parentFragmentManager.beginTransaction()
                transaction.replace(R.id.nav_container, fragment).addToBackStack(null).commit()
            }
        }
        view.findViewById<Button>(R.id.frag_rej_menu).setOnClickListener {
            val fragment = MainScreen()
            fragment.arguments = arguments
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_container, fragment)?.commit()
        }
        return view
    }

}