package com.learn.contest.recyclerView

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.learn.contest.R
import com.learn.contest.retrofitService.AllContest


class AllContestAdapter(private val context: Context) :
    RecyclerView.Adapter<AllContestAdapter.AllContestViewHolder>() {

    private var allcontest = mutableListOf<AllContest>()



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

        holder.cardView.setCardBackgroundColor(Color.parseColor("#76F9C3"))

        holder.cn.text = "CONTEST NAME  :"
        holder.cn.setTextColor(Color.parseColor("#ff0000"))
        holder.cn.textSize = 16F


        holder.name.text = singlecontest.name
        holder.name.setTextColor(Color.parseColor("#000000"))
        holder.name.textSize = 17F
        holder.name.setPadding(20,0,0,0)

        holder.url.text = "Visit the Contest Page"

        holder.url.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse(singlecontest.url)
            context.startActivity(openURL)
        }
    }

    override fun getItemCount(): Int {
        return allcontest.size
    }


    class AllContestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name: TextView = itemView.findViewById(R.id.name)
        val url: Button = itemView.findViewById(R.id.url)
        val cn: TextView = itemView.findViewById(R.id.cn)
        val cardView:CardView = itemView.findViewById(R.id.card_view)
    }

}