package com.example.kotlindemo.net

interface RequestCallback<T>{
    fun success(data:T)
    fun failure(string: String)
}