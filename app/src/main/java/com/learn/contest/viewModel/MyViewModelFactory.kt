package com.learn.contest.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.learn.contest.notificationManager.Notifications
import com.learn.contest.repo.MainRepository

class MyViewModelFactory constructor(
    private val notify:Notifications,
    private val repository: MainRepository,
    private val context: Context
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(notify,this.repository, context) as T
        }
    }

