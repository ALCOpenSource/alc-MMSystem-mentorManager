package com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.chat_messages


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.chatMessages.ChatBroadcastMessage

/**
 * MMM-Team-7
 * An adapter class for the broadcast message recycler view
 */

class chat_broadcast_messages_adapter(private var messages: List<ChatBroadcastMessage>)  :
    RecyclerView.Adapter<chat_broadcast_messages_adapter.MessageViewHolder>() {

        private val SENT = 1
        private val RECEIVED = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = when (viewType) {
            SENT -> {
                LayoutInflater.from(parent.context).inflate(com.peculiaruc.alc_mmsystem_mentormanager.R.layout.fragment_broadcast_messages_from_me, parent, false)
            }
            else -> {
                LayoutInflater.from(parent.context).inflate(com.peculiaruc.alc_mmsystem_mentormanager.R.layout.fragment_broadcast_messages_from_others, parent, false)
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
     *  holds the views for the  chat_broadcast message adapter
     */

    inner class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val messageText: TextView = itemView.findViewById(com.peculiaruc.alc_mmsystem_mentormanager.R.id.chat_message_body)
        private val mentor_name: TextView = itemView.findViewById(com.peculiaruc.alc_mmsystem_mentormanager.R.id.mentors)

        private val time: TextView = itemView.findViewById(com.peculiaruc.alc_mmsystem_mentormanager.R.id.text_gchat_date_me)

        /**
         * binding the views with the text from the list
         */

        fun bind(message: ChatBroadcastMessage) {
                messageText.text = message.message
           mentor_name.text = message.name
                time.text=message.chatTime

        }
    }
}





