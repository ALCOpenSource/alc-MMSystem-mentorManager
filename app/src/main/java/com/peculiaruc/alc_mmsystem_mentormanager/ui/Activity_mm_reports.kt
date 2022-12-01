package com.peculiaruc.alc_mmsystem_mentormanager.ui

/**
 * The activity is the home frangment contrainer for all the mm reports screen
 *
 */

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.ActivityMainBinding
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.ActivityMmReportsBinding


class activity_mm_reports : AppCompatActivity() {
    private lateinit var binding:ActivityMmReportsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMmReportsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }
}