package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentCertBeneficiaryBinding
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentCertificatesBinding

/**
 * fragment for certificate beneficiaries
 */

class CertBeneficiaryFragment : Fragment() {
lateinit var binding: FragmentCertBeneficiaryBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentCertBeneficiaryBinding.inflate(inflater)

        binding.btnCertBeneficiary.setOnClickListener{
            val action = CertBeneficiaryFragmentDirections.actionCertBeneficiaryFragmentToGenerateCertFragment()
            it.findNavController().navigate(action)
        }
        binding.btnBackHome.setOnClickListener {
            val action  = CertBeneficiaryFragmentDirections.actionCertBeneficiaryFragmentToCertificatesFragment()
            it.findNavController().navigate(action)
        }

        // Inflate the layout for this fragment
        return binding.root
    }

}