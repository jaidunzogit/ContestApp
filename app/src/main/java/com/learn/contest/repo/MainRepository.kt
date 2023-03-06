package com.learn.contest.repo

import com.learn.contest.retrofitService.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {
    fun getallcontest() = retrofitService.getAllContest()
}