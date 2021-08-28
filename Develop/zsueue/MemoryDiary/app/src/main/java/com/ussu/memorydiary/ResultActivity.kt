package com.ussu.memorydiary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.ussu.memorydiary.R

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var scoreImage = findViewById<ImageView>(R.id.scoreImage)

        //애니메이션 정의
        val scaleX2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale_x2)
        val scaleX3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale_x3)
        val scaleX4 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale_x4)
        val scaleX5 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale_x5)

        //사진 선택
        //scoreImage.setImageResource(R.drawable.leaf)

        //애니메이션 설정
        //scoreImage.startAnimation(scaleX2)

        var score = 0

        if (score in 1..3) {
            scoreImage.setImageResource(R.drawable.leaf)
            scoreImage.startAnimation(scaleX2)
        } else if (score in 3..5) {
            scoreImage.setImageResource(R.drawable.leaf)
            scoreImage.startAnimation(scaleX3)
        } else if (score in 5..8) {
            scoreImage.setImageResource(R.drawable.leaf)
            scoreImage.startAnimation(scaleX4)
        } else if (score in 8..10) {
            scoreImage.setImageResource(R.drawable.leaf)
            scoreImage.startAnimation(scaleX5)
        } else if (score in 10..30) {
            scoreImage.setImageResource(R.drawable.flower)
            scoreImage.startAnimation(scaleX2)
        } else if (score in 30..60) {
            scoreImage.setImageResource(R.drawable.flower)
            scoreImage.startAnimation(scaleX3)
        } else if (score in 60..90) {
            scoreImage.setImageResource(R.drawable.flower)
            scoreImage.startAnimation(scaleX4)
        } else if (score in 90..100) {
            scoreImage.setImageResource(R.drawable.flower)
            scoreImage.startAnimation(scaleX5)
        }
    }
}