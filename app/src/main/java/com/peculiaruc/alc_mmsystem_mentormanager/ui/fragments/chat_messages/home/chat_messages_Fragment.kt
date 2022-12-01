package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.chat_messages.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.local.chat_messages.chat_messages
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentChatMessagesHomeBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.chat_messages.chat_messages_adapter

//handle the toggle screen in the chats
class chat_messages_Fragment : Fragment() {

    private var _binding: FragmentChatMessagesHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var rvAdapter: chat_messages_adapter
    private lateinit var chat_messages: List<chat_messages>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ):
            View? {
        _binding = FragmentChatMessagesHomeBinding.inflate(inflater, container, false)
        load_messages()
        val navView: BottomNavigationView = binding.navView


        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.mentor_profile
            )
        )
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentChatMessagesHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        homeViewModel.text.observe(viewLifecycleOwner) {

        }

        return binding.root
    }

    //this is loading the dummy data in the chat messages list
    private fun load_messages() {

        chat_messages = listOf(
            chat_messages(
                "Peculiar C. Umeh 1",
                "Can we go ahead to join the UI/UX Team Meeting now",
                "30m.",
                "3",
                R.drawable.ann
            ),
            chat_messages(
                "James M. Jonathan 2",
                "Can we go ahead to join the UI/UX Team Meeting now",
                "30m.",
                "3",
                R.drawable.ann_2
            ),
            chat_messages(
                "Pendo D Mwaruma 3",
                "Can we go ahead to join the UI/UX Team Meeting now",
                "30m.",
                "3",
                R.drawable.grace
            ),
            chat_messages(
                "Musango J Abdi 4",
                "Can we go ahead to join the UI/UX Team Meeting now",
                "30m.",
                "3",
                R.drawable.profile
            ),
            chat_messages(
                "Abdalah K. Karim 5",
                "Can we go ahead to join the UI/UX Team Meeting now",
                "30m.",
                "3",
                R.drawable.ann
            ),
            chat_messages(
                "Pombe R. Karisaa 6",
                "Can we go ahead to join the UI/UX Team Meeting now",
                "30m.",
                "3",
                R.drawable.ann_2
            ),
            chat_messages(
                "Peculiar C. Umeh 7",
                "Can we go ahead to join the UI/UX Team Meeting now",
                "30m.",
                "3",
                R.drawable.grace
            ),
            chat_messages(
                "James M. Jonathan 8",
                "Can we go ahead to join the UI/UX Team Meeting now",
                "30m.",
                "3",
                R.drawable.profile
            ),
            chat_messages(
                "Pendo D Mwaruma 9",
                "Can we go ahead to join the UI/UX Team Meeting now",
                "30m.",
                "3",
                R.drawable.ann_2
            ),
            chat_messages(
                "Musango J Abdi 10",
                "Can we go ahead to join the UI/UX Team Meeting now",
                "30m.",
                "3",
                R.drawable.ann
            ),


            )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.broadcastM.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_navigation_home_to_broadcast_messages_Fragment)
        }
        binding.carbonAdd.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_navigation_home_to_fragment_mm_chat2)
        }

        val navView: BottomNavigationView = binding.navView

        navView.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    //reports task
                    Navigation.findNavController(navView).navigate(R.id.action_navigation_home_to_activity_mm_reports)
                }
                R.id.Search -> {
                }
                R.id.programs -> {
                    Navigation.findNavController(navView).navigate(R.id.action_navigation_home_to_discussion_forum2)
                }
                R.id.Messages -> {

                }
                R.id.mentor_profile -> {
                    //mentor profile task
                    Navigation.findNavController(navView).navigate(R.id.action_navigation_home_to_mentor_list_Activity)
                }
            }
        }
        binding.arrowLeft.setOnClickListener {
            activity?.onBackPressed();
        }
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        // pass it to rvLists layoutManager
        binding.mentorTasksRecycleview.setLayoutManager(layoutManager)
        // initialize the adapter,
        // and pass the required argument
        rvAdapter = chat_messages_adapter(chat_messages)
        // attach adapter to the recycler view
        binding.mentorTasksRecycleview.adapter = rvAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()


    }
}