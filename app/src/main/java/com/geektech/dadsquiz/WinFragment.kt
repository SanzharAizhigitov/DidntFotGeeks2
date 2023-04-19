package com.geektech.dadsquiz

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.geektech.dadsquiz.databinding.FragmentQ10Binding
import com.geektech.dadsquiz.databinding.FragmentWinBinding

class WinFragment : Fragment() {
    lateinit var binding: FragmentWinBinding
    lateinit var preferences: MyPreferences

   override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWinBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preferences = MyPreferences(requireActivity())
        if (preferences.doUPlayWithPoints()){
            binding.resultTv.text = "Твой счет: ${preferences.getPoints().toString()}/10"
        }else{binding.resultTv.text = "Ура, ты выиграл"}
        binding.toHomeIv.setOnClickListener{findNavController().navigate(R.id.menuFragment)}
    }


}