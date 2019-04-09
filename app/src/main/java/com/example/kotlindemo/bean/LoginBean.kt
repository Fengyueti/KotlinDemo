package com.example.kotlindemo.bean
data class LoginBean(
    val message: String,
    val result: Result,
    val status: String
)

data class Result(
    val headPic: String,
    val nickName: String,
    val phone: String,
    val sessionId: String,
    val sex: String,
    val userId: String
)