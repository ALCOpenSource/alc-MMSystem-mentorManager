package com.peculiaruc.alc_mmsystem_mentormanager.ui.report

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.Report
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentReportBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseFragment
import com.peculiaruc.alc_mmsystem_mentormanager.ui.mentorManagerProfile.adapters.ReportAdapter
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.EventObserve


class ReportFragment : BaseFragment<FragmentReportBinding>() {

    override val layoutIdFragment: Int = R.layout.fragment_report
    override val viewModel: ReportViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(true, getString(R.string.reports))
        setBottomNavigationVisibility(false)
        setHasOptionsMenu(true)
        binding.recyclerReport.adapter = ReportAdapter(listReport, viewModel)
        observeEvents()
    }

    private fun observeEvents() {
        viewModel.addReportEvent.observe(viewLifecycleOwner, EventObserve {
            findNavController().navigate(ReportFragmentDirections.actionReportFragmentToReportCreationFragment())
        })

        viewModel.openReportDetailsEvent.observe(viewLifecycleOwner, EventObserve {
            findNavController().navigate(ReportFragmentDirections.actionReportFragmentToReportDetailsFragment())
        })

    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.program, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.search -> {

            }
        }
        return super.onOptionsItemSelected(item)
    }


    private val listReport = listOf(
        Report(
            "Google Scholarship Africa Report", "By Ibrahem Kabir ",
            "18th - 25th Oct 22"
        ),
        Report(
            "Google Scholarship Asia Report", "By Marawan Mamdouh ",
            "13th - 25th Oct 22"
        ),
        Report(
            "Google Scholarship Report", "By Nada ",
            "17th - 25th Oct 22"
        ),
        Report(
            "Google Asia Scholarship Report", "By Ibrahim Kabir ",
            "20th - 25th Oct 22"
        ),
        Report(
            "Google America Scholarship Report", "By Ibrahim Marawan ",
            "16th - 25th Oct 22"
        ),
        Report(
            "Google Scholarship Asia Report", "By Nada Kabir ",
            "21th - 25th Oct 22"
        ),
        Report(
            "Google Africa Scholarship Report", "By Nada Ibrahim ",
            "01th - 25th Oct 22"
        ),
        Report(
            "Google Asia Scholarship Report", "By Nada Ibrahim ",
            "03th - 25th Oct 22"
        ),
        Report(
            "Google America Scholarship Report", "By Ibrahim ",
            "06th - 25th Oct 22"
        ),
        Report(
            "Google Africa Scholarship Report", "By Kabir ",
            "08th - 25th Oct 22"
        ),
    )

}