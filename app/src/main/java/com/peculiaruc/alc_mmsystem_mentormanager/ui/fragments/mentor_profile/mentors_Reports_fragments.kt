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
import com.peculiaruc.alc_mmsystem_mentormanager.data.local.mentor_profile.mentors_reports
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentMentorsReportsBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.mentor_profile.mentor_report_adapter

class mentors_Reports_fragments : Fragment() {
    private var _binding: FragmentMentorsReportsBinding? = null
    private lateinit var rvAdapter: mentor_report_adapter
    private lateinit var mentors_reports : List<mentors_reports>
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

    private fun load_dummy_programms() {
        mentors_reports = listOf(
            mentors_reports("Google Africa Scholarship Report 1","By Ibrahim Kabir  -  19th - 25th Oct 22"),
            mentors_reports("Google Africa Scholarship Report 2","By Ibrahim Kabir  -  19th - 25th Oct 22"),
            mentors_reports("Google Africa Scholarship Report 3","By Ibrahim Kabir  -  19th - 25th Oct 22"),
            mentors_reports("Google Africa Scholarship Report 4","By Ibrahim Kabir  -  19th - 25th Oct 22"),
            mentors_reports("Google Africa Scholarship Report 5","By Ibrahim Kabir  -  19th - 25th Oct 22"),
            mentors_reports("Google Africa Scholarship Report 6","By Ibrahim Kabir  -  19th - 25th Oct 22"),
            mentors_reports("Google Africa Scholarship Report 7","By Ibrahim Kabir  -  19th - 25th Oct 22"),
            mentors_reports("Google Africa Scholarship Report 8","By Ibrahim Kabir  -  19th - 25th Oct 22"),
            mentors_reports("Google Africa Scholarship Report 9","By Ibrahim Kabir  -  19th - 25th Oct 22"),
            mentors_reports("Google Africa Scholarship Report 10","By Ibrahim Kabir  -  19th - 25th Oct 22"),
            mentors_reports("Google Africa Scholarship Report 21","By Ibrahim Kabir  -  19th - 25th Oct 22"),
            mentors_reports("Google Africa Scholarship Report 12","By Ibrahim Kabir  -  19th - 25th Oct 22"),
            mentors_reports("Google Africa Scholarship Report 13","By Ibrahim Kabir  -  19th - 25th Oct 22"),
            mentors_reports("Google Africa Scholarship Report 14","By Ibrahim Kabir  -  19th - 25th Oct 22"),
            mentors_reports("Google Africa Scholarship Report 15","By Ibrahim Kabir  -  19th - 25th Oct 22"),
            mentors_reports("Google Africa Scholarship Report 16","By Ibrahim Kabir  -  19th - 25th Oct 22"),
            mentors_reports("Google Africa Scholarship Report 17 ","By Ibrahim Kabir  -  19th - 25th Oct 22"),
            mentors_reports("Google Africa Scholarship Report 18","By Ibrahim Kabir  -  19th - 25th Oct 22"),

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

        binding.mentors.text= MentorManagerApplication.global_Var_MENTOR_NAME
        binding.body2.text= MentorManagerApplication.global_Var_MENTOR_NAME
        binding.mentorProgramPic.setImageResource(MentorManagerApplication.global_Var_MENTOR_NAME_pic)

        binding.arrowLeft.setOnClickListener {
            activity?.onBackPressed();
        }

        binding.tasks.setOnClickListener {
            activity?.onBackPressed();
        }
        binding.certificate.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_mentors_Reports_fragments_to_mentor_certificates_fragment)
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding =null
    }



}