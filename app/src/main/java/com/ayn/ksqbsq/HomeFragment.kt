package com.ayn.ksqbsq

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ayn.ksqbsq.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            yarimillik.setOnClickListener {
                val action = HomeFragmentDirections.actionHomeFragmentToYarimIllikFragment()
                findNavController().navigate(action)
            }
            illik.setOnClickListener {
                val action = HomeFragmentDirections.actionHomeFragmentToIllikFragment()
                findNavController().navigate(action)
            }
        }
    }

}