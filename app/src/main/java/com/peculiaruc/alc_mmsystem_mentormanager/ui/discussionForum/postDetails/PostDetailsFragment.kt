package com.peculiaruc.alc_mmsystem_mentormanager.ui.discussionForum.postDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.Comment
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentDiscussionForumBinding
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentPostDetailsBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseFragment
import com.peculiaruc.alc_mmsystem_mentormanager.ui.discussionForum.DiscussionAdapter
import com.peculiaruc.alc_mmsystem_mentormanager.ui.discussionForum.DiscussionForumViewModel


class PostDetailsFragment : BaseFragment<FragmentPostDetailsBinding>() {

    override val layoutIdFragment: Int = R.layout.fragment_post_details
    override val viewModel: PostDetailsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(true, getString(R.string.comments_title))
        setBottomNavigationVisibility(false)
        observeEvents()
        binding.commentList.adapter = CommentAdapter(list, viewModel)
    }

    private fun observeEvents() {

    }

    /////////FOR TEST \\\\\\\\\
    val list = mutableListOf(
        Comment(1, ""),
        Comment(2, ""),
        Comment(3, ""),
        Comment(4, ""),
        Comment(5, ""),
        Comment(6, ""),
        )


}