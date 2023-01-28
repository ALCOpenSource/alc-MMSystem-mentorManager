package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.DocumentDto
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentProfileBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.authentication.login.LoginActivity
import com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.DocumentsProfileAdapter
import com.peculiaruc.alc_mmsystem_mentormanager.ui.viewmodels.ProfileViewModel

/**
 * this fragment is used to show the profile of the user
 */
class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

    private val binding get() = _binding!!

    private lateinit var viewModel: ProfileViewModel

//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.navigation.findNavController
//import com.peculiaruc.alc_mmsystem_mentormanager.R
//import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentProfileBinding
//
///**
// * Fragment to display mentor managers profile data
// */
//class ProfileFragment : Fragment() {
//
//    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        _binding = FragmentProfileBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[ProfileViewModel::class.java]

        Glide.with(this).load("https://images.unsplash.com/photo-1632765854612-9b02b6ec2b15?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1886&q=80")
            .circleCrop()
            .placeholder(R.drawable.profile_circle)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.imageViewProfileImg)

        val fakeDocs = listOf(
            DocumentDto(1, "Myresume.pdf"),
            DocumentDto(2, "my certificate.doc"),
            DocumentDto(3, "certificate2.doc"),
        )

        val documentsProfileAdapter = DocumentsProfileAdapter {

        }

        binding.buttonLogout.setOnClickListener {
            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }

        binding.recyclerViewDocuments.adapter = documentsProfileAdapter

        documentsProfileAdapter.submitList(fakeDocs)
//
//        binding.buttonEditProfile.setOnClickListener {
//            findNavController().navigate(ProfileFragmentDirections.actionProfileFragmentToEditProfileFragment())
//        }
//
//        binding.toolbar.setNavigationOnClickListener {
//            findNavController().navigate(ProfileFragmentDirections.actionProfileFragmentToNotificationsFragment())
//        }

        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
//    ): View? {
//
//        binding = FragmentProfileBinding.inflate(inflater)
//
//        binding.btnSearch.setOnClickListener{
//            val action = ProfileFragmentDirections.actionProfileFragmentToEditMyProfileFragment()
//            it.findNavController().navigate(action)
//        }
//
//        binding.btnBackProfile.setOnClickListener {
//            val action = ProfileFragmentDirections.actionProfileFragmentToHomeFragment()
//            it.findNavController().navigate(action)
//        }
//
//        binding.chipPrograms.setOnClickListener{
//            val action = ProfileFragmentDirections.actionProfileFragmentToProgramDummy()
//            it.findNavController().navigate(action)
//        }
//
//        binding.chipMentors.setOnClickListener{
//            val action = ProfileFragmentDirections.actionProfileFragmentToMentorsDummy()
//            it.findNavController().navigate(action)
//        }
//        binding.chipTasks.setOnClickListener {
//            val action = ProfileFragmentDirections.actionProfileFragmentToTaskDummy()
//            it.findNavController().navigate(action)
//        }
//        binding.chipReports.setOnClickListener {
//            val action = ProfileFragmentDirections.actionProfileFragmentToReportsDummy()
//            it.findNavController().navigate(action)
//        }
//        // Inflate the layout for this fragment
//        return binding.root
//    }

}