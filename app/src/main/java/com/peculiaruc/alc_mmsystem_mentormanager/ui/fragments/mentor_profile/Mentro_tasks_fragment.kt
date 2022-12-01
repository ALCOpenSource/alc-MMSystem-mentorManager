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
import com.peculiaruc.alc_mmsystem_mentormanager.data.local.mentor_profile.mentors_tasks
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentMentroTasksFragmentBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.mentor_profile.mentor_tasks_adapter

/**
 * This handles the display of mentors tasks
 * current no functionality is implemented,
 *  only ui and some navigation
 */

class Mentro_tasks_fragment : Fragment() {


    private var _binding: FragmentMentroTasksFragmentBinding? = null
    private lateinit var rvAdapter: mentor_tasks_adapter
    private lateinit var mentors_task_list : List<mentors_tasks>
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        load_dummy_programms()
        _binding = FragmentMentroTasksFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }
   // loads dummy data in the list of tasks
    private fun load_dummy_programms() {
        mentors_task_list = listOf(

            mentors_tasks("Room library article writ...1 ","3 days from now",R.id.mentor_program_pic),
            mentors_tasks("Debugging in VSCode2","3 days from now",R.id.mentor_program_pic),


            )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        // pass it to rvLists layoutManager
        binding.mentorTasksRecycleview.setLayoutManager(layoutManager)
        // initialize the adapter,
        // and pass the required argument
        rvAdapter = mentor_tasks_adapter(mentors_task_list)
        // attach adapter to the recycler view
        binding.mentorTasksRecycleview.adapter = rvAdapter

        binding.mentors.text= MentorManagerApplication.global_Var_MENTOR_NAME
        binding.body2.text= MentorManagerApplication.global_Var_MENTOR_NAME
        binding.mentorProgramPic.setImageResource(MentorManagerApplication.global_Var_MENTOR_NAME_pic)

        binding.arrowLeft.setOnClickListener {
            activity?.onBackPressed();
        }
        binding.Programs.setOnClickListener {
            activity?.onBackPressed();
        }
        binding.reports.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_mentro_tasks_fragment_to_mentors_Reports_fragments)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding =null
    }

}