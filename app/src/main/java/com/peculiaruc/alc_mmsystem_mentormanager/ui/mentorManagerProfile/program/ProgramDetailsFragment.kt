package com.peculiaruc.alc_mmsystem_mentormanager.ui.mentorManagerProfile.program

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentProgramDetailsBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseFragment
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.EventObserve


/**
 * represent Program Details screen.
 * */
class ProgramDetailsFragment : BaseFragment<FragmentProgramDetailsBinding>() {
    override val layoutIdFragment: Int = R.layout.fragment_program_details
    override val viewModel: ProgramDetailsViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(true, "Google Africa Scholarship Program")
        setBottomNavigationVisibility(false)
        binding.programRecycler.adapter = ProgramDetailsAdapter(emptyList(), viewModel)
        onEvents()
    }

    private fun onEvents() {
        viewModel.assignedEvent.observe(viewLifecycleOwner, EventObserve {
//            val action = if (it) {
//                ProgramDetailsFragmentDirections.actionProgramDetailsFragmentToBasicDialog(
//                    DialogTypes.UNASSIGNED_TO_PROGRAM
//                )
//            } else {
//                ProgramDetailsFragmentDirections.actionProgramDetailsFragmentToBasicDialog(
//                    DialogTypes.ASSIGNED_TO_PROGRAM
//                )
//            }
//            findNavController().navigate(action)
//            viewModel.setAssigned(!it)
        })
    }

}