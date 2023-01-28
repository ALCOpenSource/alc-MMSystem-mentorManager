package com.peculiaruc.alc_mmsystem_mentormanager.ui.authentication.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.ActivityLoginBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.authentication.ForgotPasswordActivity
import com.peculiaruc.alc_mmsystem_mentormanager.ui.authentication.SignUpActivity
import com.peculiaruc.alc_mmsystem_mentormanager.ui.home.HomeActivity

/**
 * This activity is for the user to Login
 */
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        binding.buttonLogin.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.textViewSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.textViewForgotPassword.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}