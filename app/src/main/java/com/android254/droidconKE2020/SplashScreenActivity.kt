package com.android254.droidconKE2020

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android254.droidconKE2020.core.PreferencesImpl
import com.example.android_animation.AndroidAnimation
import com.example.android_animation.enums.Easing
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity : AppCompatActivity() {

    private val MAX_SCALE = 1.5f
    private val MIN_SCALE = .3f
    private val MAX_ROTATION = 360f
    private val MIN_ROTATION = -45f
    private val MAX_TRANSLATION_X = 310f
    private val MAX_TRANSLATION_Y = 170f

    private lateinit var preferencesImpl: PreferencesImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        preferencesImpl = PreferencesImpl(this)
        val showSplashScreen = preferencesImpl.getShowSplashScreen()
        if (showSplashScreen) startAnimation() else navigateToHome()
    }

    private fun navigateToHome() {
        startActivity(Intent(this@SplashScreenActivity, HomeActivity::class.java))
        finish()
    }

    private fun startAnimation() {
        AndroidAnimation().apply {
            delay = 300
            targetViews(imageViewLogo)
            scaleX(MAX_SCALE)
            scaleY(MAX_SCALE)
            duration = 1000
            thenPlay()
            easing = Easing.EXP_IN
            translateX(MAX_TRANSLATION_X)
            translateY(-MAX_TRANSLATION_Y + 40f)
            scaleX(MAX_SCALE - 1f)
            scaleY(MAX_SCALE - 1f)
            rotate(MIN_ROTATION)
            thenPlay()
            easing = Easing.CIRC_OUT
            translateX(-MAX_TRANSLATION_X)
            translateY(-MAX_TRANSLATION_Y, delay = 3500)
            scaleX(MIN_SCALE)
            scaleY(MIN_SCALE)
            rotate(MAX_ROTATION)
            targetChildViews(linearLayout, stagger = 100, reverse = true)
            scaleX((MIN_SCALE + .2f), 1f, MAX_SCALE, 1f)
            scaleY((MIN_SCALE + .2f), 1f, MAX_SCALE, 1f)
            alpha(1f)
            onAnimationEnd {
                preferencesImpl.setShowSplashScreen(false)
                navigateToHome()
            }
            start()
        }
    }
}
