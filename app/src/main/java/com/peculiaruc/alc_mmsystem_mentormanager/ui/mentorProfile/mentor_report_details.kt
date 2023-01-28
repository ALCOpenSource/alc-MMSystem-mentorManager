package com.peculiaruc.alc_mmsystem_mentormanager.ui.mentorProfile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentMentorReportDetailsBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.mentor_reports.DownloadDialogueFragment
import com.peculiaruc.alc_mmsystem_mentormanager.ui.mentor_reports.ShareDialogueFragment

/**
 * This handles the details of the report
 * current no functionality is implemented,
 *  only ui and some navigation
 */

class mentor_report_details : Fragment() {
    private var _binding: FragmentMentorReportDetailsBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMentorReportDetailsBinding.inflate(inflater, container, false)

        binding.close.setOnClickListener {
            activity?.onBackPressed();
        }

        binding.frame375.setOnClickListener {
            val fragment = ShareDialogueFragment()
            fragment.show(requireActivity().supportFragmentManager, "show share dialogue")
        }
        binding.frame376.setOnClickListener {
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