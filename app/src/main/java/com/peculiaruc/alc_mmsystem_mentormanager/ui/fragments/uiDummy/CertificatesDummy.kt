package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.uiDummy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentCertificatesDummyBinding
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentReportsDummyBinding

class CertificatesDummy : Fragment() {
 private  lateinit var binding: FragmentCertificatesDummyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCertificatesDummyBinding.inflate(inflater)

        binding.chipReports.setOnClickListener {
            val action = CertificatesDummyDirections.actionCertificatesDummyToReportsDummy()
            it.findNavController().navigate(action)
        }
        binding.cCard.setOnClickListener {
            val action = CertificatesDummyDirections.actionCertificatesDummyToMyCertDownloadFragment()
            it.findNavController().navigate(action)
        }
        // Inflate the layout for this fragment
        return binding.root
    }


}