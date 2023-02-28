package com.learn.contest.repo

import com.google.gson.annotations.SerializedName
import okhttp3.HttpUrl

data class AllContest(
    var name: String,


    var url: String,


    var start_time: String,


    var end_time: String,


    var duration: String,


    var site: String,


    var in_24_hours: String,


    var status: String
)
