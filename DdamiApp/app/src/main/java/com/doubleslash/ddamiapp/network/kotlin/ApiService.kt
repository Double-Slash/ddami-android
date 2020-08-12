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

    val ShopWorkService : ShopWorkApi by lazy {
        retrofit.create(ShopWorkApi::class.java)
    }

}