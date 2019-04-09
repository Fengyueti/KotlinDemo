package com.example.kotlindemo.activity

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
import kotlinx.android.synthetic.main.activity_resign.*

class ResignActivity : AppCompatActivity(), View.OnClickListener, LoginContract.IView{
    override fun showsuccess(showBean: ShowBean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun failure(string: String) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
    }
    /**
     * 注册成功
     */
    override fun resignsuccess(resignBean: ResignBean) {
        Toast.makeText(this, resignBean.message, Toast.LENGTH_SHORT).show()
    }
    /*
    * 登录成功
    * */
    override fun success(loginBean: LoginBean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btn_reg ->resign()

        }
    }
    lateinit var loginPresenter: LoginPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resign)
        initView();
        initData();
    }
    //注册
    private fun resign() {
        Toast.makeText(this, "123", Toast.LENGTH_SHORT).show()
        var params = HashMap<String, String>()
        params.put("phone", "18632415987")
        params.put("pwd", "123456")

        loginPresenter.attach(this)
        loginPresenter.resign(UserApi.RESIGN_API,params)
    }
    private fun initData() {
        loginPresenter = LoginPresenter()
    }

    private fun initView() {
        btn_reg.setOnClickListener(this)

    }
    override fun onDestroy() {
        super.onDestroy()
        loginPresenter.detach()
    }
}
