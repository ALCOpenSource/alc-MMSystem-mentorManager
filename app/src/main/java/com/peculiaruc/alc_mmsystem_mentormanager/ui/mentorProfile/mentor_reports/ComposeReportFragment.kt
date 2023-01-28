package com.peculiaruc.alc_mmsystem_mentormanager.ui.mentorProfile.mentor_reports

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentComposeReportBinding
/**
 * to implement th compose report functionality
 * no functionality yet
 */
class ComposeReportFragment : Fragment() {

    private var _binding: FragmentComposeReportBinding? = null
    private val binding
        get() = _binding!!

    private var isProgramSelected = true
    private var isTaskSelected = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentComposeReportBinding.inflate(inflater, container, false)

        binding.composeReportBack.setOnClickListener {
            Navigation.findNavController(requireView()).popBackStack(R.id.reportFragment, false)
        }

        handleRadioButtonClick()

        handleTypeClick()

        binding.reportSubmitButton.setOnClickListener {
            val fragment = SubmitSuccessDialogueFragment()
            fragment.show(requireActivity().supportFragmentManager, "show submit dialogue")
        }

        return binding.root
    }

    private fun handleTypeClick() {
        binding.reportTypeButton.setOnClickListener {
            if (binding.reportTypeButton.text == activity?.getString(R.string.text_select_task)) {
                findNavController().navigate(R.id.action_composeReportFragment_to_taskListFragment)

            } else {
                findNavController().navigate(R.id.action_composeReportFragment_to_programListFragment)
            }
        }
    }

    private fun handleRadioButtonClick() {
        binding.radioProgram.setOnClickListener {
            isProgramSelected = true
            isTaskSelected = false

            binding.radioProgram.setImageResource(R.drawable.ic_radio_check)
            binding.radioTask.setImageResource(R.drawable.ic_radio_uncheck)
            binding.reportTypeButton.text = getString(R.string.text_select_program)
            binding.deleteButton.setImageResource(R.drawable.ic_cancel2)
        }

        binding.radioTask.setOnClickListener {
            isProgramSelected = false
            isTaskSelected = true

            binding.radioProgram.setImageResource(R.drawable.ic_radio_uncheck)
            binding.radioTask.setImageResource(R.drawable.ic_radio_check)
            binding.reportTypeButton.text = getString(R.string.text_select_task)
            binding.deleteButton.setImageResource(R.drawable.ic_cancel)
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}