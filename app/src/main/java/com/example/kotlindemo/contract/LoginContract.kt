package com.example.kotlindemo.contract

import com.example.kotlindemo.bean.LoginBean
import com.example.kotlindemo.bean.ResignBean
import com.example.kotlindemo.bean.ShowBean
import com.example.kotlindemo.net.RequestCallback

/*
*
* 契约类统一管理
* */
interface LoginContract {
    interface IPresenter{
        fun login(api:String,params:HashMap<String,String>)
        fun resign(api:String,params:HashMap<String,String>)
        fun show(api:String,params: HashMap<String, String>,params1: HashMap<String, String>)
    }
    interface IModel{
       fun login(api:String,params: HashMap<String, String>,requestCallback: RequestCallback<LoginBean>)
       fun resign(api:String,params: HashMap<String, String>,requestCallback: RequestCallback<ResignBean>)
       fun show(api:String,params: HashMap<String, String>,params1: HashMap<String, String>,requestCallback: RequestCallback<ShowBean>)
    }
    interface IView{
        fun success(loginBean: LoginBean)
        fun resignsuccess(resignBean: ResignBean)
        fun showsuccess(showBean: ShowBean)
        fun failure(string:String);
    }
}