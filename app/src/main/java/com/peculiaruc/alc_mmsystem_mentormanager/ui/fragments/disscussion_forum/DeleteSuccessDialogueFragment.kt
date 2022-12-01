package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.disscussion_forum

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.CommentDeletedDialogueBinding
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.DeleteSuccessDialogueBinding

class DeleteSuccessDialogueFragment : BottomSheetDialogFragment() {
    private var _binding: DeleteSuccessDialogueBinding? = null
    private val binding
        get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = DeleteSuccessDialogueBinding.inflate(inflater,container, false)

        return binding.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}