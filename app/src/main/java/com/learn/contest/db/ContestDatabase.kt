package com.learn.contest.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [ContestStore::class], version = 1)
abstract class ContestDatabase:RoomDatabase() {

    abstract fun contestDao():ContestDao

    companion object{
        private var instance:ContestDatabase?=null

        @Synchronized
        fun getInstance(ctx: Context):ContestDatabase{
            if(instance==null){
                instance=Room.databaseBuilder(ctx.applicationContext,ContestDatabase::class.java,
                    "contest_database")
                    .build()
            }
            return instance!!
        }

//        private val roomCallback=object:Callback(){
//            override fun onCreate(db: SupportSQLiteDatabase) {
//                super.onCreate(db)
//            }
//        }
//
//        private fun populateDatabase(db:ContestDatabase){
//
//        }
    }

}