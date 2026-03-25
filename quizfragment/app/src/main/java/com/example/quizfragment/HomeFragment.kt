package com.example.quizfragment

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Toolbar>(R.id.homeToolbar).title = getString(R.string.title_home)
        view.findViewById<Button>(R.id.startBtn).setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_firstFragment)
        }
    }
}
