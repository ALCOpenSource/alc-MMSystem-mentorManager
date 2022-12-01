package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.mentor_profile

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.Navigation
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentReportDetailsBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.mentor_reports.DownloadDialogueFragment
import com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.mentor_reports.ShareDialogueFragment

/**
 * This handles the details of the report
 * current no functionality is implemented,
 *  only ui and some navigation
 */

class mentor_report_details : Fragment() {
    private var _binding: FragmentReportDetailsBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReportDetailsBinding.inflate(inflater, container, false)

        binding.detailsCancel.setOnClickListener {
            Navigation.findNavController(requireView()).popBackStack(R.id.reportFragment, false)
        }

        binding.detailsShare.setOnClickListener {

            val dialogshare = layoutInflater.inflate(R.layout.share_dialogue_fragment, null)
            val customDialog = context?.let {
                    it1 ->
                AlertDialog.Builder(it1)
                    .setView(dialogshare)
                    .show() }
            customDialog?.getWindow()?.setGravity(Gravity.BOTTOM)

            // on click of cancel button close the dialog box
            val btn_add_mentor_dialog_cancel = dialogshare.findViewById<Button>(R.id.button4)
            btn_add_mentor_dialog_cancel.setOnClickListener {
                if (customDialog != null)
                { customDialog.dismiss() }
            }
            // on click of send button open the confirm_send dialog box the
            val btn_add_mentor_dialog_Send = dialogshare.findViewById<Button>(R.id.button3)
            btn_add_mentor_dialog_Send.setOnClickListener {
                Toast.makeText(context, "Implement share report via email", Toast.LENGTH_SHORT).show()

            }

        }

        binding.detailsDownload.setOnClickListener {

            val dialogdownload = layoutInflater.inflate(R.layout.download_dialogue_fragment, null)
            val customDialog = context?.let {
                    it1 ->
                AlertDialog.Builder(it1)
                    .setView(dialogdownload)
                    .show() }
            customDialog?.getWindow()?.setGravity(Gravity.BOTTOM)

            // on click of cancel button close the dialog box
            val btn_add_mentor_dialog_cancel = dialogdownload.findViewById<Button>(R.id.button2)
            btn_add_mentor_dialog_cancel.setOnClickListener {
                if (customDialog != null)
                { customDialog.dismiss() }
            }





        }

        return binding.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}