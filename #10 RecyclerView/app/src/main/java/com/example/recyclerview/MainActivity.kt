package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val profileList = arrayListOf(
            Profiles(R.drawable.woman, "김성은", 22, "숙명여자대학교 학생"),
            Profiles(R.drawable.man, "김가은", 25, "안드로이드 개발자"),
            Profiles(R.drawable.woman, "김나은", 21, "맥도날드 아르바이트생"),
            Profiles(R.drawable.man, "김다은", 27, "게임 개발자"),
            Profiles(R.drawable.woman, "김라은", 21, "하이브리드 앱 개발자"),
            Profiles(R.drawable.man, "김마은", 23, "웹 앱 개발자"),
            Profiles(R.drawable.woman, "김바은", 26, "리액트 앱 개발자"),
            Profiles(R.drawable.man, "김사은", 20, "빽다방 알바생")
        )

        val rvProfile = findViewById<RecyclerView>(R.id.rv_profile)
        rvProfile.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) // 세로 방향으로 리스트 뷰를 만들기
        rvProfile.setHasFixedSize(true) // 성능 개선

        rvProfile.adapter = ProfileAdapter(profileList)
    }
}