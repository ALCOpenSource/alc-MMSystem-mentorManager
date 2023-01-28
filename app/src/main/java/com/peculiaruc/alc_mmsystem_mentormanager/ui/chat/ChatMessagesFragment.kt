package com.peculiaruc.alc_mmsystem_mentormanager.ui.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.chatMessages.ChatMessage
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentChatMessagesHomeBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.chat_messages.chat_messages_adapter

/**handle the toggle screen in the chats
 *
 */
class ChatMessagesFragment : Fragment() {

    private var _binding: FragmentChatMessagesHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var rvAdapter: chat_messages_adapter
    private lateinit var chat_messages: List<ChatMessage>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChatMessagesHomeBinding.inflate(inflater, container, false)
        load_messages()

        val homeViewModel =
            ViewModelProvider(this).get(ChatViewModel::class.java)
        _binding = FragmentChatMessagesHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        homeViewModel.text.observe(viewLifecycleOwner) {

        }

        return binding.root
    }


    private fun load_messages() {

        chat_messages = listOf(
            ChatMessage(
                "Peculiar C. Umeh 1",
                "Can we go ahead to join the UI/UX Team Meeting now1",
                "30m.",
                "3",
                R.drawable.ann
            ),
            ChatMessage(
                "James M. Jonathan 2",
                "Can we go ahead to join the UI/UX Team Meeting now2",
                "30m.",
                "3",
                R.drawable.ann_2
            ),
            ChatMessage(
                "Pendo D Mwaruma 3",
                "Can we go ahead to join the UI/UX Team Meeting now3",
                "30m.",
                "3",
                R.drawable.grace
            ),
            ChatMessage(
                "Musango J Abdi 4",
                "Can we go ahead to join the UI/UX Team Meeting now4",
                "30m.",
                "3",
                R.drawable.profile_img
            ),
            ChatMessage(
                "Abdalah K. Karim 5",
                "Can we go ahead to join the UI/UX Team Meeting now5",
                "30m.",
                "3",
                R.drawable.ann
            ),
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.broadcastM.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_chatMessagesFragment_to_individualChatFragment)

        }
        binding.carbonAdd.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_chatMessagesFragment_to_broadcastMessagesFragment)
        }

        binding.broadcastM.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_chatMessagesFragment_to_broadcastMessagesFragment)
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
}