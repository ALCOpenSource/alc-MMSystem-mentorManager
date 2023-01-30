package com.peculiaruc.alc_mmsystem_mentormanager.ui.disscussion_forum


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.CommentDeletedDialogueBinding

/**
 * implement the functionality of the comment delete screen
 */
class CommentDeletedDialogue : BottomSheetDialogFragment() {
    private var _binding: CommentDeletedDialogueBinding? = null
    private val binding
    get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = CommentDeletedDialogueBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}