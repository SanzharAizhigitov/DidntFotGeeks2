package com.geektech.dadsquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.geektech.dadsquiz.databinding.FragmentQ3Binding
import com.geektech.dadsquiz.databinding.FragmentQ4Binding

class Q4Fragment : Fragment() {
    lateinit var binding: FragmentQ4Binding
    lateinit var preferences: MyPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQ4Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preferences = MyPreferences(requireActivity())
        binding.answer1Button.setOnClickListener { no() }
        binding.answer2Button.setOnClickListener { no() }
        binding.answer3Button.setOnClickListener { yes() }
        binding.answer4Button.setOnClickListener { no() }
    }

    fun yes() {
        if (preferences.doUPlayWithPoints()) {
            preferences.plusOne()
            findNavController().navigate(R.id.q5Fragment)
        } else {
            findNavController().navigate(R.id.q5Fragment)
        }
    }

    fun no() {
        if (preferences.doUPlayWithPoints()) {
            findNavController().navigate(R.id.q5Fragment)
        } else {
            findNavController().navigate(R.id.menuFragment)
        }
    }
}