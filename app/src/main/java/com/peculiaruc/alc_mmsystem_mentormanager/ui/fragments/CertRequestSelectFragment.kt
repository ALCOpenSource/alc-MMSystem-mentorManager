package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentCertRequestSelectBinding


/**
 * This is a fragment for selecting programs to generate certificates for
 */
class CertRequestSelectFragment : Fragment() {
   lateinit var binding: FragmentCertRequestSelectBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCertRequestSelectBinding.inflate(inflater)

        binding.cardView1.setOnClickListener {


            val action = CertRequestSelectFragmentDirections.actionCertRequestSelectFragmentToGenerateCertFragment()
            it.findNavController().navigate(action)
        }

        binding.selArrow.setOnClickListener {

            val action = CertRequestSelectFragmentDirections.actionCertRequestSelectFragmentToGenerateCertFragment()
            it.findNavController().navigate(action)

        }
        return binding.root

    }

}