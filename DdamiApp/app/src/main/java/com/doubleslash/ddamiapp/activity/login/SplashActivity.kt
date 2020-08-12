package com.doubleslash.ddamiapp.activity.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.doubleslash.ddamiapp.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val intent = Intent(this,LoginActivity::class.java)
        val handler = Handler()
        handler.postDelayed({
            startActivity(intent)
            finish()
        },2500)
    }
}