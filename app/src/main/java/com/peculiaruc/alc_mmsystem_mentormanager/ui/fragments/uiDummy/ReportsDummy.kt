package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.uiDummy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentReportsDummyBinding
/**
 * Fragment to display dummy view data for the profile section
 * to be deleted on implementation of the backend and a recyclerview set in place in the profile
 * fragment.The view items are already created
 */
class ReportsDummy : Fragment() {
   private  lateinit var binding: FragmentReportsDummyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentReportsDummyBinding.inflate(inflater)

        binding.chipTasks.setOnClickListener {
            val action = ReportsDummyDirections.actionReportsDummyToTaskDummy()
            it.findNavController().navigate(action)
        }
        binding.chipCertificates.setOnClickListener {
            val action = ReportsDummyDirections.actionReportsDummyToCertificatesDummy()
            it.findNavController().navigate(action)
        }

        binding.rcard1.setOnClickListener{
            val action = ReportsDummyDirections.actionReportsDummyToMyReportDetails()
            it.findNavController().navigate(action)
        }

        // Inflate the layout for this fragment
        return binding.root
    }


}