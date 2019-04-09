package com.example.kotlindemo.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.kotlindemo.R
import com.example.kotlindemo.bean.LoginBean
import com.example.kotlindemo.bean.ShowBean

class ProducterAdapter(val context: Context):RecyclerView.Adapter<ProducterAdapter.VH>(){
    var list:List<ShowBean.Result> ?=null
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ProducterAdapter.VH {
        var view=LayoutInflater.from(context).inflate(R.layout.itemshowpage,p0,false)
        return VH(view)
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun onBindViewHolder(p0: ProducterAdapter.VH, p1: Int) {
        p0.qzname.text=list!!.get(p1).nickName
        Glide.with(context).load(list!!.get(p1).image).into(p0.qzimg)
    }
    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var qzimg:ImageView =itemView.findViewById(R.id.qzimg)
        var qzname:TextView=itemView.findViewById(R.id.qzname)
    }
}


