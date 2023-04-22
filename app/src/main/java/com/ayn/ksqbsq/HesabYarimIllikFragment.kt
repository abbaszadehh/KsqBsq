package com.ayn.ksqbsq

import android.os.Bundle
import android.text.TextUtils.StringSplitter
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ayn.ksqbsq.databinding.FragmentHesabYarimIllikBinding
import com.ayn.ksqbsq.databinding.FragmentYarimIllikBinding

class HesabYarimIllikFragment : Fragment() {

    private lateinit var binding: FragmentHesabYarimIllikBinding
    private val args: HesabYarimIllikFragmentArgs by navArgs()
    var resultBal: Double? = null
    var resultQiymet: Double? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHesabYarimIllikBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            hesabla.setOnClickListener {

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
        val shart = args.ksqbsq
        if (shart.isBsq) {
            binding.bsq.visibility = View.VISIBLE
        }

        when (shart.ksq) {
            3 -> {
                with(binding) {
                    ksq1.visibility = View.VISIBLE
                    ksq2.visibility = View.VISIBLE
                    ksq3.visibility = View.VISIBLE

                    with(binding) {
                        hesabla.setOnClickListener {
                            ksq1.text.toString().toInt()
                            ksq2.text.toString().toInt()
                            ksq3.text.toString().toInt()
                            balHesabla3()
                        }
                    }

                }
            }
            4 -> {
                with(binding) {
                    ksq1.visibility = View.VISIBLE
                    ksq2.visibility = View.VISIBLE
                    ksq3.visibility = View.VISIBLE
                    ksq4.visibility = View.VISIBLE

                    with(binding) {
                        hesabla.setOnClickListener {
                            ksq1.text.toString().toInt()
                            ksq2.text.toString().toInt()
                            ksq3.text.toString().toInt()
                            ksq4.text.toString().toInt()
                            balHesabla4()
                        }
                    }
                }
            }
            5 -> {
                with(binding) {
                    ksq1.visibility = View.VISIBLE
                    ksq2.visibility = View.VISIBLE
                    ksq3.visibility = View.VISIBLE
                    ksq4.visibility = View.VISIBLE
                    ksq5.visibility = View.VISIBLE

                    with(binding) {
                        hesabla.setOnClickListener {
                            ksq1.text.toString().toInt()
                            ksq2.text.toString().toInt()
                            ksq3.text.toString().toInt()
                            ksq4.text.toString().toInt()
                            ksq5.text.toString().toInt()
                            balHesabla5()
                        }
                    }
                }
            }
            6 -> {
                with(binding) {
                    ksq1.visibility = View.VISIBLE
                    ksq2.visibility = View.VISIBLE
                    ksq3.visibility = View.VISIBLE
                    ksq4.visibility = View.VISIBLE
                    ksq5.visibility = View.VISIBLE
                    ksq6.visibility = View.VISIBLE

                    with(binding) {
                        hesabla.setOnClickListener {
                            ksq1.text.toString().toInt()
                            ksq2.text.toString().toInt()
                            ksq3.text.toString().toInt()
                            ksq4.text.toString().toInt()
                            ksq5.text.toString().toInt()
                            ksq6.text.toString().toInt()
                            balHesabla6()
                        }
                    }
                }
            }

            else -> {
                Toast.makeText(context, "Daxiletməni qaydalara uyğun edin!", Toast.LENGTH_LONG)
                    .show()
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

    fun ksqBaliHesabla(say: Int, cem: Int, bsq: Boolean) {
        if (bsq) {

            val bsqDeyer = binding.bsq.text.toString().trim().toInt()
            resultBal = (bsqDeyer * 0.6) + ((cem / say) * 0.4)
          //  binding.illikBal.text = "bal: ${resultBal.toString().toDouble()}"
            binding.illikBal.text = String.format("bal: %.2f",resultBal.toString().toDouble())
        } else {
           // binding.illikBal.text = "bal: ${(cem / say).toString().toDouble()}"
            binding.illikBal.text = String.format("bal: %.2f",(cem / say).toString().toDouble())
        }
    }

    private fun balHesabla3() {
        with(binding) {
            val ksq1Edit = ksq1.text.toString().toInt()
            val ksq2Edit = ksq2.text.toString().toInt()
            val ksq3Edit = ksq3.text.toString().toInt()

            val cemi = ksq1Edit + ksq2Edit + ksq3Edit
            ksqBaliHesabla(3, cemi, args.ksqbsq.isBsq)

        }
    }

    private fun balHesabla4() {
        with(binding) {
            with(binding) {
                val ksq1Edit = ksq1.text.toString().toInt()
                val ksq2Edit = ksq2.text.toString().toInt()
                val ksq3Edit = ksq3.text.toString().toInt()
                val ksq4Edit = ksq4.text.toString().toInt()

                val cemi = ksq1Edit + ksq2Edit + ksq3Edit + ksq4Edit
                ksqBaliHesabla(4, cemi, args.ksqbsq.isBsq)

            }
        }
    }

    private fun balHesabla5() {
        with(binding) {
            val ksq1Edit = ksq1.text.toString().toInt()
            val ksq2Edit = ksq2.text.toString().toInt()
            val ksq3Edit = ksq3.text.toString().toInt()
            val ksq4Edit = ksq4.text.toString().toInt()
            val ksq5Edit = ksq5.text.toString().toInt()

            val cemi = ksq1Edit + ksq2Edit + ksq3Edit + ksq4Edit + ksq5Edit
            ksqBaliHesabla(5, cemi, args.ksqbsq.isBsq)

        }
    }

    private fun balHesabla6() {
        with(binding) {
            val ksq1Edit = ksq1.text.toString().toInt()
            val ksq2Edit = ksq2.text.toString().toInt()
            val ksq3Edit = ksq3.text.toString().toInt()
            val ksq4Edit = ksq4.text.toString().toInt()
            val ksq5Edit = ksq5.text.toString().toInt()
            val ksq6Edit = ksq6.text.toString().toInt()

            val cemi = ksq1Edit + ksq2Edit + ksq3Edit + ksq4Edit + ksq5Edit + ksq6Edit
            ksqBaliHesabla(6, cemi, args.ksqbsq.isBsq)

        }
    }
}
