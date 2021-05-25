package com.vahitkeskin.kotlinfootballapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatDelegate
import com.vahitkeskin.kotlinfootballapp.databinding.ActivitySplashScreenBinding
import com.vahitkeskin.kotlinfootballapp.util.CustomSharedPreferences

@Suppress("DEPRECATION")
class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding
    private var customSharedPreferences = CustomSharedPreferences()
    private var updateThemeMode: Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION

        CustomSharedPreferences(applicationContext)
        updateThemeMode = customSharedPreferences.getThemeMode()


        if (updateThemeMode != null) {
            if (updateThemeMode!!) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        object : CountDownTimer(2500, 1000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                val intent = Intent(this@SplashScreenActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.start()
    }
}