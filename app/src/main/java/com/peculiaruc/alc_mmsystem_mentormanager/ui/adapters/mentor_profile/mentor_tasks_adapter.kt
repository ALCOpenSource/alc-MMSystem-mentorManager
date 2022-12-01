package com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.mentor_profile


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.local.mentor_profile.mentors_tasks
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentMentorProgramsRecyclerviewItemBinding

/**
 * MMM-Team-7
 * Adapter for the mentors task screen from the mentors profile
 */

class mentor_tasks_adapter(var mentor_task: List<mentors_tasks>, ) : RecyclerView.Adapter<mentor_tasks_adapter.ViewHolder>() {

    inner class ViewHolder(val binding: FragmentMentorProgramsRecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FragmentMentorProgramsRecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(mentor_task[position]){
                binding.gadsProgra.text = this.task_name
                binding.programDate.text = this.date
//                binding.mentorProgramPic.setImageResource(this.program_profile_pic)
                binding.dropdownsD.setOnClickListener {
                  //  Navigation.findNavController(it).navigate(R.id.action_FirstFragment_to_SecondFragment2)
                }
            }
            }
        }

    override fun getItemCount(): Int {
        return mentor_task.size
    }
}

