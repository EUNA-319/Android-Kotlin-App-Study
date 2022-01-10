package com.example.edittextbutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) { // 액티비티가 최초 실행 되면 이곳을 수행한다

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.btn_getText) // 버튼 id값으로 해당 버튼을 가져옴
        button.setOnClickListener{ // edit 텍스트에 입력되어 있는 값을 가지고와서 textView에 보여지게 하기
            var resultText = findViewById<EditText>(R.id.ed_id).text.toString() // editText에 입력되어 있는 값 가져오기
            val editText = findViewById<TextView>(R.id.tv_result)
            editText.setText(resultText); // 입력된 값을 텍스트뷰에 set해 줌


        }

    }


}