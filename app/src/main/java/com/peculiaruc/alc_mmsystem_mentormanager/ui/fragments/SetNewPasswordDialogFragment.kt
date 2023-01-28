package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentSetNewPasswordDialogBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.authentication.login.LoginActivity

/**
 * its a bottom sheet dialog for Program set new password success
 */
class SetNewPasswordDialogFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentSetNewPasswordDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSetNewPasswordDialogBinding.inflate(inflater, container, false)

        binding.buttonLogin.setOnClickListener {
            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
            dismiss()
        }

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onDismiss(dialog: DialogInterface) {
        activity?.finish()
        super.onDismiss(dialog)
    }
}