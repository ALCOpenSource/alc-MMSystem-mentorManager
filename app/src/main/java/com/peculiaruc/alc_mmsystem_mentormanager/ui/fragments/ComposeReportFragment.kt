package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentComposeReportBinding

class ComposeReportFragment : Fragment() {

    private var _binding: FragmentComposeReportBinding? = null
    private val binding
        get() = _binding!!

    private var isProgramSelected = false
    private var isTaskSelected = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentComposeReportBinding.inflate(inflater, container, false)

        binding.composeReportToolbar.apply {
            setNavigationIcon(R.drawable.ic_back)
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
            val taskListFragment = TaskListFragment()
            val programFragment = ProgramListFragment()
            if (binding.reportTypeButton.text == activity?.getString(R.string.text_select_task)) {
                activity?.supportFragmentManager?.commit {
                    setCustomAnimations(
                        R.anim.slide_in,
                        R.anim.fade_out,
                        R.anim.fade_out,
                        R.anim.slide_in
                    )
                    replace(R.id.fragment_container_view, taskListFragment)
                    addToBackStack(null)
                }
            } else {
                activity?.supportFragmentManager?.commit {
                    setCustomAnimations(
                        R.anim.slide_in,
                        R.anim.fade_out,
                        R.anim.fade_out,
                        R.anim.slide_in
                    )
                    replace(R.id.fragment_container_view, programFragment)
                    addToBackStack(null)
                }
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