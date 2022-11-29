package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.mentor_profile

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.widget.SearchView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.core.view.MenuProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.peculiaruc.alc_mmsystem_mentormanager.MentorManagerApplication.Companion.global_Var_MENTOR_NAME
import com.peculiaruc.alc_mmsystem_mentormanager.MentorManagerApplication.Companion.global_Var_MENTOR_NAME_pic
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentMentorProfileBinding

import kotlin.properties.Delegates


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class Mentor_profile_Fragment : Fragment() {
    private var _binding:FragmentMentorProfileBinding? = null
    lateinit var  mentor_name:String
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentMentorProfileBinding.inflate(inflater, container, false)
        mentor_name = requireArguments().getString("Mentor_name").toString()

        binding.mentors.text=global_Var_MENTOR_NAME
        binding.body2.text=global_Var_MENTOR_NAME
        binding.mentorProgramPic.setImageResource(global_Var_MENTOR_NAME_pic)
        binding.arrowLeft.setOnClickListener {
            activity?.onBackPressed();
        }

        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.Programs.setOnClickListener {

            Navigation.findNavController(it).navigate(R.id.action_SecondFragment_to_mentors_programs_fragment2)
        }
        binding.frame354.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_SecondFragment_to_mentors_programs_fragment2)
        }
        binding.Programs.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_SecondFragment_to_mentors_programs_fragment2)
        }
        binding.Programs.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_SecondFragment_to_mentors_programs_fragment2)
        }
        binding.Programs.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_SecondFragment_to_mentors_programs_fragment2)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding =null
    }
}