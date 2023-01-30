package com.peculiaruc.alc_mmsystem_mentormanager.ui.mentorManagerProfile.certificate

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentCertificateBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseFragment

/**
 * represent Certificate screen.
 * */
class CertificateFragment : BaseFragment<FragmentCertificateBinding>() {

    override val layoutIdFragment: Int = R.layout.fragment_certificate
    override val viewModel: CertificateViewModel by viewModels()
    private val args: CertificateFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(true, args.certificateTitle)
        setBottomNavigationVisibility(false)
        onEvents()
    }

    private fun onEvents() {
//        viewModel.downloadEvent.observe(viewLifecycleOwner, EventObserve {
//            findNavController().navigate(
//                CertificateFragmentDirections.actionCertificateFragmentToBasicDialog(
//                    DialogTypes.CERTIFICATE_DOWNLOAD
//                )
//            )
//        })
    }

}