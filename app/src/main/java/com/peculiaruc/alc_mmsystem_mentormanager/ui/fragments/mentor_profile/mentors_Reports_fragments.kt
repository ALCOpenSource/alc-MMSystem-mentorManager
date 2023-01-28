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
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.mentorProfile.MentorsReport
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentMentorsReportsBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.mentor_profile.mentor_report_adapter
/**
 * This handles the  display of mentors Reports
 * current no functionality is implemented,
 *  only ui and some navigation
 */

class mentors_Reports_fragments : Fragment() {
    private var _binding: FragmentMentorsReportsBinding? = null
    private lateinit var rvAdapter: mentor_report_adapter
    private lateinit var mentors_reports : List<MentorsReport>
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        load_dummy_programms()
        _binding = FragmentMentorsReportsBinding.inflate(inflater, container, false)
        return binding.root
    }
// loads  dummy data in the list of reports from the mentors
    private fun load_dummy_programms() {
        mentors_reports = listOf(

            MentorsReport("Google Africa Scholarship Report2","By Ibrahim Kabir  -  19th - 25th Oct 22"),
            MentorsReport("Google Africa Scholarship Report3","By Ibrahim Kabir  -  19th - 25th Oct 22"),
     )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        // pass it to rvLists layoutManager
        binding.mentorTasksRecycleview.setLayoutManager(layoutManager)
        // initialize the adapter,
        // and pass the required argument
        rvAdapter = mentor_report_adapter(mentors_reports)
        // attach adapter to the recycler view
        binding.mentorTasksRecycleview.adapter = rvAdapter
            // intialization for mentor name in the tool bar and the mentor pic
        binding.mentors.text= MentorManagerApplication.global_Var_MENTOR_NAME
        binding.body2.text= MentorManagerApplication.global_Var_MENTOR_NAME
        binding.mentorProgramPic.setImageResource(MentorManagerApplication.global_Var_MENTOR_NAME_pic)
// handles back navigation to the previous page
        binding.arrowLeft.setOnClickListener {
            activity?.onBackPressed();
        }
// handles  the navigation to the previous task screen
        binding.tasks.setOnClickListener {
            activity?.onBackPressed();
        }
        // handles  the navigation to the cetificate task screen

        binding.certificate.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_mentors_Reports_fragments_to_mentor_certificates_fragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding =null
    }



}