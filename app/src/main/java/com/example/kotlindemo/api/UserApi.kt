package com.example.kotlindemo.api
//用object修饰的类为静态类
object UserApi{
    const val BASE_API="http://172.17.8.100/small/"
   //登录
    const val LOGIN_API="user/v1/login"
    //注册http://172.17.8.100/small/user/v1/register
    const val RESIGN_API="user/v1/register"
   // 展示 http://172.17.8.100/small/circle/v1/findCircleList
    const val SHOW_API="circle/v1/findCircleList";
}