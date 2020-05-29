package com.example.svekomp.project.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.svekomp.R
import kotlinx.android.synthetic.main.recyclerview_row.view.*
import kotlin.collections.ArrayList

class RecycleViewHistoryAdapter(private var taskList: ArrayList<String>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var taskFilterList = ArrayList<String>()

    lateinit var mcontext: Context

    class TaskHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    init {
        taskFilterList = taskList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val taskListView = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_row, parent, false)
        val search = TaskHolder(taskListView)
        mcontext = parent.context
        return search
    }

    override fun getItemCount(): Int {
        return taskFilterList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.select_task_text.text = taskFilterList[position]
        holder.itemView.setOnClickListener {
        }
    }
}