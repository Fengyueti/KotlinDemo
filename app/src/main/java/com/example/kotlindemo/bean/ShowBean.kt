package com.example.kotlindemo.bean

data class ShowBean(
    val message: String,
    val result: List<Result>,
    val status: String
) {
    data class Result(
        val commodityId: Int,
        val content: String,
        val createTime: Long,
        val greatNum: Int,
        val headPic: String,
        val id: Int,
        val image: String,
        val nickName: String,
        val userId: Int,
        val whetherGreat: Int
    )
}