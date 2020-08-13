package com.doubleslash.ddamiapp.network.kotlin

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
    private const val BASE_URL = "http://222.251.129.150/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    val loginService : LoginApi by lazy {
        retrofit.create(LoginApi::class.java)
    }

    val myroomUser : MyroomUserApi by lazy {
        retrofit.create(MyroomUserApi::class.java)
    }

    val verifyUser : VerifyApi by lazy {
        retrofit.create(VerifyApi::class.java)
    }
    val detailPieceService : DetailPieceApi by lazy {
        retrofit.create(DetailPieceApi::class.java)
    }

    val userDetailService : UserApi by lazy {
        retrofit.create(UserApi::class.java)
    }

    val signUpService : SignUpApi by lazy {
        retrofit.create(SignUpApi::class.java)
    }

    val homeService : HomeApi by lazy {
        retrofit.create(HomeApi::class.java)
    }

    val myInfo : MyInfoApi by lazy {
        retrofit.create(MyInfoApi::class.java)
    }
}