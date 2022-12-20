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
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentMyCertDownloadBinding
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentMyReportDetailsBinding

/**
 * Fragment for download of mentor certificate
 */
class MyCertDownloadFragment : Fragment() {

    private lateinit var binding: FragmentMyCertDownloadBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMyCertDownloadBinding.inflate(inflater)

        binding.btnDownloadCertificate.setOnClickListener {


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

        binding.btnBackArrow.setOnClickListener {
            val action = MyCertDownloadFragmentDirections.actionMyCertDownloadFragmentToCertificatesDummy()
            it.findNavController().navigate(action)
        }


        // Inflate the layout for this fragment
        return binding.root
    }

}