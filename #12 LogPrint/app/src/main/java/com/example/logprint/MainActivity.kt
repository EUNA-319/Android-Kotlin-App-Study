package com.example.logprint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    var a : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        a = 2

        if(a==2){
            Log.d("if 문","ENTER")
        }
        else if (a==1){
            Log.d("else if 문","ENTER")
        }

        Log.d("var a의 현재 변수 값",a.toString()) // d: debug의 줄입말
        // Log.e로 설정하면 로그가 빨간색으로 변하기 때문에 Logcat에서 직관적으로 찾기 쉬워짐 --> Error 필터 적용하면 더 쉬워지기 때문

    }
}