package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentDiscussionForumBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.DiscussionForumAdapter
import com.peculiaruc.alc_mmsystem_mentormanager.util.OnBroadcastClickListener
import com.peculiaruc.alc_mmsystem_mentormanager.util.OnMessageClickListener
import com.peculiaruc.alc_mmsystem_mentormanager.util.OnShareClickListener


class DiscussionForumFragment : Fragment() {

    private var _binding: FragmentDiscussionForumBinding? = null
    private val binding
        get() = _binding!!

    private val discussions = arrayOf(
        "Samuel Kebede", "Samuel Kebede", "Samuel Kebede", "Samuel Kebede", "Samuel Kebede", "Samuel Kebede",
    )

    private val adapters = DiscussionForumAdapter(discussions)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDiscussionForumBinding.inflate(inflater, container, false)

        binding.carbonAdd.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_discussionForumFragment_to_newTopicFragment)


        }

        binding.forumToolbar.apply {
            setNavigationIcon(R.drawable.ic_back)
        }

        binding.forumList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapters
        }



        return binding.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}