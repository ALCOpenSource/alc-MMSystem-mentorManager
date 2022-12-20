package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentMentorApplicantsBinding

/**
 *  Fragment for mentor applicants
 */

class MentorApplicants : Fragment() {

    private lateinit var binding: FragmentMentorApplicantsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentMentorApplicantsBinding.inflate(inflater)

        binding.btnBackHome.setOnClickListener {
            val action = MentorApplicantsDirections.actionMentorApplicantsToHomeFragment()
            it.findNavController().navigate(action)
        }
        binding.cardView1.setOnClickListener {
            val action = MentorApplicantsDirections.actionMentorApplicantsToMentorApplicationRequest()
            it.findNavController().navigate(action)
        }

        binding.btnAddApplicant.setOnClickListener{
            val dialogBinding = layoutInflater.inflate(R.layout.add_mentor_dialog, null)

            val myDialog = Dialog(requireContext())
            myDialog.setContentView(dialogBinding)
            myDialog.setCancelable(true)
            myDialog.window?.setGravity(Gravity.BOTTOM)
            myDialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            val sendMentorInvitation = dialogBinding.findViewById<Button>(R.id.send_mentor)
            sendMentorInvitation.setOnClickListener {

                myDialog.dismiss()

                val invitationDialogBinding = layoutInflater.inflate(R.layout.mentor_manager_invitation_dialog,null)

                val invitationDialog = Dialog(requireContext())
                invitationDialog.setContentView(invitationDialogBinding)
                invitationDialog.setCancelable(true)
                invitationDialog.window?.setGravity(Gravity.BOTTOM)
                invitationDialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                invitationDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

                val invitationSent = invitationDialogBinding.findViewById<Button>(R.id.btnMentorApprovalComplete)
                invitationSent.setOnClickListener {
                    invitationDialog.dismiss()
                }

                invitationDialog.show()
            }


            val requestDone = dialogBinding.findViewById<Button>(R.id.cancel_mentor)
            requestDone.setOnClickListener {

                myDialog.dismiss()
            }
            myDialog.show()
        }


            // Inflate the layout for this fragment
            return binding.root
        }

    }