package com.learn.contest

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//      Button to enter the all contest

        val allcontestBtn: Button = findViewById(R.id.allcontestBtn)
        allcontestBtn.text = "All Contest"
        allcontestBtn.setTextColor(Color.parseColor("#ff0000"))
        allcontestBtn.setBackgroundColor(Color.parseColor("#ffffff"))

//        Entering into AllcontestActivity

        allcontestBtn.setOnClickListener() {
            val intent = Intent(this, AllContestActivity::class.java)
            startActivity(intent)

        }
    }
}