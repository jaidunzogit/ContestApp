package com.learn.contest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat
import com.learn.contest.notificationManager.Notifications


class MainActivity : AppCompatActivity() {

    lateinit  private var notify:Notifications

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        notify = Notifications(this)

//      Button to enter the all contest

        val allcontestBtn: Button = findViewById(R.id.allcontestBtn)
        allcontestBtn.setText(R.string.allcontest_text)
        allcontestBtn.setTextColor(ContextCompat.getColor(applicationContext,R.color.text_Colour))
//        allcontestBtn.setBackgroundColor(ContextCompat.getColor(applicationContext,R.color.bgn_color))


//        Entering into AllcontestActivity
        notify.createNotificationchannel()
        allcontestBtn.setOnClickListener {
            val intent = Intent(this, AllContestActivity::class.java)
            startActivity(intent)
        }
    }
}