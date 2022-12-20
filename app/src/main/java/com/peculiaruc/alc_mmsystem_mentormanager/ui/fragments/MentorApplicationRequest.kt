package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentMentorApplicationRequestBinding

/**
 * Fragment displaying a mentor applicants request
 */
class MentorApplicationRequest : Fragment() {
  private  lateinit var binding:FragmentMentorApplicationRequestBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMentorApplicationRequestBinding.inflate(inflater)

        binding.btnBackProfile.setOnClickListener {
            val action = MentorApplicationRequestDirections.actionMentorApplicationRequestToMentorApplicants()
            it.findNavController().navigate(action)
        }
        // Inflate the layout for this fragment
        return binding.root
    }


}