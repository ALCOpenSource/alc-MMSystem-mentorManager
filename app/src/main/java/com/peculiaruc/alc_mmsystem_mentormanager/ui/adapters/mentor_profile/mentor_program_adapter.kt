package com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.mentor_profile


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.local.mentor_profile.mentors_programs
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentMentorProgramsRecyclerviewItemBinding

/**
 * MMM-Team-7
 * Adapter for the mentors program screen from the mentors profile
 */

class mentor_program_adapter(var mentor_program: List<mentors_programs>, ) : RecyclerView.Adapter<mentor_program_adapter.ViewHolder>() {

    /**
     * holds the views from the rv
     */

    inner class ViewHolder(val binding: FragmentMentorProgramsRecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FragmentMentorProgramsRecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(mentor_program[position]){
                binding.gadsProgra.text = this.program_name
                binding.programDate.text = this.date
//                binding.mentorProgramPic.setImageResource(this.program_profile_pic)
                binding.dropdownsD.setOnClickListener {

                }
            }
            }
        }

    override fun getItemCount(): Int {
        return mentor_program.size
    }
}


