package com.aamnapm.openweather.ui.activity.splash

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.aamnapm.openweather.R
import com.aamnapm.openweather.databinding.ActivitySplashBinding
import com.aamnapm.openweather.ui.activity.main.MainActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var activity: Activity
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)

        activity = this

        binding.title = getString(R.string.welcome)

        Handler().postDelayed(Runnable {
            intent= Intent(activity, MainActivity::class.java)
            startActivity(intent)
            finish()
        },2000)
    }
}
