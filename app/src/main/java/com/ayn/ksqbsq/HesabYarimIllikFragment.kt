package com.ayn.ksqbsq

import android.os.Bundle
import android.text.TextUtils.StringSplitter
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ayn.ksqbsq.databinding.FragmentHesabYarimIllikBinding
import com.ayn.ksqbsq.databinding.FragmentYarimIllikBinding

class HesabYarimIllikFragment : Fragment() {

    private lateinit var binding: FragmentHesabYarimIllikBinding
    private val args: HesabYarimIllikFragmentArgs by navArgs()
    private var resultBal: Double? = null
    private var resultQiymet: Double? = null
    private val  editTextList = ArrayList<EditText>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHesabYarimIllikBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editTextList.add(binding.ksq1)
        editTextList.add(binding.ksq2)
        editTextList.add(binding.ksq3)
        editTextList.add(binding.ksq4)
        editTextList.add(binding.ksq5)
        editTextList.add(binding.ksq6)

        val shart = args.ksqbsq
        if (shart.isBsq) {
            binding.bsq.visibility = View.VISIBLE
        }

        editTextList.take(shart.ksq).map { it.isVisible= true }

        with(binding) {
            hesabla.setOnClickListener {
                when(shart.ksq){
                    3,4,5,6 ->{ balHesabla(shart.ksq) }
                    else->{
                        Toast.makeText(context, "Daxiletməni qaydalara uyğun edin!", Toast.LENGTH_LONG)
                            .show()
                    }
                }

                if (resultBal!! <= 30.09) {
                    resultQiymet = 2.0
                } else if (resultBal!! >= 30 && resultBal!! <= 60.09) {
                    resultQiymet = 3.0
                } else if (resultBal!! >= 60.1 && resultBal!! <= 80.09) {
                    resultQiymet = 4.0
                } else {
                    resultQiymet = 5.0
                }

                binding.illikQiymet.text = "Illik qiymət : $resultQiymet"
            }
        }

        binding.sifirla.setOnClickListener {
            with(binding) {
                ksq1.text = null
                ksq2.text = null
                ksq3.text = null
                ksq4.text = null
                ksq5.text = null
                ksq6.text = null
                bsq.text = null
                illikBal.text = "bal"
                illikQiymet.text = "qiymət"
            }
        }
    }

    private fun balHesabla(count : Int) {
        with(binding) {
            val average = editTextList.take(count).map { it.text.toString().toInt() }.average()
            if (args.ksqbsq.isBsq) {
                val bsqDeyer = binding.bsq.text.toString().trim().toInt()
                resultBal = (bsqDeyer * 0.6) + (average * 0.4)
                binding.illikBal.text = String.format("bal: %.2f",resultBal.toString().toDouble())
            } else {
                resultBal = average
                binding.illikBal.text = String.format("bal: %.2f",average)
            }
        }
    }
}
