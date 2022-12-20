package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.navigation.findNavController
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentEditMyProfileBinding

/**
 * fragment to edit profile data
 */

class EditMyProfileFragment : Fragment() {

    var binding:FragmentEditMyProfileBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditMyProfileBinding.inflate(layoutInflater)

        binding!!.btnBackHome.setOnClickListener {
            val action = EditMyProfileFragmentDirections.actionEditMyProfileFragmentToProfileFragment()
            it.findNavController().navigate(action)
        }
        binding!!.btnSave.setOnClickListener {
            val dialogBinding = layoutInflater.inflate(R.layout.edit_profile_success_dialog, null)

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



        //Country Exposed DropDown
        val country = resources.getStringArray(R.array.Countries)
        val countryArrayAdapter = ArrayAdapter(requireContext(),R.layout.drop_down_item,country)
        binding?.autoCompleteCountryTextView?.setAdapter(countryArrayAdapter)


        //City Exposed DropDown
        val city = resources.getStringArray(R.array.Cities)
        val cityArrayAdapter = ArrayAdapter(requireContext(),R.layout.drop_down_item,city)
        binding?.autoCompleteCityTextView?.setAdapter(cityArrayAdapter)
        // Inflate the layout for this fragment
        return binding?.root
    }


}