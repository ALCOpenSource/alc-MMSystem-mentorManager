package com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.alc_mmsystem_mentormanager.R

/**
 * MMM-Team-7
 * Adapter for the program list screen recycler view
 */

class ProgramListAdapter(private val programs: Array<String>) : RecyclerView.Adapter<ProgramListAdapter.ProgramViewHolder>() {

    class ProgramViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val nTitle = view.findViewById<TextView>(R.id.programHead)

        // A function used to attach data to the recycler view items
        fun bind(title: String) {
            nTitle.text = title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgramViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.program_item, parent, false)
        return ProgramViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProgramViewHolder, position: Int) {
        val current = programs[position]
        holder.bind(current)
    }

    override fun getItemCount(): Int = programs.size
}