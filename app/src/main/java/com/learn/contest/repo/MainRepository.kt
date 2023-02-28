package com.learn.contest.repo

import com.learn.contest.RetrofitService.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {
    fun getallcontest() = retrofitService.getAllContest()
}