package com.ussu.memorydiary

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import com.google.gson.GsonBuilder
import com.ussu.memorydiary.API.diaryAPI
import com.ussu.memorydiary.API.gameText
import com.ussu.memorydiary.API.questionInfo
import com.ussu.memorydiary.API.textInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Game2Activity : AppCompatActivity() {
    private lateinit var AnswerEditText: EditText
    private lateinit var GameTextTextView: TextView
    private lateinit var gameTextWarning: TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game2)

        AnswerEditText = findViewById(R.id.editTextTextAnswer)
        GameTextTextView = findViewById(R.id.textViewGameText)
        gameTextWarning = findViewById(R.id.showWarning)

        var btnAnswer = findViewById<Button>(R.id.btnCheckAnswer)
        var btnWhere = findViewById<Button>(R.id.btnSaveWhere)

        btnAnswer.isVisible = true
        btnWhere.isVisible = true

        //서버에서 질문, 답 가져오기
        val BASE_URL = "http://192.168.0.104:8080"
        val id = intent.getStringExtra("id")
        val date = intent.getStringExtra("date")

        var gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val api = retrofit.create(diaryAPI::class.java)
        val callGetQuestionInfo = api.getAnswer2(questionInfo("$id", "$date", "0", "0", "0"))

        callGetQuestionInfo.enqueue(object : Callback<questionInfo> {
            override fun onResponse(call: Call<questionInfo>, response: Response<questionInfo>) {
                Log.d(ContentValues.TAG, "성공: ${response.raw()}")
                if (response.body() != null) {
                    var getAnswer = response.body()!!.answer
                    var btnAnswer = findViewById<Button>(R.id.btnCheckAnswer)
                    var btnWhere = findViewById<Button>(R.id.btnSaveWhere)

                    if (response.body()!!.answer == "99") {
                        gameTextWarning.isVisible = true
                        btnAnswer.isVisible = false //결과 확인 버튼 비활성화
                        var game_text = response.body()!!.game_text
                        GameTextTextView.text = "$game_text"

                        var answer = AnswerEditText.text.toString()
                        var btnWhere = findViewById<Button>(R.id.btnSaveWhere)

                        btnWhere.setOnClickListener {
                            if (game_text.contains(answer)) {
                                val BASE_URL = "http://192.168.0.104:8080"
                                var answer = AnswerEditText.text.toString()

                                var gson = GsonBuilder()
                                    .setLenient()
                                    .create()

                                val retrofit = Retrofit.Builder()
                                    .baseUrl(BASE_URL)
                                    .addConverterFactory(GsonConverterFactory.create(gson))
                                    .build()

                                val api = retrofit.create(diaryAPI::class.java)
                                val callGetGameText = api.getGameText((gameText(answer)))

                                callGetGameText.enqueue(object : Callback<gameText> {
                                    override fun onResponse(call: Call<gameText>, response: Response<gameText>) {
                                        Toast.makeText(this@Game2Activity, "보내주신 데이터가 잘 저장되었어요!", Toast.LENGTH_LONG).show()
                                        Log.d(ContentValues.TAG, "성공: ${response.raw()}")
                                    }

                                    override fun onFailure(call: Call<gameText>, t: Throwable) {
                                        Log.d(ContentValues.TAG, "실패: $t")
                                    }
                                })
                            }
                            else {
                                Toast.makeText(this@Game2Activity, "일치하는 단어가 없습니다. 다시 입력해주세요.", Toast.LENGTH_LONG).show()
                            }
                        }
                    }
                    else {
                        btnWhere.isVisible = false //저장 버튼 비활성화
                        btnAnswer.setOnClickListener {
                            //답 입력받기
                            var answer = AnswerEditText.text.toString()

                            //답 비교
                            if (answer == getAnswer) { //정답
                                Toast.makeText(this@Game2Activity, "정답입니다!", Toast.LENGTH_LONG).show()
                            } else {
                                Toast.makeText(this@Game2Activity, "오답입니다! 다시 생각해보세요", Toast.LENGTH_LONG
                                ).show()
                            }
                        }
                    }
                } else {
                    AnswerEditText.setText("작성한 일기가 없습니다.")
                }

            }

            override fun onFailure(call: Call<questionInfo>, t: Throwable) {
                Log.d(ContentValues.TAG, "실패: $t")
            }
        })
    }
}