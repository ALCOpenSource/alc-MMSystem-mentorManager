package com.peculiaruc.alc_mmsystem_mentormanager.ui



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.peculiaruc.alc_mmsystem_mentormanager.databinding.ActivityMmReportsBinding

/**
 * The activity is the home frangment container for all the mm reports screen
 * no functionlaity implemented yet
 */

class activity_mm_reports : AppCompatActivity() {
    private lateinit var binding:ActivityMmReportsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMmReportsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }
}