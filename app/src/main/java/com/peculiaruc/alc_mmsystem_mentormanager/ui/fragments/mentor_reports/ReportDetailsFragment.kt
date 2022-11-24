package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.mentor_reports

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentReportDetailsBinding

class ReportDetailsFragment : Fragment() {
    private var _binding: FragmentReportDetailsBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReportDetailsBinding.inflate(inflater, container, false)

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