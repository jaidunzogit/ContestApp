package com.learn.contest

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import androidx.lifecycle.ViewModel

class LoadingProgressBar(private val lActivity:Activity) {

    private lateinit var isdailog:AlertDialog
    fun startLoading(){
        val inflater = lActivity.layoutInflater
        val dialogView = inflater.inflate(R.layout.progressbar,null)

        val builder = AlertDialog.Builder(lActivity)
        builder.setView(dialogView)
        builder.setCancelable(false)
        isdailog = builder.create()
        isdailog.show()
    }

    fun isDismiss(){
        isdailog.dismiss()
    }

}