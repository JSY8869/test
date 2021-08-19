package com.ussu.memorydiary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class GameActivity : AppCompatActivity() {
    private lateinit var AnswerEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        AnswerEditText = findViewById(R.id.editTextTextAnswer)
    }

    fun clickAnswer(view: View) {
//        //서버에서 질문, 답 가져오기
//        val BASE_URL = "http://192.168.0.104:5000"
//        val loginId = intent.getStringExtra("id")
//
//        var gson = GsonBuilder()
//            .setLenient()
//            .create()
//
//        val retrofit = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create(gson))
//            .build()
//
//        val api = retrofit.create(API::class.java)
//        val callGetQuestionInfo = api.getAnswer("$loginId")
//
//        callGetQuestionInfo.enqueue(object : Callback<questionInfo> {
//            override fun onResponse(call: Call<questionInfo>, response: Response<questionInfo>) {
//                Log.d(ContentValues.TAG, "성공: ${response.raw()}")
//            }
//
//            override fun onFailure(call: Call<questionInfo>, t: Throwable) {
//                Log.d(ContentValues.TAG, "실패: $t")
//            }
//        })

        //답 입력받기
        var answer = AnswerEditText.text.toString()

        //답 비교
        if (answer == "지수") { //정답
            Toast.makeText(view.context, "정답입니다!", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(view.context, "오답입니다! 다시 생각해보세요", Toast.LENGTH_LONG).show()
        }
    }
}