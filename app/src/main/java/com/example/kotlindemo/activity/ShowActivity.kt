package com.example.kotlindemo.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import android.widget.Toast
import com.example.kotlindemo.R
import com.example.kotlindemo.adapter.ProducterAdapter
import com.example.kotlindemo.api.UserApi
import com.example.kotlindemo.bean.LoginBean
import com.example.kotlindemo.bean.ResignBean
import com.example.kotlindemo.bean.ShowBean
import com.example.kotlindemo.contract.LoginContract
import com.example.kotlindemo.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_show.*

class ShowActivity : AppCompatActivity(),LoginContract.IView{
    lateinit var loginPresenter: LoginPresenter
    var page: Int = 1
    var count:Int = 10
    override fun failure(string: String) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
    }

    override fun showsuccess(showBean: ShowBean) {
      Toast.makeText(this,showBean.message,Toast.LENGTH_SHORT).show()
    }

    override fun resignsuccess(resignBean: ResignBean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun success(loginBean: LoginBean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)
        /* xrecyclerView!!.layoutManger=linearLayoutManger(this)
       xrecyclerView!!.setloadingListener(this)
       xrecyclerView!!.setloadingMoreEnabled(true)
       var produceteradapter=productadapter(this)
       xrecyclerview!!.adapter=producteradapter
       */
        initView()
        initData()
    }

    private fun initData() {
        loginPresenter = LoginPresenter()
        var params = HashMap<String, String>()
        var params1 = HashMap<String, String>()
        params1.put("count",count.toString())
        params1.put("page", page.toString())
        params.put("userId", "603")
        params.put("sessionId", "1554817935786603")
        loginPresenter.attach(this)
        //loginPresenter.login(UserApi.SHOW_API,params,params1)
    }

    private fun initView() {
        rv!!.layoutManager=LinearLayoutManager(this)
        var produceteradapter=ProducterAdapter(this)
        rv!!.adapter=produceteradapter
    }
    override fun onDestroy() {
        super.onDestroy()
        loginPresenter.detach()
    }
}
