package com.android.fruitdetectorapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.android.fruitdetectorapp.databinding.ActivitySplashBinding

class Splash : AppCompatActivity() {
    private lateinit var binding : ActivitySplashBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)


        Handler().postDelayed({
            Intent(this, MainActivity::class.java).apply {
                startActivity(this)
                finish()
            }
        },4000L)

    }
}