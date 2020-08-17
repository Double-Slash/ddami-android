package com.doubleslash.ddamiapp.activity.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.doubleslash.ddamiapp.R
import com.doubleslash.ddamiapp.activity.MainActivity
import com.doubleslash.ddamiapp.activity.verification.VerificationActivity
import com.doubleslash.ddamiapp.activity.verification.VerifiedActivity
import kotlinx.android.synthetic.main.activity_complete.*

class SignUpCompleteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complete)

        initViews()
    }

    private fun initViews() {
        btn_main.setOnClickListener{
            val mainIntent = Intent(this,LoginActivity::class.java)
            startActivity(mainIntent)
            finish()
        }

        btn_cert.setOnClickListener{
            var verifyIntent = Intent(this,VerificationActivity::class.java)
            startActivity(verifyIntent)
            finish()
        }
    }

}