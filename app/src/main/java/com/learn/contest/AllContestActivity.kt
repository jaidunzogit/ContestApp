package com.learn.contest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.learn.contest.RecyclerView.AllContestAdapter
import com.learn.contest.RetrofitService.RetrofitService
import com.learn.contest.ViewModel.MainViewModel
import com.learn.contest.ViewModel.MyViewModelFactory
import com.learn.contest.databinding.ActivityAllContestBinding
import com.learn.contest.repo.MainRepository

class AllContestActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private lateinit var binding: ActivityAllContestBinding
    lateinit var viewModel: MainViewModel
    private val retrofit = RetrofitService.getInstance()
    val adapter = AllContestAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_contest)

        binding = ActivityAllContestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.allcontestRecyclerView.layoutManager=LinearLayoutManager(this)


        viewModel = ViewModelProvider(this,MyViewModelFactory(MainRepository(retrofit))).get(MainViewModel::class.java)

        binding.allcontestRecyclerView.adapter=adapter


        viewModel.allcontest.observe(this,{
            Log.d(TAG,"onCreate: $it")
            adapter.setAllContestList(it)
        })

        viewModel.errorMessage.observe(this,{})

        viewModel.getAllContest()

    }
}