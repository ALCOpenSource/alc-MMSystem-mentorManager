package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentGeneratedCertsBinding

/**
 * fragment to display generated certificates
 */
class GeneratedCertsFragment : Fragment() {

    private lateinit var binding:FragmentGeneratedCertsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentGeneratedCertsBinding.inflate(inflater)
        binding.btnBackProfile.setOnClickListener {
            val action = GeneratedCertsFragmentDirections.actionGeneratedCertsFragmentToCertificatesFragment()
            it.findNavController().navigate(action)
        }

        // Inflate the layout for this fragment
        return binding.root
    }

}