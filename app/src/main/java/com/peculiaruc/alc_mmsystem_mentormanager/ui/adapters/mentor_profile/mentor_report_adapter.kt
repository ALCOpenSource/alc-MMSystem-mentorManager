package com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.mentor_profile


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.mentorProfile.MentorsReport
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.ReportItemBinding

/**
 * MMM-Team-7
 * Adapter for the mentors reports screen from the mentors profile
 */

class mentor_report_adapter(var mentor_report: List<MentorsReport>, ) : RecyclerView.Adapter<mentor_report_adapter.ViewHolder>() {

    /**
     * holds the views from the rv
     */

    inner class ViewHolder(val binding:ReportItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ReportItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(mentor_report[position]){
                binding.reporItemTitle.text = this.ReportName
                binding.reportItemTime.text = this.ReportCreationInfo
//                binding.mentorProgramPic.setImageResource(this.program_profile_pic)
                binding.reportitem.setOnClickListener {
                    Navigation.findNavController(it).navigate(R.id.action_mentors_Reports_fragments_to_mentor_report_details)
                }
            }
            }
        }

    override fun getItemCount(): Int {
        return mentor_report.size
    }
}


