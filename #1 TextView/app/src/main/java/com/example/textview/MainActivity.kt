package com.example.textview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) { // 앱이 최초 실행됐을 때 수행
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // xml 화면 뷰를 연결

        // tv_title.setText("Hello World..!")
        // 안드로이드 버전 업그레이드로 인해 아이디 값을 가지고 바로 참조 불가 다음과 같은 형식으로 변경해야함
        val title : TextView = findViewById(R.id.tv_title)
        title.text = "Hello World..!"


    }
}