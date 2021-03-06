package com.example.kotlindemo.api

import com.example.kotlindemo.bean.LoginBean
import io.reactivex.Observable
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Url


interface UserApiService {
    /*
    * 登录
    * */
    @POST
    @FormUrlEncoded
    fun userLogin(@Url url:String,@FieldMap params: HashMap<String,String>):Observable<LoginBean>

}

