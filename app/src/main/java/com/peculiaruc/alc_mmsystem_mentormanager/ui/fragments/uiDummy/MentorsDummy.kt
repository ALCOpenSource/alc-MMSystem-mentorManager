package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.uiDummy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentMentorsDummyBinding
/**
 * Fragment to display dummy view data for the profile section
 * to be deleted on implementation of the backend and a recyclerview set in place in the profile
 * fragment.The view items are already created
 */
class MentorsDummy : Fragment() {
private  lateinit var binding: FragmentMentorsDummyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMentorsDummyBinding.inflate(inflater)

        binding.chipPrograms.setOnClickListener {
            val action = MentorsDummyDirections.actionMentorsDummyToProgramDummy()
            it.findNavController().navigate(action)
        }

        binding.chipTasks.setOnClickListener {
            val action = MentorsDummyDirections.actionMentorsDummyToTaskDummy()
            it.findNavController().navigate(action)
        }

        // Inflate the layout for this fragment
        return binding.root
    }


}