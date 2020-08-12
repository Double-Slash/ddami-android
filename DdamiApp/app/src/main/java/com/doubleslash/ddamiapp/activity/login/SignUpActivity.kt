package com.doubleslash.ddamiapp.activity.login

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.doubleslash.ddamiapp.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.Observables
import io.reactivex.subjects.BehaviorSubject
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    private var flag = false

    private val mAllDisposable = CompositeDisposable()

    private val mIdSubject = BehaviorSubject.createDefault(false)
    private val mPwSubject = BehaviorSubject.createDefault(false)
    private val mCheckSubject = BehaviorSubject.createDefault(false)

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        initViews()
        initRx()
    }

    @SuppressLint("ResourceAsColor")
    private fun initViews() {
        supportActionBar?.title = "회원가입"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        et_id.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                mIdSubject.onNext(!p0.isNullOrBlank())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })

        et_pw_check.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                mPwSubject.onNext(et_name.text.toString() == p0?.toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })

        btn_check_id.setOnClickListener{
            tv_check_msg.text = "사용 가능한 아이디 입니다."
            mCheckSubject.onNext(true)
            btn_check_id.setBackgroundColor(R.color.colorCheckOk)

        }

        btn_next.setOnClickListener {
            val intent = Intent(this, SignUpSecondActivity::class.java)
            intent.putExtra("id", et_id.text.toString())
            intent.putExtra("pw", et_name.text.toString())
            startActivity(intent)
        }
    }

    @SuppressLint("CheckResult")
    private fun initRx() {
        mAllDisposable.add(Observables.combineLatest(mIdSubject, mPwSubject, mCheckSubject)
                .map { it.first && it.second && it.third }
                .distinctUntilChanged()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    btn_next.isEnabled = it
                }, {}))
    }

    fun idCheck(id: String) {
        flag = true
    }

    override fun onDestroy() {
        super.onDestroy()
        mAllDisposable.dispose()
    }

    override fun onBackPressed() {
        finish()
    }
}