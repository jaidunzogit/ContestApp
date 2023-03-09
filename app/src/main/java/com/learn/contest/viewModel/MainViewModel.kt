package com.learn.contest.viewModel


import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learn.contest.db.ContestDatabase
import com.learn.contest.db.ContestStore
import com.learn.contest.retrofitService.AllContest
import com.learn.contest.repo.MainRepository
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(
    private val repository: MainRepository,
    context: Context
) : ViewModel() {

    //  allcontest is Going to be observed
    val allcontest = MutableLiveData<List<AllContest>>()
    val errorMessage = MutableLiveData<String>()

    //   Database object
    private val dbhelper = ContestDatabase.getInstance(context)

    private lateinit var response:Call<List<AllContest>>

    //   function to set the data into allcontest to be observed
    fun getAllContest() {


        viewModelScope.launch {
            response = repository.getallcontest()
        }


        Log.d("DATA",response.toString())

        response.enqueue(object : Callback<List<AllContest>> {

            override fun onResponse(
                call: Call<List<AllContest>>,
                response: Response<List<AllContest>>
            ) {
                if(response.isSuccessful){
                    allcontest.postValue(response.body())

//                    dbhelper.clearAllTables()
                    viewModelScope.launch {

                        setintodatabase(response.body())
                    }
                    Log.d("DATA", "From Api")
                }
                else{
                    Log.d("Request Error :: ",response.body().toString())
                }

            }

            override fun onFailure(call: Call<List<AllContest>>, t: Throwable) {
                Log.d("DATA", "Data base fetching")
                viewModelScope.launch { getfromdatabase() }
            }
        })

    }

    private suspend fun setintodatabase(z: List<AllContest>?) = withContext(Dispatchers.Default) {
        dbhelper.clearAllTables()
        if (z != null) {
            for (t in z) {
                dbhelper.contestDao().insert(ContestStore(t.name, t.url,t.start_time,t.end_time,t.duration,t.site,t.in_24_hours,t.status))
            }
        }
    }

    private suspend fun getfromdatabase() = withContext(Dispatchers.Default) {
        val cs = dbhelper.contestDao().getallcontest()
        val ac = mutableListOf<AllContest>()

        for (t in cs) {
            ac.add(AllContest(t.name, t.url,t.start_time,t.end_time,t.duration,t.site,t.in_24_hours,t.status))
        }
        allcontest.postValue(ac)

    }
}