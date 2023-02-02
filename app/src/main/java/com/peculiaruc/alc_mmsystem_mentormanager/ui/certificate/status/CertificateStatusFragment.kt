package com.peculiaruc.alc_mmsystem_mentormanager.ui.certificate.status

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.Certificate
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentCertificateBinding
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentCertificateStatusBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseFragment
import com.peculiaruc.alc_mmsystem_mentormanager.ui.certificate.CertificateStatus
import com.peculiaruc.alc_mmsystem_mentormanager.ui.certificate.CertificateViewModel
import com.peculiaruc.alc_mmsystem_mentormanager.ui.mentorManagerProfile.adapters.CertificateAdapter
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.EventObserve


class CertificateStatusFragment : BaseFragment<FragmentCertificateStatusBinding>() {

    override val layoutIdFragment: Int = R.layout.fragment_certificate_status
    override val viewModel: CertificateStatusViewModel by viewModels()
    private val args: CertificateStatusFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = when (args.type) {
            CertificateStatus.EARNED -> "Earned Certificates"
            CertificateStatus.APPROVED -> "Approved Certificates"
            else -> "Pending Certificates"
        }

        setTitle(true, title)
        setBottomNavigationVisibility(false)
        setHasOptionsMenu(true)
        onEvents()
        binding.recyclerCertificate.adapter = CertificateAdapter(listCertificate, viewModel)
    }

    private fun onEvents() {
        viewModel.selectCertificateEvent.observe(viewLifecycleOwner, EventObserve { certificate ->
            findNavController().navigate(
                CertificateStatusFragmentDirections.actionCertificateStatusFragmentToCertificateFragment(
                    certificate.title
                )
            )
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.program, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.search) {
            Toast.makeText(requireContext(), "search", Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }

    //******** For Test Only ***********\\
    val listCertificate = listOf(
        Certificate("", "GADS CLOUD 2022 CERTIFICATE"),
        Certificate("", "GADS ANDROID 2022 CERTIFICATE"),
        Certificate("", "GADS CLOUD 2021 CERTIFICATE"),
        Certificate("", "GADS ANDROID 2021 CERTIFICATE"),
        Certificate("", "GADS CLOUD 2020 CERTIFICATE"),
        Certificate("", "GADS ANDROID 2020 CERTIFICATE"),
        Certificate("", "GADS CLOUD 2019 CERTIFICATE"),
        Certificate("", "GADS ANDROID 2019 CERTIFICATE"),
        Certificate("", "GADS CLOUD 2019 CERTIFICATE"),
        Certificate("", "GADS ANDROID 2019 CERTIFICATE"),
        Certificate("", "GADS WEB 2020 CERTIFICATE"),
        Certificate("", "GADS WEB 2021 CERTIFICATE")
    )

}