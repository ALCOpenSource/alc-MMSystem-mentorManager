package com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.Reports
import com.peculiaruc.alc_mmsystem_mentormanager.util.OnDownloadClickListener
import com.peculiaruc.alc_mmsystem_mentormanager.util.OnItemClickListener
import com.peculiaruc.alc_mmsystem_mentormanager.util.OnShareClickListener

class ReportsAdapter(private val reports: List<Reports>) : RecyclerView.Adapter<ReportsAdapter.ReportsViewHolder>() {

    private lateinit var listener: OnItemClickListener
    private lateinit var shareListener: OnShareClickListener
    private lateinit var downloadListener: OnDownloadClickListener

    fun setOnDownloadClickListener(mDownloadListener: OnDownloadClickListener) {
        downloadListener = mDownloadListener
    }

    fun setShareClickListener(mShareListener: OnShareClickListener) {
        shareListener = mShareListener
    }

    fun setOnItemClickListener(mlistener: OnItemClickListener) {
        listener = mlistener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReportsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.report_item, parent, false)
        return ReportsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReportsViewHolder, position: Int) {
        val current = reports[position]
        holder.bind(current.title, current.user, current.time)
    }

    override fun getItemCount(): Int = reports.size

    inner class ReportsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val nTitle = view.findViewById<TextView>(R.id.reporItemTitle)
        private val nUser = view.findViewById<TextView>(R.id.reportItemUser)
        private val nTime = view.findViewById<TextView>(R.id.reportItemTime)
        private val nDownload = view.findViewById<ImageView>(R.id.reportItemDownload)
        private val nShare = view.findViewById<ImageView>(R.id.reportItemShare)

        init {
            nDownload.setOnClickListener {
                downloadListener.onDownloadClick()
            }

            nShare.setOnClickListener {
                shareListener.onShareClick()
            }

            view.setOnClickListener {
                listener.onItemClickedListener()
            }
        }


        fun bind(title: String, user: String, time: String) {
            nTitle.text = title
            nUser.text = user
            nTime.text = time
        }
    }
}