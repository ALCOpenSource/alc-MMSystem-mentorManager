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
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentMyReportDetailsBinding

/**
 * Fragment to show program report details
 */
class MyReportDetails : Fragment() {

    private lateinit var binding: FragmentMyReportDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMyReportDetailsBinding.inflate(inflater)

        binding.btnShareReport.setOnClickListener {

            val dialogBinding = layoutInflater.inflate(R.layout.share_report_dialog, null)

            val myDialog = Dialog(requireContext())
            myDialog.setContentView(dialogBinding)
            myDialog.setCancelable(true)
            myDialog.window?.setGravity(Gravity.BOTTOM)
            myDialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


            val requestDone = dialogBinding.findViewById<Button>(R.id.btnOpenEmailApp)
            requestDone.setOnClickListener {

                // TODO: Add open email intent

                myDialog.dismiss()
            }

            val openEmail = dialogBinding.findViewById<Button>(R.id.btnCancel)
            requestDone.setOnClickListener {

                myDialog.dismiss()
            }
            myDialog.show()
        }

        binding.btnDownloadReport.setOnClickListener {

            val dialogBinding = layoutInflater.inflate(R.layout.successful_download_dialog, null)

            val myDialog = Dialog(requireContext())
            myDialog.setContentView(dialogBinding)
            myDialog.setCancelable(true)
            myDialog.window?.setGravity(Gravity.BOTTOM)
            myDialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


            val requestDone = dialogBinding.findViewById<Button>(R.id.btnSuccessfulDownload)
            requestDone.setOnClickListener {

                myDialog.dismiss()
            }
            myDialog.show()

        }
//        binding.btnCloseReport.setOnClickListener {
//            val action = MyReportDetailsDirections.actionMyReportDetailsToReportsDummy()
//            it.findNavController().navigate(action)
//        }


        // Inflate the layout for this fragment
        return binding.root
    }


}