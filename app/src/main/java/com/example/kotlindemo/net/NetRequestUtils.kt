package com.example.kotlindemo.net

import com.example.kotlindemo.BuildConfig
import com.example.kotlindemo.api.UserApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetRequestUtils private constructor(){
    lateinit var retrofit:Retrofit
    //单列模式
   companion object {
        val instance :NetRequestUtils by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED){
            NetRequestUtils()
        }
    }
    fun init(basE_API: String) {
        val okHttpClient =
                OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(
                   if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                   else HttpLoggingInterceptor.Level.NONE))
                        .connectTimeout(5,TimeUnit.SECONDS)
                        .readTimeout(5,TimeUnit.SECONDS)
                        .writeTimeout(5,TimeUnit.SECONDS)
                        .build()
        retrofit=Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(UserApi.BASE_API)
                .client(okHttpClient)
                .build()
    }
    /**
     *
     * 动态代理模式，创建请求接口类
     */
    fun<T> createService(tclass :Class<T>):T{
        return retrofit.create(tclass)
    }
}

