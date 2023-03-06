package com.learn.contest.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json



@Entity(tableName = "ContestStore")
data class ContestStore(

    @PrimaryKey
    @ColumnInfo(name = "contest_name")
    val name: String,

    @ColumnInfo(name = "url")
    val url: String,

    @field:Json(name = "st")
    val start_time: String,

    val end_time: String,

    val duration: String,

    val site: String,

    val in_24_hours: String,

    val status: String,

    )