package com.example.quizfragment

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class ScoreFragment : Fragment(R.layout.fragment_score) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.playAgainBtn).setOnClickListener {
            findNavController().navigate(R.id.action_scoreFragment_to_homeFragment)
        }
    }
}
