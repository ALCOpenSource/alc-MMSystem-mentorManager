package com.peculiaruc.alc_mmsystem_mentormanager.ui.onboarding

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.ActivitySplashScreenBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.MainActivity

/**
 * This activity is used for splash screen
 */
@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding
    private val timeDelay: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, timeDelay)
    }
}