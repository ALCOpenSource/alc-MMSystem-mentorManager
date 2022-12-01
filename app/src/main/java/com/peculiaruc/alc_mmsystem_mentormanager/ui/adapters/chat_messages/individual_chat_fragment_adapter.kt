package com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.chat_messages


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.alc_mmsystem_mentormanager.data.local.chat_messages.individual_chat_messages

/**
 * MMM-Team-7
 * Adapter for the individual chat recycler view
 */

class individual_chat_fragment_adapter(private var messages: List<individual_chat_messages>)  :
    RecyclerView.Adapter<individual_chat_fragment_adapter.MessageViewHolder>() {

        private val SENT = 1
        private val RECEIVED = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = when (viewType) {
            SENT -> {
                LayoutInflater.from(parent.context).inflate(com.peculiaruc.alc_mmsystem_mentormanager.R.layout.fragment_chat_from_me, parent, false)
            }
            else -> {
                LayoutInflater.from(parent.context).inflate(com.peculiaruc.alc_mmsystem_mentormanager.R.layout.fragment_chat_from_others, parent, false)
            }
        }
        return MessageViewHolder(view)
    }
    override fun getItemCount() = messages.size
    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.bind(messages[position])
    }
    override fun getItemViewType(position: Int): Int {
        return if (messages[position].receive.equals(0)) {
            SENT
        } else {
            RECEIVED
        }
    }

    /**
     * viewholderclass implementation for the adapter
     */

    inner class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val messageText: TextView = itemView.findViewById(com.peculiaruc.alc_mmsystem_mentormanager.R.id.chat_message_body)

        private val time: TextView = itemView.findViewById(com.peculiaruc.alc_mmsystem_mentormanager.R.id.chat_time)

        /**
         * binds views to the data from messages list
         */

        fun bind(message: individual_chat_messages) {
                messageText.text = message.message

                time.text=message.chat_time

        }
    }
}





