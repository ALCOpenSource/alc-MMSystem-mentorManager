package com.peculiaruc.alc_mmsystem_mentormanager.ui.authentication.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.DocumentDto
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentRegistrationForthFormBinding
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentRegistrationThirdFormBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseFragment
import com.peculiaruc.alc_mmsystem_mentormanager.ui.mentorManagerProfile.adapters.CertificateAdapter
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.EventObserve


class RegistrationForthFormFragment : BaseFragment<FragmentRegistrationForthFormBinding>() {

    override val layoutIdFragment: Int = R.layout.fragment_registration_forth_form
    override val viewModel: RegisterViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        observeEvents()
    }

    private fun initData() {
        val fakeDocs = listOf(
            DocumentDto(1, "Myresume.pdf"),
            DocumentDto(2, "my certificate.doc"),
            DocumentDto(3, "my certificate2.doc"),
        )
        binding.recyclerViewDocuments.adapter = DocumentAdapter(fakeDocs, viewModel)

    }

    private fun observeEvents() {
        viewModel.registerPageEvent.observe(viewLifecycleOwner, EventObserve { page ->
            if (page == 5) {
                findNavController().navigate(RegistrationForthFormFragmentDirections.actionRegistrationForthFormFragmentToRegisterNotificationFragment())
            } else {
                findNavController().navigateUp()
            }
        })
    }

}