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
        var answer = AnswerEditText.text
        if (answer.contains("유정")) { //정답
            Toast.makeText(view.context, "정답입니다!", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(view.context, "오답입니다! 다시 생각해보세요", Toast.LENGTH_LONG).show()
        }
    }
}