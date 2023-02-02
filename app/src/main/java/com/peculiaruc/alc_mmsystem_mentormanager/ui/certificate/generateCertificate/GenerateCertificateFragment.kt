package com.peculiaruc.alc_mmsystem_mentormanager.ui.certificate.generateCertificate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentCertificateBeneficiaryBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseFragment
import com.peculiaruc.alc_mmsystem_mentormanager.ui.certificate.beneficiary.BeneficiaryMemberAdapter
import com.peculiaruc.alc_mmsystem_mentormanager.ui.certificate.beneficiary.CertificateBeneficiaryViewModel


class GenerateCertificateFragment : BaseFragment<FragmentCertificateBeneficiaryBinding>() {

    override val layoutIdFragment: Int = R.layout.fragment_generate_certificate
    override val viewModel: GenerateCertificateViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(true, getString(R.string.select_program_title))
        setBottomNavigationVisibility(false)
        onEvents()
    }

    private fun onEvents() {

    }


}