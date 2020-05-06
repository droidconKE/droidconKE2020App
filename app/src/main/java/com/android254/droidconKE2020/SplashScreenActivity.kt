package com.android254.droidconKE2020

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android254.droidconKE2020.core.PreferencesImpl
import com.example.android_animation.AndroidAnimation
import com.example.android_animation.enums.Easing
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity : AppCompatActivity() {

    private val maxScale = 1.5f
    private val minScale = .3f
    private val maxRotation = 360f
    private val minRotation = -45f
    private val maxTranslationX = 310f
    private val maxTranslationY = 170f

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
            scaleX(maxScale)
            scaleY(maxScale)
            duration = 1000
            thenPlay()
            easing = Easing.EXP_IN
            translateX(maxTranslationX)
            translateY(-maxTranslationY + 40f)
            scaleX(maxScale - 1f)
            scaleY(maxScale - 1f)
            rotate(minRotation)
            thenPlay()
            easing = Easing.CIRC_OUT
            translateX(-maxTranslationX)
            translateY(-maxTranslationY, delay = 3500)
            scaleX(minScale)
            scaleY(minScale)
            rotate(maxRotation)
            targetChildViews(linearLayout, stagger = 100, reverse = true)
            scaleX((minScale + .2f), 1f, maxScale, 1f)
            scaleY((minScale + .2f), 1f, maxScale, 1f)
            alpha(1f)
            onAnimationEnd {
                preferencesImpl.setShowSplashScreen(false)
                navigateToHome()
            }
            start()
        }
    }
}