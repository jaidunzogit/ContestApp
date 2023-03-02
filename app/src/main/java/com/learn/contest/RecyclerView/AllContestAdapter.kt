package com.learn.contest.RecyclerView

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.learn.contest.R
import com.learn.contest.repo.AllContest


class AllContestAdapter(val context: Context) :
    RecyclerView.Adapter<AllContestAdapter.AllContestViewHolder>() {

    private val TAG = "MainActivity"
    var allcontest = mutableListOf<AllContest>()

    fun setAllContestList(allcontest: List<AllContest>) {
        this.allcontest = allcontest.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllContestViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.allcontest_row, parent, false)

        return AllContestViewHolder(view)
    }

    override fun onBindViewHolder(holder: AllContestViewHolder, position: Int) {
        val singlecontest = allcontest[position]
        holder.name.text = singlecontest.name
        holder.url.text = "Visit the Site"

        holder.url.setOnClickListener() {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse(singlecontest.url)
            context.startActivity(openURL)
        }

        println(singlecontest.name)
        Log.d(TAG, "RUNNED")
    }

    override fun getItemCount(): Int {
        return allcontest.size
    }


    class AllContestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name: TextView = itemView.findViewById(R.id.name)
        val url: Button = itemView.findViewById(R.id.url)


    }

}