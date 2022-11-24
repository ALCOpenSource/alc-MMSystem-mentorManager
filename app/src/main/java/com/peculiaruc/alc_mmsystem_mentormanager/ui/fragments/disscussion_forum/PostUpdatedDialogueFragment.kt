package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.disscussion_forum

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.CommentDeletedDialogueBinding
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.PostUpdatedDialogueBinding

class PostUpdatedDialogueFragment : DialogFragment() {
    private var _binding: PostUpdatedDialogueBinding? = null
    private val binding
        get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = PostUpdatedDialogueBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}