package com.peculiaruc.alc_mmsystem_mentormanager.ui

import android.os.Bundle
import android.view.View

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
//import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.peculiaruc.alc_mmsystem_mentormanager.R
//import androidx.navigation.ui.navigateUp
//import androidx.navigation.ui.setupActionBarWithNavController
//import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.ActivityMentorListBinding


class Mentor_list_Activity : AppCompatActivity() {
//    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMentorListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMentorListBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


}