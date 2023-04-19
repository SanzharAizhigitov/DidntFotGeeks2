package com.geektech.dadsquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.geektech.dadsquiz.databinding.FragmentSwitchBinding

class SwitchFragment : Fragment() {
    lateinit var binding: FragmentSwitchBinding
    lateinit var preferences: MyPreferences
   override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSwitchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preferences = MyPreferences(requireActivity())
binding.pointsBtn.setOnClickListener {
    preferences.iWillPlayWithPoints()
    findNavController().navigate(R.id.menuFragment)
}
        binding.hitlessBtn.setOnClickListener {
            preferences.iWillPlayWithRestart()
            findNavController().navigate(R.id.menuFragment)
        }
    }

}