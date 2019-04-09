package com.example.kotlindemo.model

import com.example.kotlindemo.api.ResignApiService
import com.example.kotlindemo.api.ShowApiService
import com.example.kotlindemo.api.UserApi
import com.example.kotlindemo.api.UserApiService
import com.example.kotlindemo.bean.LoginBean
import com.example.kotlindemo.bean.ResignBean
import com.example.kotlindemo.bean.ShowBean
import com.example.kotlindemo.contract.LoginContract
import com.example.kotlindemo.net.NetRequestUtils
import com.example.kotlindemo.net.NetScheduler
import com.example.kotlindemo.net.RequestCallback
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

/*
* 数据模型层
* */
class LoginModel:LoginContract.IModel{
    override fun show(api: String, params: HashMap<String, String>, params1: HashMap<String, String>, requestCallback: RequestCallback<ShowBean>) {
        NetRequestUtils.instance.createService(ShowApiService::class.java).showpage(UserApi.SHOW_API,params,params1)
                .compose(NetScheduler.compose())
                .subscribe(object :Consumer<ShowBean>{
                    override fun accept(t: ShowBean?) {
                      requestCallback!!.success(t!!)
                    }
                },object :Consumer<Throwable>{
                    override fun accept(t: Throwable?) {
                        requestCallback!!.failure(t!!.message!!)
                    }

                })
    }

    /*
    * 注册
    * */
    override fun resign(api: String, params: HashMap<String, String>, requestCallback: RequestCallback<ResignBean>) {
        NetRequestUtils.instance.createService(ResignApiService::class.java).userResign(UserApi.RESIGN_API,params)
                .compose(NetScheduler.compose())
                .subscribe(object :Consumer<ResignBean>{
                    override fun accept(t: ResignBean?) {
                        requestCallback!!.success(t!!)
                    }
                },object :Consumer<Throwable>{
                    override fun accept(t: Throwable?) {
                        requestCallback!!.failure(t!!.message!!)
                    }

                })
    }
/*
* 登录
* */
    override fun login(api: String, params: HashMap<String, String>, requestCallback: RequestCallback<LoginBean>) {

        NetRequestUtils.instance.createService(UserApiService::class.java).userLogin(UserApi.LOGIN_API,params)
                .compose(NetScheduler.compose())
                .subscribe(object :Consumer<LoginBean>{
                    override fun accept(t: LoginBean?) {
                        requestCallback!!.success(t!!)
                    }

                },object :Consumer<Throwable>{
                    override fun accept(t: Throwable?) {
                        requestCallback!!.failure(t!!.message!!)
                    }

                })
    }

}