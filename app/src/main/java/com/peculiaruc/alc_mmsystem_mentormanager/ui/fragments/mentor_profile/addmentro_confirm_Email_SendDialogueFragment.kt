package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.mentor_profile


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.AlertDialogBoxAddMentorBinding
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.AlertDialogBoxDoneAddingMentorBinding
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.SubmitSuccessDialogueBinding

/**
 * to implement the success dialogue screen functionality
 *
 */

class addmentro_confirm_Email_SendDialogueFragment : BottomSheetDialogFragment() {
    private var _binding: AlertDialogBoxDoneAddingMentorBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = AlertDialogBoxDoneAddingMentorBinding.inflate(inflater, container, false)
        binding.frame351.setOnClickListener {
            activity?.onBackPressed();

        }
        return binding.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}