package com.doubleslash.ddamiapp.network.kotlin

import com.doubleslash.ddamiapp.network.kotlin.java.UploadPieceApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
object ApiService {
    private const val BASE_URL = "http://222.251.129.150/"

    private val retrofit: Retrofit by lazy {
        val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(2, TimeUnit.MINUTES)
                .readTimeout(100, TimeUnit.SECONDS)
                .writeTimeout(100, TimeUnit.SECONDS)
                .build()
        val clientBuilder = OkHttpClient.Builder()
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        clientBuilder.addInterceptor(loggingInterceptor)
        Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(clientBuilder.build())
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
    val likeTrueFalse : LikeTFApi by lazy {
        retrofit.create(LikeTFApi::class.java)
    }
    val likeList : MyLikeListApi by lazy {
        retrofit.create(MyLikeListApi::class.java)
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

    val uploadPieceService : UploadPieceApi by lazy {
        retrofit.create(UploadPieceApi::class.java)
    }

}

