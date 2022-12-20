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
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentGenerateCertBinding

/**
 * Fragment for generating certificates
 */

class GenerateCertFragment : Fragment() {

    private lateinit var binding: FragmentGenerateCertBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGenerateCertBinding.inflate(inflater)



        binding.autoCompleteProgram.setOnClickListener {
            val action =
                GenerateCertFragmentDirections.actionGenerateCertFragmentToCertRequestSelectFragment()
            it.findNavController().navigate(action)


        }

        binding.generateBtn.setOnClickListener {

            val dialogBinding = layoutInflater.inflate(R.layout.cert_request_select_dialog, null)

            val myDialog = Dialog(requireContext())
            myDialog.setContentView(dialogBinding)
            myDialog.setCancelable(true)
            myDialog.window?.setGravity(Gravity.BOTTOM)
            myDialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


            val requestDone = dialogBinding.findViewById<Button>(R.id.btnOpenEmailApp)
            requestDone.setOnClickListener {
//               val action = GenerateCertFragmentDirections.actionGenerateCertFragmentToGeneratedCertsFragment()
//                it.findNavController().navigate(action)
                myDialog.dismiss()
            }
            myDialog.show()
        }
        binding.gencertArrow.setOnClickListener {
            val action = GenerateCertFragmentDirections.actionGenerateCertFragmentToCertBeneficiaryFragment()
            it.findNavController().navigate(action)
        }

        // Inflate the layout for this fragment
        return binding.root
    }


}