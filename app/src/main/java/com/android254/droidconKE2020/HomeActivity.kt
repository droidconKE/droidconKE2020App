package com.android254.droidconKE2020

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.android254.droidconKE2020.core.Preferences
import kotlinx.android.synthetic.main.content_home.*
import org.koin.android.ext.android.inject

class HomeActivity : AppCompatActivity() {
    val sharedPrefs: Preferences by inject()

    lateinit var toolbar: DynamicToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        setUpBottomNavigation()
        toolbar.authHandler = {
            signIn()
        }
        toolbar.feedbackHandler = {
            feedback()
        }
        toolbar.nightModeHandler = {
            Toast.makeText(applicationContext,"Night",Toast.LENGTH_SHORT).show()
            toggleDarkTheme()
        }
    }

    //Set up bottom navigation
    private fun setUpBottomNavigation() {
        //Retrieve fragment container view as nav host fragment
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.findNavController()
        //Setup bottom navigation view with nav controller for dynamic navigation
        bottomNavigation.setupWithNavController(navController = navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            toolbar.onDestinationChanged(destination.id, destination.label as String)
            when (destination.id) {
                R.id.aboutFragment, R.id.homeFragment, R.id.feedFragment, R.id.sessionsFragment -> {
                    bottomNavigation.visibility = View.VISIBLE
                }
                else -> bottomNavigation.visibility = View.GONE
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
