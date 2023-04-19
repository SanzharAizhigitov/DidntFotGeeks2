package com.geektech.dadsquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.geektech.dadsquiz.databinding.FragmentQ5Binding
import com.geektech.dadsquiz.databinding.FragmentQ6Binding

class Q6Fragment : Fragment() {
    lateinit var binding: FragmentQ6Binding
    lateinit var preferences: MyPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQ6Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preferences = MyPreferences(requireActivity())
        binding.answer1Button.setOnClickListener { yes() }
        binding.answer2Button.setOnClickListener { yes() }
        binding.answer3Button.setOnClickListener { no() }
        binding.answer4Button.setOnClickListener { no() }
    }

    fun yes() {
        if (preferences.doUPlayWithPoints()) {
            preferences.plusOne()
            findNavController().navigate(R.id.q7Fragment)
        } else {
            findNavController().navigate(R.id.q7Fragment)
        }
    }

    fun no() {
        if (preferences.doUPlayWithPoints()) {
            findNavController().navigate(R.id.q7Fragment)
        } else {
            findNavController().navigate(R.id.menuFragment)
        }
    }
}