package com.android254.droidconKE2020

import android.os.Bundle
import android.view.View
import android.view.View.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.updatePadding
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.android254.droidconKE2020.core.Preferences
import com.android254.droidconKE2020.databinding.ActivityHomeBinding
import org.koin.android.ext.android.inject

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    val sharedPrefs: Preferences by inject()

    lateinit var toolbar: DynamicToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.root.systemUiVisibility = SYSTEM_UI_FLAG_LAYOUT_STABLE or
                SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN


        setUpAppbar()
        setUpBottomNavigation()
        binding.toolbar.authHandler = {
            signIn()
        }
        binding.toolbar.feedbackHandler = {
            feedback()
        }
        binding.toolbar.nightModeHandler = {
            toggleDarkTheme()
        }
    }

    private fun setUpAppbar() {
        setSupportActionBar(binding.toolbar)
        binding.activityHomeAppbar.setOnApplyWindowInsetsListener { v, insets ->
            v.updatePadding(top = insets.systemWindowInsetTop)
            insets
        }
    }

    // Set up bottom navigation
    private fun setUpBottomNavigation() {
        binding.bottomNavigation.setOnApplyWindowInsetsListener { v, insets ->
            v.updatePadding(bottom = insets.systemWindowInsetBottom)
            insets
        }

        // Retrieve fragment container view as nav host fragment
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.findNavController()
        // Setup bottom navigation view with nav controller for dynamic navigation
        binding.bottomNavigation.setupWithNavController(navController = navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.toolbar.onDestinationChanged(destination.id, destination.label as String)
            when (destination.id) {
                R.id.aboutFragment, R.id.homeFragment, R.id.feedFragment, R.id.sessionsFragment -> {
                    binding.bottomNavigation.visibility = View.VISIBLE
                }
                else -> binding.bottomNavigation.visibility = View.GONE
            }
        }
    }

    private fun signIn() {
        findNavController(R.id.nav_host_fragment).navigate(R.id.authDialog)
    }

    private fun feedback() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.findNavController()
        navController.navigate(R.id.feedBackFragment)
    }

    private fun toggleDarkTheme() {
        val newTheme = when (AppCompatDelegate.getDefaultNightMode()) {
            AppCompatDelegate.MODE_NIGHT_YES -> AppCompatDelegate.MODE_NIGHT_NO
            else -> AppCompatDelegate.MODE_NIGHT_YES
        }

        sharedPrefs.setUserTheme(newTheme)
        (application as DroidConKeApp).setSavedTheme()
    }
}