package com.example.firebase_connect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class ResisterActivity : AppCompatActivity() {

    private lateinit var mFirebaseAuth: FirebaseAuth // 파이어베이스 인증 처리
    private lateinit var mDatabaseRef: DatabaseReference // 실시간 데이터 베이스
    private lateinit var mEtEmail: EditText // 회원 가입 입력 필드(이메일)
    private lateinit var mEtPwd: EditText // 회원 가입 입력 필드(비밀번호)
    private lateinit var mBtnRegister: Button // 회원 가입 버튼

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resister)

        mFirebaseAuth = FirebaseAuth.getInstance()
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Firebase")
        mEtEmail = findViewById<EditText>(R.id.et_email)
        mEtPwd = findViewById<EditText>(R.id.et_pwd)
        mBtnRegister = findViewById<Button>(R.id.btn_register)

        mBtnRegister.setOnClickListener(View.OnClickListener {
            // 회원가입 처리 시작
            var strEmail: String = mEtEmail.getText().toString()
            var strPwd: String = mEtPwd.getText().toString()

            // Firebase Auth 진행
            mFirebaseAuth?.createUserWithEmailAndPassword(strEmail, strPwd)
                ?.addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        var firebaseUser: FirebaseUser? = mFirebaseAuth.currentUser
                        var account = UserAccount()
                        account.idToken = firebaseUser?.uid.toString()
                        account.emailId = firebaseUser?.email.toString()
                        account.password = strPwd

                        // setValue : database에 insert (삽입) 행위위
                        mDatabaseRef.child("Firebase").child(firebaseUser?.uid.toString())
                            .setValue(account)

                        Toast.makeText(this, "회원가입에 성공하셨습니다", Toast.LENGTH_SHORT).show()

                    } else {
                        Toast.makeText(this, "회원가입에 실패하셨습니다", Toast.LENGTH_SHORT).show()
                    }
                }
        })

    }
}





