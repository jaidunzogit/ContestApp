package com.learn.contest.ViewModel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.learn.contest.NetworkUtilities.NetworkUtils
import com.learn.contest.db.ContestDatabase
import com.learn.contest.db.ContestStore
import com.learn.contest.repo.AllContest
import com.learn.contest.repo.MainRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(
    private val repository: MainRepository,
    private val applicationContext: Context
) : ViewModel() {

    val allcontest = MutableLiveData<List<AllContest>>()
    val errorMessage = MutableLiveData<String>()
    val dbhelper = ContestDatabase.getInstance(applicationContext)

    fun getAllContest() {

        if (NetworkUtils.isInternetAvailable(applicationContext)) {
            val response = repository.getallcontest()

            response.enqueue(object : Callback<List<AllContest>> {

                override fun onResponse(
                    call: Call<List<AllContest>>,
                    response: Response<List<AllContest>>
                ) {
                    var z: List<AllContest>? = response.body()
                    allcontest.postValue(z)
                    GlobalScope.launch {
                        if (z != null) {
                            for (t in z) {
                                dbhelper.contestDao().insert(ContestStore(t.name, t.url))
                            }
                        }
                    }
                    Log.d("DATA", response.body().toString())
                }

                override fun onFailure(call: Call<List<AllContest>>, t: Throwable) {
                    allcontest.postValue(emptyList())
                }
            })

        } else {
            Log.d("DATABASE", "Data base fetching")
            return getfromdatabase()
        }
    }

    private fun getfromdatabase() {
        GlobalScope.launch {
            var cs = dbhelper.contestDao().getallcontest()
            var ac = mutableListOf<AllContest>()

            for (t in cs) {
                ac.add(AllContest(t.name, t.url, "", "", "", "", "", ""))
            }
            allcontest.postValue(ac)
        }
    }
}