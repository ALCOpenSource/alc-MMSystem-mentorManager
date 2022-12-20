package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentSearchBinding

/**
 * Fragment to search within the application
 */

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var buttonPosition = 0

        binding = FragmentSearchBinding.inflate(inflater)


        binding.btnSort.setOnClickListener {

            if (buttonPosition == 0) {
                binding.relativeLayout.visibility = View.VISIBLE
                buttonPosition = 1;
            } else if (buttonPosition == 1) {
                binding.relativeLayout.visibility = View.GONE
                buttonPosition = 0;
            }

        }

        binding.btnBackDashboard.setOnClickListener {
            val action = SearchFragmentDirections.actionSearchFragmentToHomeFragment()
            it.findNavController().navigate(action)
        }
        // Inflate the layout for this fragment
        return binding.root

    }
}