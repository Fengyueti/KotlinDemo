package com.example.kotlindemo.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.example.kotlindemo.R
import kotlinx.android.synthetic.main.activity_main.*

class KotlinActivity : AppCompatActivity(),View.OnClickListener {
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.bt_click ->
                Toast.makeText(this,"点击了",Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bt_click.setOnClickListener(this);
        tv_textview.text="Hello Word"
    }
}