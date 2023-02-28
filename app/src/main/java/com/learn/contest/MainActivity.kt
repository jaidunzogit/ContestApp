package com.learn.contest

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val allcontestBtn :Button = findViewById(R.id.allcontestBtn)
        allcontestBtn.setOnClickListener(){

            val intent = Intent(this,AllContestActivity::class.java)
            startActivity(intent)

        }
    }
}