package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
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

        binding.forumToolbar.apply {
            setNavigationIcon(R.drawable.ic_back)
        }

        binding.forumList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapters
        }

        adapters.apply {
            setOnMessageClickListener(object : OnMessageClickListener{
                override fun onMessageClick() {
                    val fragment = CommentsFragment()
                    activity?.supportFragmentManager?.commit {
                        setCustomAnimations(
                            R.anim.slide_in,
                            R.anim.fade_out
                        )
                        replace(R.id.fragment_container_view, fragment)
                        addToBackStack(null)
                    }
                }
            })

            setOnBroadcastClickListener(object : OnBroadcastClickListener{
                override fun onBroadcastClick() {
                    val fragment = NewTopicFragment()
                    activity?.supportFragmentManager?.commit {
                        setCustomAnimations(
                            R.anim.slide_in,
                            R.anim.fade_out
                        )
                        replace(R.id.fragment_container_view, fragment)
                        addToBackStack(null)
                    }
                }
            })

            setOnShareClickListener(object : OnShareClickListener{
                override fun onShareClick() {
                    val fragment = EditPostFragment()
                    activity?.supportFragmentManager?.commit {
                        setCustomAnimations(
                            R.anim.slide_in,
                            R.anim.fade_out
                        )
                        replace(R.id.fragment_container_view, fragment)
                        addToBackStack(null)
                    }
                }
            })
        }

        return binding.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}