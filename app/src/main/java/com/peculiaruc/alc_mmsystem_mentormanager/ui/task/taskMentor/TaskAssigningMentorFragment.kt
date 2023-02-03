package com.peculiaruc.alc_mmsystem_mentormanager.ui.task.taskMentor

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.Mentor
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentTaskAssiningMentorBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseFragment
import com.peculiaruc.alc_mmsystem_mentormanager.ui.mentorManagerProfile.adapters.MentorAdapter
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.EventObserve

class TaskAssigningMentorFragment : BaseFragment<FragmentTaskAssiningMentorBinding>() {

    override val layoutIdFragment: Int = R.layout.fragment_task_assining_mentor
    override val viewModel: TaskAssigningMentorViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(true, getString(R.string.select_mentor_title))
        setBottomNavigationVisibility(false)
        onEvents()
        binding.recyclerMentor.adapter = MentorAdapter(list, viewModel)
    }

    private fun onEvents() {
        viewModel.selectMentorEvent.observe(viewLifecycleOwner, EventObserve {
            findNavController().navigateUp()
        })

        viewModel.doneSelectionEvent.observe(viewLifecycleOwner, EventObserve {
            findNavController().navigateUp()
        })
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

}