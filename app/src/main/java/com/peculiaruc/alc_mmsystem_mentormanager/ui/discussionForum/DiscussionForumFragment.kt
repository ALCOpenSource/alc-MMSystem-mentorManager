package com.peculiaruc.alc_mmsystem_mentormanager.ui.discussionForum

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.Discussion
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentDiscussionForumBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseFragment

class DiscussionForumFragment : BaseFragment<FragmentDiscussionForumBinding>() {

    override val layoutIdFragment: Int = R.layout.fragment_discussion_forum
    override val viewModel: DiscussionForumViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(true, getString(R.string.discussion_forum_title))
        setBottomNavigationVisibility(false)
        setHasOptionsMenu(true)
        observeEvents()
        binding.forumList.adapter = DiscussionAdapter(list, viewModel)
    }

    private fun observeEvents() {

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.discussion_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.search) {
            Toast.makeText(requireContext(), "search", Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }

    ////// FOR TEST \\\\\\\
    val list = mutableListOf(
        Discussion(""),
        Discussion(""),
        Discussion(""),
        Discussion(""),
        Discussion(""),
        Discussion(""),
    )
}