package com.learn.contest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.learn.contest.recyclerView.AllContestAdapter
import com.learn.contest.retrofitService.RetrofitService
import com.learn.contest.viewModel.MainViewModel
import com.learn.contest.viewModel.MyViewModelFactory
import com.learn.contest.databinding.ActivityAllContestBinding
import com.learn.contest.notificationManager.Notifications
import com.learn.contest.repo.MainRepository

class AllContestActivity : AppCompatActivity() {

    private lateinit var notify:Notifications
    private lateinit var binding: ActivityAllContestBinding
    private lateinit var viewModel: MainViewModel
    private val retrofit = RetrofitService.getInstance()
    private val adapter = AllContestAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//      Inflating the layout and binding the activity all contest xml with "binding"
        binding = ActivityAllContestBinding.inflate(layoutInflater)
        setContentView(binding.root)



//      Binding the RecyclerView
        binding.allcontestRecyclerView.layoutManager = LinearLayoutManager(this)

        binding.allcontestRecyclerView.visibility = View.GONE
        binding.loadingBar.visibility = View.VISIBLE

//      Binding the recyclerView with the AllContestAdapter
        binding.allcontestRecyclerView.adapter = adapter

//      Handling the notifications
        notify = Notifications(this)
        notify.createNotificationchannel()

//      Creating the ViewModel
        viewModel = ViewModelProvider(
            this,
            MyViewModelFactory(notify,MainRepository(retrofit), this)
        )[MainViewModel::class.java]


        viewModel.getAllContest()

//      Observing the data
        viewModel.allcontest.observe(this) {
            Log.d("DATA", "onCreate: $it")

            binding.loadingBar.visibility = View.GONE
            binding.allcontestRecyclerView.visibility = View.VISIBLE

            adapter.setAllContestList(it)
        }

        viewModel.errorMessage.observe(this) {}



    }

}