package com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.disscussion_forum


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.alc_mmsystem_mentormanager.data.local.chat_messages.individual_chat_messages
import kotlin.contracts.Returns

/**
 * MMM-Team-7
 * Adapter for individual chat recycler with forwarded messages
 */

class fragment_mm_chat2_adapter(private var messages: List<individual_chat_messages>)  :
    RecyclerView.Adapter<fragment_mm_chat2_adapter.MessageViewHolder>() {

        private val SENT = 1
        private val RECEIVED = 0
        private val FOWARD = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = when (viewType) {
            SENT -> {
                LayoutInflater.from(parent.context).inflate(com.peculiaruc.alc_mmsystem_mentormanager.R.layout.fragment_mm_chats2_from_me, parent, false)
            }
            RECEIVED -> {
                LayoutInflater.from(parent.context).inflate(com.peculiaruc.alc_mmsystem_mentormanager.R.layout.fragment_mm_chats2_from_others, parent, false)
            }
            else -> {
                LayoutInflater.from(parent.context).inflate(com.peculiaruc.alc_mmsystem_mentormanager.R.layout.fragment_mm_chats2_foward, parent, false)

            }
        }
        return MessageViewHolder(view)
    }
    override fun getItemCount() = messages.size
    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.bind(messages[position])
    }
    override fun getItemViewType(position: Int): Int {
       val msstype:Int
        if (messages[position].receive.equals(0)) {
            msstype=SENT
        } else  if (messages[position].receive.equals(1))   {
          msstype= RECEIVED
        }
        else{

            msstype=FOWARD
        }

        return msstype
    }

    inner class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val messageText: TextView = itemView.findViewById(com.peculiaruc.alc_mmsystem_mentormanager.R.id.chat_message_body)

        private val time: TextView = itemView.findViewById(com.peculiaruc.alc_mmsystem_mentormanager.R.id.chat_time)
        fun bind(message: individual_chat_messages) {
                messageText.text = message.message

                time.text=message.chat_time

        }
    }
}





