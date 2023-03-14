package com.learn.contest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//      Button to enter the all contest

        val allcontestBtn: Button = findViewById(R.id.allcontestBtn)
        allcontestBtn.setText(R.string.allcontest_text)
        allcontestBtn.setTextColor(ContextCompat.getColor(applicationContext, R.color.text_Colour))


//        Entering into AllcontestActivity
        allcontestBtn.setOnClickListener {
            val intent = Intent(this, AllContestActivity::class.java)
            startActivity(intent)
        }
    }
}