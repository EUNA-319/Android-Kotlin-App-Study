package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // var: 변수
        // val: 자바에서는 final을 의미하는 변수로 값이 변경되지 못하는 변수

        val change = findViewById<Button>(R.id.btn_a)
        change.setOnClickListener{
            val intent = Intent(this, SubActivity::class.java) // 다음 화면으로 이동하기 위한 인텐트 객체 생성
            val sendMsg = findViewById<TextView>(R.id.tv_sendMsg)
            intent.putExtra("msg",sendMsg.text.toString()) // Hello World라는 텍스트 값을 담은 뒤 msg라는 키로 lock
            startActivity(intent) // intent에 저장되어있는 액티비티 쪽으로 이동
            finish() // 자기 자신 액티비티를 파괴 -> 서브 액티비티로 이동후 뒤로가기 버튼을 누르면 앱이 종료됨

        }

    }
}