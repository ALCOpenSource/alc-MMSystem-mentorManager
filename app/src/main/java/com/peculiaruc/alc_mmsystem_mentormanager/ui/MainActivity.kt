package com.peculiaruc.alc_mmsystem_mentormanager.ui

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.SettingsFragment


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initializing Fragments
//        navController = findNavController(R.id.nav_host_fragment_container)
        navController = findNavController(R.id.nav_view)
        val navBottomView: BottomNavigationView = findViewById(R.id.bottom_navigation_view)
        val drawerLayout: DrawerLayout = findViewById(R.id.mmDrawerLayout)
        val navView: NavigationView = findViewById(R.id.Nav_View)
        navBottomView.setupWithNavController(navController)
        val headerView: View = navView.getHeaderView(0).findViewById(R.id.drawerHeader)
        val imageIcon: ImageView = headerView.findViewById(R.id.setting_Account)
        imageIcon.setOnClickListener {
            val settingsFragment = SettingsFragment()
            val fragment: Fragment? =
                supportFragmentManager.findFragmentByTag(SettingsFragment::class.java.simpleName)
            if (fragment !is SettingsFragment) {
                supportFragmentManager.beginTransaction()
                    .add(
                        R.id.settingsLayout,
                        settingsFragment,
                        SettingsFragment::class.java.simpleName
                    )
                    .commit()
            }


            //Navigation Up button
            appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)

            // Drawer Layout
            NavigationUI.setupWithNavController(navView, navController)

        }

        //Navigation Up button
        appBarConfiguration = AppBarConfiguration(navController.graph,drawerLayout)

        // Drawer Layout
        NavigationUI.setupWithNavController(navView,navController)
    }
    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController,appBarConfiguration)
    }
}