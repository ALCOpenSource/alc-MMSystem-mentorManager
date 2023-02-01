package com.peculiaruc.alc_mmsystem_mentormanager.ui.mentor

import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.Mentor
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentMentorBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseFragment
import com.peculiaruc.alc_mmsystem_mentormanager.ui.mentorManagerProfile.adapters.MentorAdapter
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.EventObserve


class MentorFragment : BaseFragment<FragmentMentorBinding>() {

    override val layoutIdFragment: Int = R.layout.fragment_mentor
    override val viewModel: MentorViewModel by viewModels()

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

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(true, getString(R.string.mentors))
        setBottomNavigationVisibility(false)
        setHasOptionsMenu(true)
        binding.recyclerMentor.adapter = MentorAdapter(list, viewModel)
        observeEvents()
    }

    private fun observeEvents() {
        viewModel.selectMentor.observe(viewLifecycleOwner, EventObserve {
            findNavController().navigate(MentorFragmentDirections.actionMentorFragmentToMentorManagerProfileFragment())
        })

        viewModel.addMentorEvent.observe(viewLifecycleOwner, EventObserve {
//            findNavController().navigate(MentorMangerFragmentDirections.actionMentorMangerFragmentToMentorManagerDialog())
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.mentor_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.message -> {

            }
            R.id.search -> {

            }
        }
        return super.onOptionsItemSelected(item)
    }


}