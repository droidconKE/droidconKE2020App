package com.android254.droidconKE2020

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.content_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setUpBottomNavigation()

        setSupportActionBar(findViewById(R.id.mainToolbar))

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_dark_theme -> {
                toggleDarkTheme()
                true
            }
            R.id.action_sign_in -> {
                signIn()
                true
            }
            R.id.action_settings -> true
            R.id.action_feedback -> {
                feedback()
                true
            }
            else -> super.onOptionsItemSelected(item)
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
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.aboutFragment, R.id.homeFragment, R.id.feedFragment, R.id.sessionsFragment -> bottomNavigation.visibility =
                    View.VISIBLE
                else -> bottomNavigation.visibility = View.GONE

            }
        }
    }

    private fun feedback() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.findNavController()
        navController.navigate(R.id.feedBackFragment)
    }

    private fun signIn() {
        findNavController(R.id.nav_host_fragment).navigate(R.id.authDialog)
    }

    private fun toggleDarkTheme() {
        val newTheme = when (AppCompatDelegate.getDefaultNightMode()) {
            AppCompatDelegate.MODE_NIGHT_YES -> AppCompatDelegate.MODE_NIGHT_NO
            else -> AppCompatDelegate.MODE_NIGHT_YES
        }
        AppCompatDelegate.setDefaultNightMode(newTheme)
    }
}
