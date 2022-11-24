package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.mentor_profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentMentorProfileBinding


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class Mentor_profile_Fragment : Fragment() {
    private var _binding: FragmentMentorProfileBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMentorProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.Programs.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_SecondFragment_to_mentors_programs_fragment2)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding =null
    }
}