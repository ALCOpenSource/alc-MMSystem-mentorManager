package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.mentor_profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import androidx.appcompat.app.AlertDialog
import androidx.navigation.Navigation
import com.peculiaruc.alc_mmsystem_mentormanager.MentorManagerApplication
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentCertSelectProgramBinding

/**handle the fragment select program  screen
* currently not linked to any data and no functionality set
 */

class cert_select_program : Fragment(){
    private var _binding: FragmentCertSelectProgramBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCertSelectProgramBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.frame351.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.alert_dialog_box_certificate_sent_for_aproval, null)
            val customDialog = context?.let { it1 ->
                AlertDialog.Builder(it1)
                    .setView(dialogView)
                    .show()
            }
            val btDismiss = dialogView.findViewById<Button>(R.id.frame_351)
            btDismiss.setOnClickListener {
                if (customDialog != null) {
                    customDialog.dismiss()
                }
            }
        }

        binding.mentors.text= MentorManagerApplication.global_Var_MENTOR_NAME_certificate_name
        binding.mentorName.text= MentorManagerApplication.global_Var_MENTOR_NAME
        binding.mentorProfilePic.setImageResource(MentorManagerApplication.global_Var_MENTOR_NAME_pic)

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