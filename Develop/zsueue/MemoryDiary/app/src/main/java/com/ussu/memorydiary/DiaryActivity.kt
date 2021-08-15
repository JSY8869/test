package com.ussu.memorydiary

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.gson.GsonBuilder
import com.ussu.memorydiary.API.API
import com.ussu.memorydiary.API.textInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DiaryActivity : AppCompatActivity() {

    private lateinit var dateTextView: TextView
    private lateinit var diaryTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary)

        dateTextView = findViewById(R.id.textViewDate)
        diaryTextView = findViewById(R.id.textViewDiary)

        val date = intent.getStringExtra("date")
        val loginId = intent.getStringExtra("id")
        dateTextView.text = "$date"

    }

    fun saveDiaryText(view: View) {
        val BASE_URL = "http://192.168.0.104:5000"
        val date = intent.getStringExtra("date")
        val loginId = intent.getStringExtra("id")
        var text = diaryTextView.text.toString()

        var gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val api = retrofit.create(API::class.java)
        val callSaveDiaryText = api.saveDiaryText(textInfo("$loginId", "$date", "$text"))

        callSaveDiaryText.enqueue(object : Callback<textInfo> {
            override fun onResponse(call: Call<textInfo>, response: Response<textInfo>) {
                Log.d(TAG, "성공: ${response.raw()}")
            }

            override fun onFailure(call: Call<textInfo>, t: Throwable) {
                Log.d(TAG, "실패: $t")
            }
        })
    }

    fun editDiaryText(view: View) {
        val BASE_URL = "http://192.168.0.104:5000"
        val date = intent.getStringExtra("date")
        val loginId = intent.getStringExtra("id")
        var text = diaryTextView.text.toString()

        var gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val api = retrofit.create(API::class.java)
        val callEditDiaryText = api.editDiaryText("$loginId", (textInfo("$loginId", "$date", "$text")))

        callEditDiaryText.enqueue(object : Callback<textInfo> {
            override fun onResponse(call: Call<textInfo>, response: Response<textInfo>) {
                Log.d(TAG, "성공: ${response.raw()}")
            }

            override fun onFailure(call: Call<textInfo>, t: Throwable) {
                Log.d(TAG, "실패: $t")
            }
        })
    }

    fun deleteDiaryText(view: View) {
        val BASE_URL = "http://192.168.0.104:5000"
        val loginId = intent.getStringExtra("id")

        var gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val api = retrofit.create(API::class.java)
        val calldeleteDiaryText = api.deleteDiaryText("$loginId")

        calldeleteDiaryText.enqueue(object : Callback<textInfo> {
            override fun onResponse(call: Call<textInfo>, response: Response<textInfo>) {
                Log.d(TAG, "성공: ${response.raw()}")
            }

            override fun onFailure(call: Call<textInfo>, t: Throwable) {
                Log.d(TAG, "실패: $t")
            }
        })
    }

}