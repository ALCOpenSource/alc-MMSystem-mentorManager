package com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.chat_messages


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.alc_mmsystem_mentormanager.MentorManagerApplication.Companion.global_Var_chat_partner
import com.peculiaruc.alc_mmsystem_mentormanager.MentorManagerApplication.Companion.global_Var_chat_profile_pic
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.local.chat_messages.chat_messages
import com.peculiaruc.alc_mmsystem_mentormanager.data.local.mentor_profile.mentors_programs
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentChatMessagesRecyclerviewItemBinding
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentMentorProgramsRecyclerviewItemBinding

/**
 * MMM-Team-7
 * An adapter for the chat messages recycler view
 */

class chat_messages_adapter(var chats_message_list: List<chat_messages>, ) : RecyclerView.Adapter<chat_messages_adapter.ViewHolder>() {

    /**
     * view holder class for the adapter
     */

    inner class ViewHolder(val binding: FragmentChatMessagesRecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FragmentChatMessagesRecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(chats_message_list[position]){
                binding.name.text = this.name
               binding.message.text = this.message
               binding.mentorProgramPic.setImageResource(this.profile_pic)
                binding.agingTime.text = this.creation_time
                binding.noOfMessages.text = this.number

                binding.dropdownsD.setOnClickListener {
                    global_Var_chat_partner=this.name
                    global_Var_chat_profile_pic=this.profile_pic
                    Navigation.findNavController(it).navigate(R.id.action_chat_messages_Fragment3_to_individual_chat_fragment2)
                }
            }
            }
        }

    override fun getItemCount(): Int {
        return chats_message_list.size
    }
}


