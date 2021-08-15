package com.ussu.memorydiary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    private lateinit var idEditText: EditText //나중에 값을 넣어주겠다
    private lateinit var pwEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        idEditText = findViewById(R.id.editTextTextId)
        pwEditText = findViewById(R.id.editTextTextPassword)

    }

    fun clickLogin(view: View) {
        val signupId = intent.getStringExtra("id")
        val signupPw = intent.getStringExtra("pw")

        var loginId = idEditText.text.toString()
        var loginPw = pwEditText.text.toString()

        //Toast.makeText(view.context, "id, pw, loginId, loginPw", Toast.LENGTH_LONG).show()

        if ((loginId == signupId) && (loginPw == signupPw)) { //로그인 성공
            Toast.makeText(view.context, "로그인 되었습니다", Toast.LENGTH_LONG).show()
            var intent = Intent(this@LoginActivity, HomeActivity::class.java)
            intent.putExtra("id", "$loginId")
            startActivity(intent)
        } else { //id, password가 일치하지 않는 경우
            Toast.makeText(view.context, "id, password를 확인해주세요.", Toast.LENGTH_LONG).show()
        }
    }

}