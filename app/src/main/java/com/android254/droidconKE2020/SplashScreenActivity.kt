package com.android254.droidconKE2020

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        startAnimation()
    }

    private fun startAnimation() {
        AndroidAnimation().apply {
            delay = 1000
            targetViews(imageViewLogo)
            scaleX(MAX_SCALE)
            scaleY(MAX_SCALE)
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
            translateY(-MAX_TRANSLATION_Y, delay = 5400)
            scaleX(MIN_SCALE)
            scaleY(MIN_SCALE)
            rotate(MAX_ROTATION)
            targetChildViews(linearLayout, stagger = 100, reverse = true)
            scaleX((MIN_SCALE + .2f), 1f, MAX_SCALE, 1f)
            scaleY((MIN_SCALE + .2f), 1f, MAX_SCALE, 1f)
            alpha(1f)
            onAnimationEnd {
                startActivity(Intent(this@SplashScreenActivity, HomeActivity::class.java))
                finish()
            }
            start()
        }
    }
}
