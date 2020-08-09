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
import com.google.gson.JsonObject
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener {
            val id = et_id.text.toString()
            val pw = et_pw.text.toString()
            val inputJson = JsonObject()

            inputJson.addProperty("userEmail", id)
            inputJson.addProperty("userPassword", pw)


            login(inputJson)
        }
    }

    @SuppressLint("CheckResult")
    fun login(input: JsonObject) {
        ApiService.loginService.login(input)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Toast.makeText(applicationContext, "로그인 성공", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@LoginActivity,MainActivity::class.java)
                    intent.putExtra("token",it.token)
                    intent.putExtra("id",input.get("userEmail").toString())
                    startActivity(intent)
                    finish()
                }, { Toast.makeText(applicationContext, "$it", Toast.LENGTH_SHORT).show()
                    Log.e("영환",it.toString())
                })
    }
}
