package com.example.kotlindemo.presenter

import com.example.kotlindemo.bean.LoginBean
import com.example.kotlindemo.bean.ResignBean
import com.example.kotlindemo.bean.ShowBean
import com.example.kotlindemo.contract.LoginContract
import com.example.kotlindemo.model.LoginModel
import com.example.kotlindemo.net.RequestCallback

class LoginPresenter:LoginContract.IPresenter{

    var loginModel: LoginModel? = null
    var loginview: LoginContract.IView? = null
    //绑定view的方法fun attach(),其实构造就是绑定
    /** 绑定view
     */
    fun attach(loginview:LoginContract.IView) {
        loginModel= LoginModel()
        this.loginview=loginview

    }
    /*constructor(loginview:LoginContract.IView){
        loginModel= LoginModel()
        this.loginview=loginview
    }*/
    //展示
    override fun show(api: String, params: HashMap<String, String>, params1: HashMap<String, String>) {
        loginModel!!.show(api,params,params1,object :RequestCallback<ShowBean>{
            override fun failure(string: String) {
                loginview!!.failure(string)
            }

            override fun success(data: ShowBean) {
                loginview!!.showsuccess(data)
            }

        })
    }
    //注册
    override fun resign(api: String, params: HashMap<String, String>) {
        loginModel!!.resign(api,params,object :RequestCallback<ResignBean>{
            override fun failure(string: String) {
              loginview!!.failure(string)
            }

            override fun success(data: ResignBean) {
              loginview!!.resignsuccess(data)
            }

        })
    }


    override fun login(api: String, params: HashMap<String, String>) {
        loginModel!!.login(api,params,object :RequestCallback<LoginBean>{
            override fun failure(string: String) {
                loginview!!.failure(string)
            }

            override fun success(data: LoginBean) {
                loginview!!.success(data)
            }

        })
    }
    //解绑
    fun detach(){
        if (loginview!=null){
            loginview=null
        }
    }
}