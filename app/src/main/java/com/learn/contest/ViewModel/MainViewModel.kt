package com.learn.contest.ViewModel


import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learn.contest.db.ContestDatabase
import com.learn.contest.db.ContestStore
import com.learn.contest.repo.AllContest
import com.learn.contest.repo.MainRepository
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(
    private val repository: MainRepository,
    applicationContext: Context
) : ViewModel() {

    //  allcontest is Going to be observed
    val allcontest = MutableLiveData<List<AllContest>>()
    val errorMessage = MutableLiveData<String>()

    //   Database object
    private val dbhelper = ContestDatabase.getInstance(applicationContext)


    //   function to set the data into allcontest to be observed
    fun getAllContest() {

        val response = repository.getallcontest()

        response.enqueue(object : Callback<List<AllContest>> {

            override fun onResponse(
                call: Call<List<AllContest>>,
                response: Response<List<AllContest>>
            ) {

                allcontest.postValue(response.body())

                viewModelScope.launch {
                    setintodatabase(response.body())
                }
                Log.d("DATA", "From Api")
            }

            override fun onFailure(call: Call<List<AllContest>>, t: Throwable) {
                Log.d("DATA", "Data base fetching")
                viewModelScope.launch { getfromdatabase() }
            }
        })

    }

    private suspend fun setintodatabase(z: List<AllContest>?) = withContext(Dispatchers.Default) {
        if (z != null) {
            for (t in z) {
                dbhelper.contestDao().insert(ContestStore(t.name, t.url))
            }
        }
    }

    private suspend fun getfromdatabase() = withContext(Dispatchers.Default) {
        val cs = dbhelper.contestDao().getallcontest()
        val ac = mutableListOf<AllContest>()

        for (t in cs) {
            ac.add(AllContest(t.name, t.url, "", "", "", "", "", ""))
        }
        allcontest.postValue(ac)

    }
}