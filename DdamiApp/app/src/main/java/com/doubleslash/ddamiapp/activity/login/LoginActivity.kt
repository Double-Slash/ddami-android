package com.doubleslash.ddamiapp.activity.login

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.doubleslash.ddamiapp.R
import com.doubleslash.ddamiapp.activity.MainActivity
import com.doubleslash.ddamiapp.network.kotlin.ApiService
import com.doubleslash.ddamiapp.util.KeyboardVisibilityUtils
import com.google.gson.JsonObject
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var keyboardVisibilityUtils: KeyboardVisibilityUtils
    private var backTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        keyboardVisibilityUtils = KeyboardVisibilityUtils(window,
                onShowKeyboard = { keyboardHeight ->
                    sv_login.run {
                        smoothScrollTo(scrollX, scrollY + keyboardHeight)
                    }
                })

        btn_sign_up.setOnClickListener {
            val id = et_id.text.toString()
            val pw = et_name.text.toString()
            val inputJson = JsonObject()

            inputJson.addProperty("userId", id)
            inputJson.addProperty("userPassword", pw)

            login(inputJson)
        }

        tv_signUp.setOnClickListener {
            val signUpIntent = Intent(this@LoginActivity, SignUpActivity::class.java)
            startActivity(signUpIntent)
        }
    }

    @SuppressLint("CheckResult")
    fun login(input: JsonObject) {
        ApiService.loginService.login(input)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Toast.makeText(applicationContext, "로그인 성공", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    intent.putExtra("token", it.token)
                    intent.putExtra("id", input.get("userId").toString())
                    startActivity(intent)
                    finish()
                }, {
                    Toast.makeText(applicationContext, "$it", Toast.LENGTH_SHORT).show()
                    Log.e("영환", it.toString())
                })
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 0) {
            if (System.currentTimeMillis() - backTime < 2000) {
                finish()
            }
            Toast.makeText(this, "종료하시려면 다시한번 눌러주세요.", Toast.LENGTH_SHORT).show()
            backTime = System.currentTimeMillis()
        } else {
            supportFragmentManager.popBackStack()
        }
    }

}
