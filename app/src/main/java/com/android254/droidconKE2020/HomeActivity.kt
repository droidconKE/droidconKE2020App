package com.android254.droidconKE2020

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.android254.droidconKE2020.toolbar.CountdownFragment
import com.android254.droidconKE2020.toolbar.FeedbackFragment
import com.android254.droidconKE2020.toolbar.TitleFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    // ToDo: Move this to viewmodel
    private val isAuthenticated = MutableLiveData<Boolean>()

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
                if (isAuthenticated.value == true) {
                    isAuthenticated.value = false
                    item.icon = ContextCompat.getDrawable(baseContext, R.drawable.ic_login)
                } else {
                    isAuthenticated.value = true
                    item.icon = ContextCompat.getDrawable(baseContext, R.drawable.ic_profile_pic)
                }

                true
            }
//            R.id.action_settings -> true
//            R.id.action_feedback -> {
//                feedback()
//                true
//            }
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
                R.id.aboutFragment, R.id.homeFragment, R.id.feedFragment, R.id.sessionsFragment -> {
                    bottomNavigation.visibility = View.VISIBLE
                    showToolbarContent(isAuthenticated.value ?: false, destination.id)
                }
                else -> bottomNavigation.visibility = View.GONE
            }
        }
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

    private fun showToolbarContent(isAuthenticated: Boolean, destinationId: Int) {

        val content = when (destinationId) {
            R.id.homeFragment -> if (isAuthenticated) FeedbackFragment() else CountdownFragment()
            R.id.feedFragment -> TitleFragment().also {
                val args = Bundle()
                args.putString("title", getString(R.string.feed))
                it.arguments = args
            }
            R.id.sessionsFragment -> TitleFragment().also {
                val args = Bundle()
                args.putString("title", getString(R.string.sessions))
                it.arguments = args
            }
            R.id.aboutFragment -> TitleFragment().also {
                val args = Bundle()
                args.putString("title", getString(R.string.about))
                it.arguments = args
            }
            else -> null
        }

        content?.let {
            val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
            if (supportFragmentManager.fragments.size > 0)
                ft.replace(toolbarContent.id, content).commit()
            else ft.add(toolbarContent.id, content).commit()
        }
    }
}
