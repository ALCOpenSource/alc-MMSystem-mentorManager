package com.peculiaruc.alc_mmsystem_mentormanager.ui.authentication.register

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.ActivityRegisterBinding

/**
 * This activity holds registration forms
 * fragment one, two, three, four
 */
class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val destination = intent.getStringExtra("START_DESTINATION")
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_register_form) as NavHostFragment
        val navController = navHostFragment.navController

        val navGraph = navController.navInflater.inflate(R.navigation.nav_graph_register)
        val startDestination = if (destination.equals("FORGET_PASSWORD")) {
            R.id.forgetPasswordFragment
        } else {
            R.id.registerJoinTeamFragment
        }
        navGraph.setStartDestination(startDestination)
        navController.graph = navGraph
    }
}