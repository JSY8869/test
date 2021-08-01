package com.ussu.memorydiary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DiaryActivity : AppCompatActivity() {

    private lateinit var datetextview: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary)

        datetextview = findViewById(R.id.textViewDate)

        var date = intent.getStringExtra("date")
        datetextview.text = "$date"
    }
}