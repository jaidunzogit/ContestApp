package com.learn.contest.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.learn.contest.repo.AllContest
import com.learn.contest.repo.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository) :ViewModel(){

    val allcontest = MutableLiveData<List<AllContest>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllContest(){

        val response = repository.getallcontest()
        response.enqueue(object : Callback<List<AllContest>> {
            override fun onResponse(
                call: Call<List<AllContest>>,
                response: Response<List<AllContest>>
            ) {
                allcontest.postValue(response.body())
                Log.d("DATA",response.body().toString())
            }

            override fun onFailure(call: Call<List<AllContest>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }

}