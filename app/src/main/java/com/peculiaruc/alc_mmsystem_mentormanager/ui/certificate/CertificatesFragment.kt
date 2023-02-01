package com.peculiaruc.alc_mmsystem_mentormanager.ui.certificate

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentCertificateBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseFragment
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.EventObserve


class CertificatesFragment : BaseFragment<FragmentCertificateBinding>() {

    override val layoutIdFragment: Int = R.layout.fragment_certificates
    override val viewModel: CertificateViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(true, getString(R.string.certificates))
        setBottomNavigationVisibility(true)
        setHasOptionsMenu(true)
        onEvents()
    }


    private fun onEvents() {
        viewModel.selectCertificateEvent.observe(viewLifecycleOwner, EventObserve {
            findNavController().navigate(
                CertificatesFragmentDirections.actionCertificatesFragmentToCertificateStatusFragment(
                    it
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

}