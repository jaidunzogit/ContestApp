package com.learn.contest.retrofitService

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    @GET("/api/v1/all")
    fun getAllContest(): Call<List<AllContest>>

    companion object {

        private var retrofitService: RetrofitService? = null

        fun getInstance(): RetrofitService {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder().baseUrl("https://kontests.net/api/")
                    .addConverterFactory(MoshiConverterFactory.create()).build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}