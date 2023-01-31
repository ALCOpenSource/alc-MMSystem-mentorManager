package com.peculiaruc.alc_mmsystem_mentormanager.ui.message.conversation

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentConversationBinding
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentProgramBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseFragment
import com.peculiaruc.alc_mmsystem_mentormanager.ui.program.ProgramViewModel


class ConversationFragment : BaseFragment<FragmentConversationBinding>() {

    override val layoutIdFragment: Int = R.layout.fragment_conversation
    override val viewModel: ConversationViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(false)
        setBottomNavigationVisibility(false)
        onEvents()
    }

    private fun onEvents() {

    }


}