package com.example.kotlindemo.api

import com.example.kotlindemo.bean.LoginBean
import com.example.kotlindemo.bean.ShowBean
import io.reactivex.Observable
import retrofit2.http.*


interface ShowApiService {
    /*
    * 登录
    * */
    @GET
    fun showpage(@Url url:String,@HeaderMap params:HashMap<String,String>,@QueryMap params1: HashMap<String,String>):Observable<ShowBean>

}

