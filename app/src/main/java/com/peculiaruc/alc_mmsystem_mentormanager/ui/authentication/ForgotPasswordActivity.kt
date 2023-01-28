package com.peculiaruc.alc_mmsystem_mentormanager.ui.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.ActivityForgotPasswordBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.activities.SetNewPasswordActivity

/**
 * This activity is for Resting password when
 * a user forget his password
 */
class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgotPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonDone.setOnClickListener {
            val intent = Intent(this, SetNewPasswordActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}