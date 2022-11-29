package com.peculiaruc.alc_mmsystem_mentormanager.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.ActivityChatMessagesBinding
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.ActivityDiscussionForumBinding
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.ActivityMmReportsBinding

class Discussion_forum : AppCompatActivity() {

    private lateinit var binding: ActivityDiscussionForumBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDiscussionForumBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}