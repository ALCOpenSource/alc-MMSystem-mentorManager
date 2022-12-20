package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentEarnedCertBinding

/**
 * fragment shows a list of certificates earned
 */
class EarnedCertFragment : Fragment() {
 private lateinit var binding:FragmentEarnedCertBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEarnedCertBinding.inflate(inflater)

        binding.earnedCerts.setOnClickListener {
            val action = EarnedCertFragmentDirections.actionEarnedCertFragmentToMentorCertficateFragment()
            it.findNavController().navigate(action)
        }
        // Inflate the layout for this fragment
        return binding.root
    }


}