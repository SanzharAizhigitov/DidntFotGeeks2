package com.geektech.dadsquiz

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.geektech.dadsquiz.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {
    lateinit var binding: FragmentMenuBinding
    lateinit var preferences: MyPreferences
  @SuppressLint("SuspiciousIndentation")
  override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preferences = MyPreferences(requireActivity())
        Log.e("xvr", "f ${preferences.getPoints()}")
        preferences.cleanPoints()
        Log.e("xvr", "s ${preferences.getPoints()}")
        binding.startBtn.setOnClickListener{findNavController().navigate(R.id.q1Fragment)}
        binding.gameSwitchBtn.setOnClickListener{findNavController().navigate(R.id.switchFragment)}
    }

}