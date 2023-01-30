package com.peculiaruc.alc_mmsystem_mentormanager.ui.chat.broadcastMessages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.chatMessages.ChatBroadcastMessage
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentBroadcastMessagesBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.chat_messages.chat_broadcast_messages_adapter
import com.peculiaruc.alc_mmsystem_mentormanager.ui.chat.chatIndividual.IndividualChatsViewModel

/**
 * MMM-Team-7
 * Main fragment for broadcast messages
 */

class BroadcastMessagesFragment : Fragment() {

    private var _binding: FragmentBroadcastMessagesBinding? = null
    private val binding get() = _binding!!
    private lateinit var rvAdapter: chat_broadcast_messages_adapter
    private lateinit var chat_messages: List<ChatBroadcastMessage>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ):
            View {
        _binding = FragmentBroadcastMessagesBinding.inflate(inflater, container, false)
        load_messages()

        val homeViewModel =
            ViewModelProvider(this).get(BroadcastMessagesViewModel::class.java)
        _binding = FragmentBroadcastMessagesBinding.inflate(inflater, container, false)
        val root: View = binding.root
        homeViewModel.text.observe(viewLifecycleOwner) {

        }

        return binding.root
    }

    private fun load_messages() {

        chat_messages = listOf(
            ChatBroadcastMessage(
                "Peculiar C. Umeh1  ",
                "Hello Kabiru, trust you are well?",
                1,
                "10:30 am",
                R.drawable.ann_2
            ),
            ChatBroadcastMessage(
                "Kabiru M. Magaya2 ",
                "Hi Peculiar, i am well. Thanks",
                0,
                "10:30 am",
                R.drawable.ann_2
            ),
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.broadcastM.setOnClickListener {
//            Navigation.findNavController(it).navigate(R.id.action_navigation_home_to_fragment_mm_chat2)

        }
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        // pass it to rvLists layoutManager
        binding.mentorTasksRecycleview.setLayoutManager(layoutManager)

        rvAdapter = chat_broadcast_messages_adapter(chat_messages)
        // attach adapter to the recycler view
        binding.mentorTasksRecycleview.adapter = rvAdapter
        binding.arrowLeft.setOnClickListener {
            activity?.onBackPressed();
        }
        binding.frame330.setOnClickListener {
            activity?.onBackPressed();
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()


    }
}