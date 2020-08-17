package com.doubleslash.ddamiapp.network.kotlin

import com.doubleslash.ddamiapp.model.FollowDAO
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

    val followService : FollowApi by lazy {
        retrofit.create(FollowApi::class.java)
    }
    val ShopWorkService : ShopWorkApi by lazy {
        retrofit.create(ShopWorkApi::class.java)
    }

    val ShopMaterialService : ShopMaterialApi by lazy {
        retrofit.create(ShopMaterialApi::class.java)
    }

    val ShopFeedService : ShopFeedApi by lazy {
        retrofit.create(ShopFeedApi::class.java)
    }

    val ShopMaterialUploadService : ShopMaterialUploadApi by lazy {
        retrofit.create(ShopMaterialUploadApi::class.java)
    }

    val ShopWorkDetailService : ShopWorkDetailApi by lazy {
        retrofit.create(ShopWorkDetailApi::class.java)
    }

    val shopUser : ShopUserApi by lazy {
        retrofit.create(ShopUserApi::class.java)
    }

    val userRoomService : UserRoomApi by lazy {
        retrofit.create(UserRoomApi::class.java)
    }
}