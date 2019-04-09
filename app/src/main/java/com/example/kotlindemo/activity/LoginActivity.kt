package com.example.kotlindemo.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.kotlindemo.R
import com.example.kotlindemo.api.UserApi
import com.example.kotlindemo.bean.LoginBean
import com.example.kotlindemo.bean.ResignBean
import com.example.kotlindemo.bean.ShowBean
import com.example.kotlindemo.contract.LoginContract
import com.example.kotlindemo.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(),View.OnClickListener,LoginContract.IView {
    override fun showsuccess(showBean: ShowBean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //注册
    override fun resignsuccess(resignBean: ResignBean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    lateinit var loginPresenter: LoginPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initView()
        initData()
    }

    private fun initData() {
        loginPresenter = LoginPresenter()

    }

    private fun initView() {
        resign.setOnClickListener(this)
        btn.setOnClickListener(this)
    }
    override fun failure(string: String) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
    }

    override fun success(loginBean: LoginBean) {
        Toast.makeText(this, loginBean.message, Toast.LENGTH_SHORT).show()
        if(loginBean.status=="0000"){
            val intent1=Intent()
            //获取intent对象
            intent1.setClass(this,ShowActivity::class.java)
            //获取class是使用::反射
            startActivity(intent1)
        }
    }
    /*
    * 点击事件
    * */
    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.resign ->resignjump()
            R.id.btn ->login()
        }
    }
    //登录
    private fun login() {
        Toast.makeText(this, "123", Toast.LENGTH_SHORT).show()
        var params = HashMap<String, String>()
        params.put("phone", "15100058141")
        params.put("pwd", "123223")
        loginPresenter.attach(this)
        loginPresenter.login(UserApi.LOGIN_API,params)
    }

    //跳转到注册页面
    fun resignjump(){
        val intent=Intent()
        //获取intent对象
        intent.setClass(this,ResignActivity::class.java)
        //获取class是使用::反射
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        loginPresenter.detach()
    }
}
