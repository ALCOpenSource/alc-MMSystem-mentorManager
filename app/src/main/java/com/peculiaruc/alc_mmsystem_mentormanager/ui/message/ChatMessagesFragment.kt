package com.peculiaruc.alc_mmsystem_mentormanager.ui.message

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.Chat
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentChatMessagesBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseFragment
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.EventObserve


class ChatMessagesFragment : BaseFragment<FragmentChatMessagesBinding>() {

    override val layoutIdFragment: Int = R.layout.fragment_chat_messages
    override val viewModel: ChatMessagesViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(true, getString(R.string.messages))
        setBottomNavigationVisibility(true)
        setHasOptionsMenu(true)
        initData()
        observeEvents()
    }


    private fun initData() {
        val list = mutableListOf(
            Chat("Ahmed", "Test test test ", 1, 1, "20m"),
            Chat(
                "Peculiah C. Umeh",
                "Can we go ahead to join the UI/UX Team Meeting no",
                1,
                3,
                "20m"
            ),
            Chat("Noor", "need to chat now ", 1, 6, "20m"),
            Chat("Tala", "more info please.", 1, 10, "20m"),
        )
        binding.recyclerViewChat.adapter = ChatAdapter(list, viewModel)
    }

    private fun observeEvents() {
        viewModel.selectConversationEvent.observe(viewLifecycleOwner, EventObserve {
            findNavController().navigate(ChatMessagesFragmentDirections.actionChatMessagesFragmentToConversationFragment())
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.chat_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.search -> {

            }
        }
        return super.onOptionsItemSelected(item)
    }

}