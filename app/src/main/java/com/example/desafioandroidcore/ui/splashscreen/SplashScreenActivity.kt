package com.example.desafioandroidcore.ui.splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.desafioandroidcore.R
import com.example.desafioandroidcore.ui.ui.MainActivity

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val maxSplashTime = 3000L

        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, maxSplashTime)

    }
}