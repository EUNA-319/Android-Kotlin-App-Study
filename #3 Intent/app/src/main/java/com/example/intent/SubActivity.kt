package com.example.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        if(intent.hasExtra("msg")){
            val getMsg = findViewById<TextView>(R.id.tv_getMsg)
            getMsg.text = intent.getStringExtra("msg") // 서브 액티비티에 존재하는 텍스트뷰에 HelloWorld가 넘어옴

        }

    }

}