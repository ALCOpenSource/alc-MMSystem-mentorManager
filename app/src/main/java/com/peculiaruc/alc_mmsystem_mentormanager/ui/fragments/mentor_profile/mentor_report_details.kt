package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.mentor_profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.appcompat.app.AlertDialog
import androidx.navigation.Navigation
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentMentorReportDetailsBinding
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentReportBinding
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentReportDetailsBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.mentor_reports.DownloadDialogueFragment
import com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.mentor_reports.ShareDialogueFragment

class mentor_report_details : Fragment() {
    private var _binding: FragmentReportDetailsBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReportDetailsBinding.inflate(inflater, container, false)

        binding.detailsCancel.setOnClickListener {
            Navigation.findNavController(requireView()).popBackStack(R.id.reportFragment, false)
        }

        binding.detailsShare.setOnClickListener {
            val fragment = ShareDialogueFragment()
            fragment.show(requireActivity().supportFragmentManager, "show share dialogue")
        }

        binding.detailsDownload.setOnClickListener {
            val fragment = DownloadDialogueFragment()
            fragment.show(requireActivity().supportFragmentManager, "show download dialogue")
        }

        return binding.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}