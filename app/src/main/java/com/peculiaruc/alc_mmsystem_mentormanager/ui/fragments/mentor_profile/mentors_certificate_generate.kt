package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.mentor_profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.appcompat.app.AlertDialog
import androidx.navigation.Navigation
import com.peculiaruc.alc_mmsystem_mentormanager.MentorManagerApplication
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentMentorsCertificateDownloadBinding


/**
 * This handles the   generation of mentors certificate
 * no dummy data is loaded
 * current no functionality is implemented,
 *  only ui and some navigation
 */


class mentors_certificate_generate : Fragment() {
    private var _binding: FragmentMentorsCertificateDownloadBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMentorsCertificateDownloadBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.frame351.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.alert_dialog_box_certificate_downloaded_succesfully, null)
            val customDialog = context?.let { it1 ->
                AlertDialog.Builder(it1)
                    .setView(dialogView)
                    .show()
            }
            val btDismiss = dialogView.findViewById<RelativeLayout>(R.id.frame_351)
            btDismiss.setOnClickListener {
                if (customDialog != null) {
                    customDialog.dismiss()
                }
            }
        }

        binding.mentors.text= MentorManagerApplication.global_Var_MENTOR_NAME_certificate_name
        binding.body2.text= MentorManagerApplication.global_Var_MENTOR_NAME
        binding.mentorProgramPic.setImageResource(MentorManagerApplication.global_Var_MENTOR_NAME_pic)

        binding.arrowLeft.setOnClickListener {
            activity?.onBackPressed();
        }




        binding.ace1.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_mentors_certificate_generate_to_cert_select_program)

        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding =null
    }

}