package com.learn.contest.db


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*

@Dao
interface ContestDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(contestStore: ContestStore)

    @Query("Select * from ContestStore")
    fun getallcontest(): List<ContestStore>

}