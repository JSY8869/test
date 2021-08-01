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
        var id = idEditText.text
        var pw = pwEditText.text
        //Toast.makeText(view.context, id, Toast.LENGTH_LONG).show()
        if (id.length == 0) { //id를 입력하지 않은 경우
            Toast.makeText(view.context, "id를 입력해주세요", Toast.LENGTH_LONG).show()
        } else if (pw.length == 0) { //password를 입력하지 않은 경우
            Toast.makeText(view.context, "password를 입력해주세요", Toast.LENGTH_LONG).show()
        } else if (id.contains("zsu") && (pw.contains("happy"))) { //로그인 성공
            Toast.makeText(view.context, "로그인 되었습니다", Toast.LENGTH_LONG).show()
            var intent = Intent(this@LoginActivity, HomeActivity::class.java)
            startActivity(intent)
        } else { //id, password가 일치하지 않는 경우
            Toast.makeText(view.context, "id, password를 확인해주세요.", Toast.LENGTH_LONG).show()
        }
    }

}