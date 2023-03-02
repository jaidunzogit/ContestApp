package com.learn.contest.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.learn.contest.repo.AllContest

@Entity(tableName = "ContestStore")
data class ContestStore(

    @PrimaryKey
    @ColumnInfo(name = "name")
    val name:String,

    @ColumnInfo(name = "url")
    val url:String,

)