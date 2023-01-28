package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.chat_messages.chat_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.alc_mmsystem_mentormanager.MentorManagerApplication.Companion.global_Var_chat_partner
import com.peculiaruc.alc_mmsystem_mentormanager.MentorManagerApplication.Companion.global_Var_chat_profile_pic
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.chatMessages.IndividualChatMessage
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentChatsBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.chat_messages.individual_chat_fragment_adapter
import com.peculiaruc.alc_mmsystem_mentormanager.ui.viewmodels.individual_chats_viewmodel

/** class the functionality of the  chats screen currently it load dummy data and no additional funcitonality
 *
 */

class individual_chat_fragment : Fragment() {
    private var _binding: FragmentChatsBinding? = null
    private val binding get() = _binding!!
    private lateinit var rvAdapter: individual_chat_fragment_adapter
    private lateinit var chat_messages: List<IndividualChatMessage>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ):
            View? {
        _binding = FragmentChatsBinding.inflate(inflater, container, false)
        load_messages()
        val homeViewModel =
            ViewModelProvider(this).get(individual_chats_viewmodel::class.java)
        _binding = FragmentChatsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        homeViewModel.text.observe(viewLifecycleOwner) {
        }
        return binding.root
    }
    private fun load_messages() {

        chat_messages = listOf(
            IndividualChatMessage("Peculiar C. Umeh1","Hello Kabiru, trust you are well?",1,"10:30 am", R.drawable.grace),
            IndividualChatMessage("Kabiru M. Magaya2","Hi Peculiar, i am well. Thanks",0,"10:30 am", R.drawable.profile_img),
            )

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        // pass it to rvLists layoutManager

        binding.mentors.text=global_Var_chat_partner
        binding.mentorProgramPic.setImageResource(global_Var_chat_profile_pic)
        binding.mentorTasksRecycleview.setLayoutManager(layoutManager)

        rvAdapter= individual_chat_fragment_adapter(chat_messages)
        // attach adapter to the recycler view
        binding.mentorTasksRecycleview.adapter = rvAdapter

        binding.arrowLeft.setOnClickListener {
            activity?.onBackPressed();
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()


    }
}