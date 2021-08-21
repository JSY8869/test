package com.ussu.memorydiary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    fun clickSignup(view: View) {
        var intent = Intent(this@HomeActivity, SignupActivity::class.java)
        startActivity(intent)
    }

    fun clickLogin(view: View) {
        var intent = Intent(this@HomeActivity, LoginActivity::class.java)
        startActivity(intent)
    }

    fun clickDiary(view: View) {
        val id = intent.getStringExtra("id")
        var intent = Intent(this@HomeActivity, CalendarActivity::class.java)
        intent.putExtra("id", "$id")
        startActivity(intent)
    }

    fun clickGame(view: View) {
        val id = intent.getStringExtra("id")
        var intent = Intent(this@HomeActivity, GameCalendarActivity::class.java)
        intent.putExtra("id", "$id")
        startActivity(intent)
    }
}