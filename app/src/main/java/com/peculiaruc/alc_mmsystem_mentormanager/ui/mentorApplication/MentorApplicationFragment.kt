package com.peculiaruc.alc_mmsystem_mentormanager.ui.mentorApplication

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.Mentor
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentMentorApplicationBinding
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentMentorBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseFragment
import com.peculiaruc.alc_mmsystem_mentormanager.ui.mentor.MentorViewModel
import com.peculiaruc.alc_mmsystem_mentormanager.ui.mentorManagerProfile.adapters.MentorAdapter


class MentorApplicationFragment : BaseFragment<FragmentMentorApplicationBinding>() {

    override val layoutIdFragment: Int = R.layout.fragment_mentor_application
    override val viewModel: MentorApplicationViewModel by viewModels()

    //*******For Text*******
    val list = listOf(
        Mentor("asd1", "", "", listOf()),
        Mentor("asd2", "", "", listOf()),
        Mentor("asd3", "", "", listOf()),
        Mentor("asd4", "", "", listOf()),
        Mentor("asd5", "", "", listOf()),
        Mentor("asd6", "", "", listOf()),
        Mentor("asd7", "", "", listOf()),
        Mentor("asd8", "", "", listOf()),
        Mentor("asd9", "", "", listOf()),
    )
    //////////////////

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(true, getString(R.string.applicant_requests))
        setBottomNavigationVisibility(false)
        setHasOptionsMenu(true)
        binding.recyclerMentor.adapter = MentorAdapter(list, viewModel)
        observeEvents()
    }

    private fun observeEvents() {

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.program, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.search -> {

            }
        }
        return super.onOptionsItemSelected(item)
    }

}