package com.example.quizfragment

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class SecondFragment : Fragment(R.layout.fragment_second) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Toolbar>(R.id.questionToolbar).title =
            getString(R.string.title_question_two)
        view.findViewById<Button>(R.id.check2).setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_thirdFragment)
        }
    }
}
