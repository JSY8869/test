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

    fun clickDiaryCalendar(view: View) {
        var intent = Intent(this@HomeActivity, CalendarActivity::class.java)
        startActivity(intent)
    }

    fun clickGame(view: View) {
        var intent = Intent(this@HomeActivity, GameActivity::class.java)
        startActivity(intent)
    }
}