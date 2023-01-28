package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.mentor_profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.alc_mmsystem_mentormanager.MentorManagerApplication
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.mentorProfile.MentorsPrograms
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentMentorsProgramsFragmentBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.mentor_profile.mentor_program_adapter

/**
 * This handles the  display of mentors certificate
 * current no functionality is implemented,
 *  only ui and some navigation
 */


class mentors_programs_fragment : Fragment() {


    private var _binding: FragmentMentorsProgramsFragmentBinding? = null
    private lateinit var rvAdapter: mentor_program_adapter
    private lateinit var mentors_program_list : List<MentorsPrograms>
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
    // this loads the dummy data on the list of programs for the mentor
    private fun load_dummy_programms() {
        mentors_program_list = listOf(
            MentorsPrograms("GADS Program 20221","Dec 11, 2022",R.id.mentor_program_pic),
            MentorsPrograms("GADS Program 20222","Dec 12, 2022",R.drawable.profile_img),
            MentorsPrograms("GADS Program 20223","Dec 13, 2022",R.drawable.ann_2),
            MentorsPrograms("GADS Program 20224","Dec 14, 2022",R.drawable.ann),
            MentorsPrograms("GADS Program 20225","Dec 15, 2022",R.drawable.grace),
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