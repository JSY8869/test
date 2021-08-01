package com.ussu.memorydiary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class SignupActivity : AppCompatActivity() {

    private lateinit var idEditText: EditText //나중에 값을 넣어주겠다
    private lateinit var pwEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        idEditText = findViewById(R.id.editTextTextId)
        pwEditText = findViewById(R.id.editTextTextPassword)
    }

    //아이디 중복 X
    fun clickSignup(view: View) {
        var id = idEditText.text
        var pw = pwEditText.text
        //Toast.makeText(view.context, id, Toast.LENGTH_LONG).show()
        if (id.length == 0) { //id를 입력하지 않은 경우
            Toast.makeText(view.context, "id를 입력해주세요", Toast.LENGTH_LONG).show()
        } else if (pw.length == 0) { //password를 입력하지 않은 경우
            Toast.makeText(view.context, "password를 입력해주세요", Toast.LENGTH_LONG).show()
        } else { //회원가입 성공
            Toast.makeText(view.context, "회원가입 성공!", Toast.LENGTH_LONG).show()
            var intent = Intent(this@SignupActivity, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}