package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    var UserList = arrayListOf<User>(

        User(R.drawable.android,"euna","22","안녕하세요"),
        User(R.drawable.android,"자바","21","반갑습니다"),
        User(R.drawable.android,"자바스크립트","22","굿잡"),
        User(R.drawable.android,"코틀린","18","배고프다"),
        User(R.drawable.android,"스위프트","43","심심하다"),
        User(R.drawable.android,"안드로이드","13","놀러오세요"),
        User(R.drawable.android,"리액트 네이티브","13","헬로")

    )


    override fun onCreate(savedInstanceState: Bundle?) { // 액티비티의 실행 시작 지점

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val item = arrayOf("사과","배","딸기", "키위","수박") // String 형태의 배열 생성
//
//        val listv = findViewById<ListView>(R.id.listView)
//        // context란 한 액티비티의 모든 정보를 담고있음
//        listv.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, item)

        val Adapter = UserAdapter(this, UserList)
        val listView = findViewById<ListView>(R.id.listView)
        listView.adapter = Adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener{ parent, view, position, id->
            val selectItem = parent.getItemAtPosition(position) as User
            Toast.makeText(this,selectItem.name, Toast.LENGTH_SHORT).show()
            
        }


    }
}