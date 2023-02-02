package com.peculiaruc.alc_mmsystem_mentormanager.ui.certificate.beneficiary

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.BeneficiaryMember
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.Certificate
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentCertificateBeneficiaryBinding
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentCertificateBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseFragment
import com.peculiaruc.alc_mmsystem_mentormanager.ui.certificate.CertificateViewModel
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.EventObserve


class CertificateBeneficiaryFragment : BaseFragment<FragmentCertificateBeneficiaryBinding>() {

    override val layoutIdFragment: Int = R.layout.fragment_certificate_beneficiary
    override val viewModel: CertificateBeneficiaryViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(true, getString(R.string.select_beneficiary_title))
        setBottomNavigationVisibility(false)
        setHasOptionsMenu(true)
        onEvents()
        binding.recyclerBeneficiaries.adapter = BeneficiaryMemberAdapter(listMembers, viewModel)
    }


    private fun onEvents() {
        viewModel.selectMemberEvent.observe(viewLifecycleOwner, EventObserve {
            findNavController().navigate(CertificateBeneficiaryFragmentDirections.actionCertificateBeneficiaryFragmentToGenerateCertificateFragment())
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

    val listMembers = listOf(
        BeneficiaryMember("", "GADS CLOUD 2022 CERTIFICATE", "", emptyList()),
        BeneficiaryMember("", "GADS CLOUD 2022 CERTIFICATE", "", emptyList()),
        BeneficiaryMember("", "GADS CLOUD 2022 CERTIFICATE", "", emptyList()),
        BeneficiaryMember("", "GADS CLOUD 2022 CERTIFICATE", "", emptyList()),
        BeneficiaryMember("", "GADS CLOUD 2022 CERTIFICATE", "", emptyList()),
        BeneficiaryMember("", "GADS CLOUD 2022 CERTIFICATE", "", emptyList()),
        BeneficiaryMember("", "GADS CLOUD 2022 CERTIFICATE", "", emptyList()),
        BeneficiaryMember("", "GADS CLOUD 2022 CERTIFICATE", "", emptyList()),
        BeneficiaryMember("", "GADS CLOUD 2022 CERTIFICATE", "", emptyList()),
    )
}