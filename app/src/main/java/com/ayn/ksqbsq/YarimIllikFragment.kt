package com.ayn.ksqbsq

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.ayn.ksqbsq.databinding.FragmentYarimIllikBinding

class YarimIllikFragment : Fragment() {
    private lateinit var binding: FragmentYarimIllikBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentYarimIllikBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            ireli.setOnClickListener {
                val ksqSay = ksqSay.text.toString().toInt()
                val bsq = bsqVar.isChecked
                val ksqBsqModel = IntentModel(ksqSay, bsq)
                val action =
                    YarimIllikFragmentDirections.actionYarimIllikFragmentToHesabYarimIllikFragment(
                        ksqBsqModel
                    )
                findNavController().navigate(action)

                if (ksqSay == 0) {
                    Toast.makeText(
                        requireActivity(),
                        "KSQ sayını və BSQ -nin olub olmadığını qeyd edin", Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
}