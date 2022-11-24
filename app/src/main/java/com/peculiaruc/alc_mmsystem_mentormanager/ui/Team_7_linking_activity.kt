package com.peculiaruc.alc_mmsystem_mentormanager.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.ActivityMentorListBinding
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.ActivityTeam7LinkingBinding

class Team_7_linking_activity : AppCompatActivity() {
    //    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityTeam7LinkingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeam7LinkingBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.frame351.setOnClickListener {
            startActivity(Intent(this,Mentor_list_Activity::class.java))
        }

        binding.ChatBroadcast.setOnClickListener {
            startActivity(Intent(this,chat_messages_activity::class.java))
        }

        binding.Reports.setOnClickListener {
            startActivity(Intent(this,activity_mm_reports::class.java))
        }
        binding.discussionForum.setOnClickListener {
            startActivity(Intent(this,Discussion_forum::class.java))
        }


    }
}