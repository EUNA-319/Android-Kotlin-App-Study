package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFrag(0)


        val btnFragment1 = findViewById<Button>(R.id.btn_fragment1)
        val btnFragment2 = findViewById<Button>(R.id.btn_fragment2)
        val btnFragment3 = findViewById<Button>(R.id.btn_fragment3)

        btnFragment1.setOnClickListener{
            setFrag(0)
        }

        btnFragment2.setOnClickListener{
            setFrag(1)
        }

        btnFragment3.setOnClickListener{
            setFrag(2)
        }



    }

    private fun setFrag(fragNum : Int) { // private: 접근제한자
        val ft = supportFragmentManager.beginTransaction()
        when(fragNum){
            0 -> {
                ft.replace(R.id.main_frame, Fragment1()).commit()
            }
            1 -> {
                ft.replace(R.id.main_frame, Fragment2()).commit()
            }
            2 -> {
                ft.replace(R.id.main_frame, Fragment3()).commit()
            }
        }
    }
}