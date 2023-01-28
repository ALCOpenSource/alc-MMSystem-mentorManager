package com.peculiaruc.alc_mmsystem_mentormanager.ui.authentication.register

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentRegisterFormTwoBinding

/**
 * this fragment is used to fill form two when registering
 * for the first time to be a Mentor Manager
 */
class RegisterFormTwoFragment : Fragment() {

    private lateinit var viewModel: RegisterFormTwoViewModel
    var binding: FragmentRegisterFormTwoBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterFormTwoBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(requireActivity())[RegisterFormTwoViewModel::class.java]

        binding?.buttonPrevious?.setOnClickListener {
//            findNavController().navigateUp()
            findNavController().navigate(RegisterFormTwoFragmentDirections.actionRegisterFormTwoFragmentToRegisterFormOneFragment())
        }

        binding?.buttonNext?.setOnClickListener {
            findNavController().navigate(RegisterFormTwoFragmentDirections.actionRegisterFormTwoFragmentToRegisterFormThreeFragment())
        }

        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}