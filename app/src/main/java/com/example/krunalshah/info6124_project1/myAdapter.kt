package com.example.krunalshah.info6124_project1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class myAdapter (private val mList: List<ItemsViewModel>) : RecyclerView.Adapter<myAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModelRecord = mList[position]
        holder.activityText.text = ItemsViewModelRecord.record

//        val ItemsViewModelDAndT = dateAndTime[position]
//        holder.dateAndTimeText.text = ItemsViewModelDAndT.dAndT
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val activityText: TextView = itemView.findViewById(R.id.activityText)
//        val dateAndTimeText: TextView = itemView.findViewById(R.id.dateAndTimeText)
    }
}