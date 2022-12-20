package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentApprovedCertificatesBinding

/**
 * fragment for approved certificates
 */

class ApprovedCertificateFragment : Fragment() {

 private  lateinit var binding:FragmentApprovedCertificatesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentApprovedCertificatesBinding.inflate(inflater)

        binding.approvBack.setOnClickListener {
            val action = ApprovedCertificateFragmentDirections.actionApprovedCertificateFragmentToCertificatesFragment()
            it.findNavController().navigate(action)
        }
        binding.approvedCerts.setOnClickListener{
            val action = ApprovedCertificateFragmentDirections.actionApprovedCertificateFragmentToMentorCertficateFragment()
            it.findNavController().navigate(action)
        }
        // Inflate the layout for this fragment
        return binding.root
    }


}