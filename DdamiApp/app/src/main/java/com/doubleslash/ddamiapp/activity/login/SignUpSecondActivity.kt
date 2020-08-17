package com.doubleslash.ddamiapp.activity.login

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.doubleslash.ddamiapp.R
import com.doubleslash.ddamiapp.network.kotlin.ApiService
import com.google.gson.JsonObject
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.Observables
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import kotlinx.android.synthetic.main.activity_sign_up_second.*

class SignUpSecondActivity : AppCompatActivity() {

    private var id = ""
    private var pw = ""
    private var sex = ""
    private var birth = ""
    private var isSignUp = false

    private val mNameSubject = BehaviorSubject.createDefault(false)
    private val mSexSubject = BehaviorSubject.createDefault(false)
    private val mAllDisposable = CompositeDisposable()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_second)

        initViews()
        initRx()

    }

    private fun initViews() {
        supportActionBar?.title = "회원가입"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        id = intent.getStringExtra("id") ?: ""
        pw = intent.getStringExtra("pw") ?: ""


        et_name.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                mNameSubject.onNext(et_name.text.toString() == p0?.toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })

        radio.setOnCheckedChangeListener { p0, p1 ->
            if (p1 == R.id.female) {
                sex = "female"
                mSexSubject.onNext(true)
            } else if (p1 == R.id.male) {
                sex = "male"
                mSexSubject.onNext(true)
            }
        }

        btn_sign_up_ok.setOnClickListener {
            birth = "${datePicker.year}-${datePicker.month + 1}-${datePicker.dayOfMonth}"
            val userInfo = JsonObject()

            userInfo.run {
                addProperty("userName", et_name.text.toString())
                addProperty("userId", id)
                addProperty("userPassword", pw)
                addProperty("userSex", sex)
                addProperty("userBirth", birth)
                addProperty("userPhone", "")
                addProperty("likeField", "")
            }

            signUp(userInfo)
        }
    }

    private fun initRx() {
        mAllDisposable.add(Observables.combineLatest(mNameSubject, mSexSubject)
                .map { it.first && it.second }
                .distinctUntilChanged()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    btn_sign_up_ok.isEnabled = it
                }, {}))
    }

    @SuppressLint("CheckResult")
    private fun signUp(userInfo: JsonObject) {
        ApiService.signUpService.signUp(userInfo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.e("shin_success", it.message)
                    if (it.result == 1) {
                        startActivity(Intent(this, SignUpCompleteActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(this@SignUpSecondActivity, it.message, Toast.LENGTH_SHORT).show()
                    }
                }, { Log.e("shin_fail", it.toString()) })
    }
}