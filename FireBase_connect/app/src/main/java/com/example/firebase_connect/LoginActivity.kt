package com.example.firebase_connect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class LoginActivity : AppCompatActivity() {

    private lateinit var mFirebaseAuth: FirebaseAuth // 파이어베이스 인증 처리
    private lateinit var mDatabaseRef: DatabaseReference // 실시간 데이터 베이스
    private lateinit var mEtEmail: EditText // 로그인 입력 필드(이메일)
    private lateinit var mEtPwd: EditText // 로그인 입력 필드(비밀번호)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mFirebaseAuth = FirebaseAuth.getInstance()
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Firebase")
        mEtEmail = findViewById<EditText>(R.id.et_email)
        mEtPwd = findViewById<EditText>(R.id.et_pwd)



        var btn_login = findViewById<Button>(R.id.btn_login)
        btn_login.setOnClickListener(View.OnClickListener {
            // 로그인 요청
            var strEmail: String = mEtEmail.getText().toString()
            var strPwd: String = mEtPwd.getText().toString()

            mFirebaseAuth?.signInWithEmailAndPassword(strEmail,strPwd)
                ?.addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // 로그인 성공
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish() // 현재 액티비티 파괴

                    } else {
                        Toast.makeText(this, "로그인 실패..!", Toast.LENGTH_SHORT).show()
                    }
                }
        })

        val btn_register = findViewById<Button>(R.id.btn_register)
        btn_register.setOnClickListener(View.OnClickListener{

            val intent = Intent(this, ResisterActivity::class.java)
            startActivity(intent)

        })
    }
}