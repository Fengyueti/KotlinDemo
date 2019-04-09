package com.example.kotlindemo.app

import android.app.Application
import com.example.kotlindemo.api.UserApi
import com.example.kotlindemo.net.NetRequestUtils

class MyApp :Application(){
    override fun onCreate() {
        super.onCreate()
        //初始化
        NetRequestUtils.instance.init(UserApi.BASE_API)
    }
}