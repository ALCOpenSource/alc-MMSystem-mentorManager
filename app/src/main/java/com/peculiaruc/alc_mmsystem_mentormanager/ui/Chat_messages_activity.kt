package com.peculiaruc.alc_mmsystem_mentormanager.ui

/**
 * The activity is the home frangment contrainer for all the mm chat messages task screen
 *
 */

import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.ActivityChatMessagesBinding



class chat_messages_activity : AppCompatActivity() {

    private lateinit var binding: ActivityChatMessagesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatMessagesBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}