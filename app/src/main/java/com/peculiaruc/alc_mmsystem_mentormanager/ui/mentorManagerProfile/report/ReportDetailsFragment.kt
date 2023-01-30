package com.peculiaruc.alc_mmsystem_mentormanager.ui.mentorManagerProfile.report

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentReportDetailsBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseFragment
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.EventObserve

/**
 * represent Report Details screen.
 * */
class ReportDetailsFragment : BaseFragment<FragmentReportDetailsBinding>() {

    override val layoutIdFragment: Int = R.layout.fragment_report_details
    override val viewModel: ReportDetailsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(false)
        setBottomNavigationVisibility(false)
        observeEvent()
    }

    private fun observeEvent() {
        viewModel.closeReportEvent.observe(viewLifecycleOwner, EventObserve {
            findNavController().navigateUp()
        })

        viewModel.shareReportEvent.observe(viewLifecycleOwner, EventObserve {
//            findNavController().navigate(
//                ReportDetailsFragmentDirections.actionReportDetailsFragmentToTwoActionDialogFragment(
//                    DialogTypes.SHARE_REPORT
//                )
//            )
        })

        viewModel.downloadReportEvent.observe(viewLifecycleOwner, EventObserve {
//            findNavController().navigate(
//                ReportDetailsFragmentDirections.actionReportDetailsFragmentToBasicDialog(DialogTypes.REPORT_DOWNLOAD)
//            )
        })
    }

}