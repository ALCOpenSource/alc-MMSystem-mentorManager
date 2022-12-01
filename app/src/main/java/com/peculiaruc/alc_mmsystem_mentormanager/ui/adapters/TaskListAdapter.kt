package com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.alc_mmsystem_mentormanager.R

/**
 * MMM-Team-7
 * Adapter for the task screen recycler view
 */

class TaskListAdapter(private val tasks: Array<String>): RecyclerView.Adapter<TaskListAdapter.TaskViewHolder>() {
    class TaskViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val nTitle = view.findViewById<TextView>(R.id.taskItemTitle)

        /** A function used to attach data to the recycler view items
         *
         */

        fun bind(title: String) {
            nTitle.text = title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val current = tasks[position]
        holder.bind(current)
    }

    override fun getItemCount(): Int = tasks.size
}