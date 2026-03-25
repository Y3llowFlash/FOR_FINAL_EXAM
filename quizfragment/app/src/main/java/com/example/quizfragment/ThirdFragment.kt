package com.example.quizfragment

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class ThirdFragment : Fragment(R.layout.fragment_third) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Toolbar>(R.id.questionToolbar).title =
            getString(R.string.title_question_three)
        view.findViewById<Button>(R.id.check3).setOnClickListener {
            findNavController().navigate(R.id.action_thirdFragment_to_scoreFragment)
        }
    }
}
