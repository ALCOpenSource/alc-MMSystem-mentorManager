package com.peculiaruc.alc_mmsystem_mentormanager.ui.authentication.register.notification

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.NotificationDto
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentRegisterNotificationBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.MainActivity
import com.peculiaruc.alc_mmsystem_mentormanager.ui.authentication.register.RegisterActivity
import com.peculiaruc.alc_mmsystem_mentormanager.ui.authentication.register.RegisterViewModel
import com.peculiaruc.alc_mmsystem_mentormanager.ui.base.BaseFragment
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.EventObserve


class RegisterNotificationFragment : BaseFragment<FragmentRegisterNotificationBinding>() {

    override val layoutIdFragment: Int = R.layout.fragment_register_notification
    override val viewModel: RegisterNotificationViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        observeEvents()
    }

    private fun initData() {
        val fakeNotification = listOf(
            NotificationDto(1, "MyResume.pdf"),
            NotificationDto(2, "my certificate.doc"),
        )
        binding.recyclerViewNotifications.adapter =
            RegisterNotificationAdapter(fakeNotification, viewModel)
    }

    private fun observeEvents() {
        viewModel.registerNotificationEvent.observe(viewLifecycleOwner, EventObserve {
            val intent = Intent(requireActivity(), MainActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        })
    }

}