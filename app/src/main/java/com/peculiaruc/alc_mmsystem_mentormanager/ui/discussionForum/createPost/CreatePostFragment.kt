package com.peculiaruc.alc_mmsystem_mentormanager.ui.discussionForum.createPost

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentCreatePostBinding
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentEditPostBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseFragment
import com.peculiaruc.alc_mmsystem_mentormanager.ui.discussionForum.editPost.PostViewModel

class CreatePostFragment : BaseFragment<FragmentCreatePostBinding>() {

    override val layoutIdFragment: Int = R.layout.fragment_create_post
    override val viewModel: PostViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(true, getString(R.string.create_post))
        setBottomNavigationVisibility(false)
    }

}