package com.peculiaruc.alc_mmsystem_mentormanager.ui.mentorProfile

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.peculiaruc.alc_mmsystem_mentormanager.MentorManagerApplication.Companion.global_Var_MENTOR_NAME
import com.peculiaruc.alc_mmsystem_mentormanager.MentorManagerApplication.Companion.global_Var_MENTOR_NAME_pic
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentMentorProfileBinding


/**
 * This handles the mento about  screen
 * current no functionality is implemented,
 *  only ui and some navigation
 */
class MentorProfileFragment : Fragment() {
    private var _binding: FragmentMentorProfileBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMentorProfileBinding.inflate(inflater, container, false)

        binding.mentors.text = global_Var_MENTOR_NAME
        binding.body2.text = global_Var_MENTOR_NAME
        binding.mentorProgramPic.setImageResource(global_Var_MENTOR_NAME_pic)
        binding.arrowLeft.setOnClickListener {
            activity?.onBackPressed();
        }

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.Programs.setOnClickListener {

            Navigation.findNavController(it)
                .navigate(R.id.action_SecondFragment_to_mentors_programs_fragment2)
        }
        binding.frame354.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_SecondFragment_to_mentors_programs_fragment2)
        }
        binding.Programs.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_SecondFragment_to_mentors_programs_fragment2)
        }
        binding.Programs.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_SecondFragment_to_mentors_programs_fragment2)
        }
        binding.Programs.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_SecondFragment_to_mentors_programs_fragment2)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}