package com.peculiaruc.alc_mmsystem_mentormanager.ui.activities



import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.ActivityChatMessagesBinding

/**
 * The activity is the home frangment contrainer for all the mm chat messages task screen
 * no functionality implemented yet
 */

class chat_messages_activity : AppCompatActivity() {

    private lateinit var binding: ActivityChatMessagesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatMessagesBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}