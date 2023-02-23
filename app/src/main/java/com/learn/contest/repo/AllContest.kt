package com.learn.contest.repo

import com.google.gson.annotations.SerializedName
import okhttp3.HttpUrl

data class AllContest(

    @SerializedName("name")
    var name: String,

    @SerializedName("url")
    var url: HttpUrl,

    @SerializedName("start_time")
    var start_time: String,

    @SerializedName("end_time")
    var end_time: String,

    @SerializedName("duration")
    var duration: String,

    @SerializedName("site")
    var site: HttpUrl,

    @SerializedName("in_24_hours")
    var in_24_hours: String,

    @SerializedName("status")
    var status: String
)
