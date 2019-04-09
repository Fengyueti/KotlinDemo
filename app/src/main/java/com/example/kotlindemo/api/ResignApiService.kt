package com.example.kotlindemo.api

import com.example.kotlindemo.bean.LoginBean
import com.example.kotlindemo.bean.ResignBean
import io.reactivex.Observable
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Url

interface ResignApiService {
    /*
   * 注册
   * */
    @POST
    @FormUrlEncoded
    fun userResign(@Url url:String, @FieldMap params: HashMap<String,String>): Observable<ResignBean>
}