package com.geektech.dadsquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.geektech.dadsquiz.databinding.FragmentQ4Binding
import com.geektech.dadsquiz.databinding.FragmentQ5Binding

class Q5Fragment : Fragment() {
    lateinit var binding: FragmentQ5Binding
    lateinit var preferences: MyPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQ5Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preferences = MyPreferences(requireActivity())
        binding.answer1Button.setOnClickListener { yes() }
        binding.answer2Button.setOnClickListener { no() }
        binding.answer3Button.setOnClickListener { no() }
        binding.answer4Button.setOnClickListener { yes() }
    }

    fun yes() {
        if (preferences.doUPlayWithPoints()) {
            preferences.plusOne()
            findNavController().navigate(R.id.q6Fragment)
        } else {
            findNavController().navigate(R.id.q6Fragment)
        }
    }

    fun no() {
        if (preferences.doUPlayWithPoints()) {
            findNavController().navigate(R.id.q6Fragment)
        } else {
            findNavController().navigate(R.id.menuFragment)
        }
    }
}