package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.mentor_profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.alc_mmsystem_mentormanager.MentorManagerApplication
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.local.mentor_profile.mentors_programs
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentMentorsProgramsFragmentBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.mentor_profile.mentor_program_adapter

class mentors_programs_fragment : Fragment() {


    private var _binding: FragmentMentorsProgramsFragmentBinding? = null
    private lateinit var rvAdapter: mentor_program_adapter
    private lateinit var mentors_program_list : List<mentors_programs>
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        load_dummy_programms()
        _binding = FragmentMentorsProgramsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun load_dummy_programms() {
        mentors_program_list = listOf(
            mentors_programs("GADS Program 2022 1","Dec 12, 2022",R.id.mentor_program_pic),
            mentors_programs("GADS Program 2022 2","Dec 12, 2022",R.id.mentor_program_pic),
            mentors_programs("GADS Program 2022 3","Dec 12, 2022",R.id.mentor_program_pic),
            mentors_programs("GADS Program 2022 4","Dec 12, 2022",R.id.mentor_program_pic),
            mentors_programs("GADS Program 2022 5","Dec 12, 2022",R.id.mentor_program_pic),
            mentors_programs("GADS Program 2022 6 ","Dec 12, 2022",R.id.mentor_program_pic),
            mentors_programs("GADS Program 2022 7 ","Dec 12, 2022",R.id.mentor_program_pic),
            mentors_programs("GADS Program 2022 8","Dec 12, 2022",R.id.mentor_program_pic),
            mentors_programs("GADS Program 2022 9","Dec 12, 2022",R.id.mentor_program_pic),
            mentors_programs("GADS Program 2022 10","Dec 12, 2022",R.id.mentor_program_pic),
            mentors_programs("GADS Program 2022 11","Dec 12, 2022",R.id.mentor_program_pic),
            )
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        // pass it to rvLists layoutManager
        binding.mentorProgramsRecycleview.setLayoutManager(layoutManager)
        // initialize the adapter,
        // and pass the required argument
        rvAdapter = mentor_program_adapter(mentors_program_list)
        // attach adapter to the recycler view
        binding.mentorProgramsRecycleview.adapter = rvAdapter
        binding.mentors.text= MentorManagerApplication.global_Var_MENTOR_NAME
        binding.body2.text= MentorManagerApplication.global_Var_MENTOR_NAME
        binding.mentorProgramPic.setImageResource(MentorManagerApplication.global_Var_MENTOR_NAME_pic)

        binding.arrowLeft.setOnClickListener {
            activity?.onBackPressed();
        }
        binding.about.setOnClickListener {
            activity?.onBackPressed();
        }
        binding.tasks.setOnClickListener {

            Navigation.findNavController(it).navigate(R.id.action_mentors_programs_fragment_to_mentro_tasks_fragment)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding =null
    }
}