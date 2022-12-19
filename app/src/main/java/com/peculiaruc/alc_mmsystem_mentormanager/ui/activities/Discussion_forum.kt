package com.peculiaruc.alc_mmsystem_mentormanager.ui.activities



import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.ActivityDiscussionForumBinding

/**
 * The activity is the home frangment contrainer for all the mm discusiion forum
 * task screen
 *
 */

class Discussion_forum : AppCompatActivity() {

    private lateinit var binding: ActivityDiscussionForumBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDiscussionForumBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}