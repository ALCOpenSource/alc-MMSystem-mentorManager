package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.uiDummy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentProgramDummyBinding
/**
 * Fragment to display dummy view data for the profile section
 * to be deleted on implementation of the backend and a recyclerview set in place in the profile
 * fragment.The view items are already created
 */

class ProgramDummy : Fragment() {

    private lateinit var binding: FragmentProgramDummyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentProgramDummyBinding.inflate(inflater)

        binding.chipAbout.setOnClickListener{
            val action =ProgramDummyDirections.actionProgramDummyToProfileFragment()
            it.findNavController().navigate(action)
        }
        binding.chipMentors.setOnClickListener{
            val action = ProgramDummyDirections.actionProgramDummyToMentorsDummy()
            it.findNavController().navigate(action)
        }
        // Inflate the layout for this fragment
        return binding.root
    }


}