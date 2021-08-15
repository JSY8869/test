package com.ussu.memorydiary

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.gson.GsonBuilder
import com.ussu.memorydiary.API.API
import com.ussu.memorydiary.API.memberInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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
//        val signupId = intent.getStringExtra("id")
//        val signupPw = intent.getStringExtra("pw")

        //입력받은 loginId, loginPw
        var loginId = idEditText.text.toString()
        var loginPw = pwEditText.text.toString()

        val BASE_URL = "http://192.168.0.104:5000"

        var gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val api = retrofit.create(API::class.java)
        val callreadMemberInfo = api.readMemberInfo("$loginId")

        callreadMemberInfo.enqueue(object : Callback<memberInfo> {
            override fun onResponse(call: Call<memberInfo>, response: Response<memberInfo>) {
                if (response.body() != null) {

                    var id = response.body()!!.member_id
                    var pw = response.body()!!.member_password
                    Toast.makeText(view.context, "$id, $pw", Toast.LENGTH_LONG).show()

                    if ((loginId == id) && (loginPw == pw)) { //로그인 성공
                        Toast.makeText(view.context, "로그인 되었습니다", Toast.LENGTH_LONG).show()
                        var intent = Intent(this@LoginActivity, HomeActivity::class.java)
                        intent.putExtra("id", "$loginId")
                        startActivity(intent)
                    } else { //id, password가 일치하지 않는 경우
                        Toast.makeText(view.context, "id, password를 확인해주세요.", Toast.LENGTH_LONG).show()
                    }
                }
            }

            override fun onFailure(call: Call<memberInfo>, t: Throwable) {
                Log.d(ContentValues.TAG, "실패: $t")
            }
        })
    }
}