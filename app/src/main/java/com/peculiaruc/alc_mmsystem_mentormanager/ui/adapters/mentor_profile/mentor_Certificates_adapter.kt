package com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.mentor_profile


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.alc_mmsystem_mentormanager.MentorManagerApplication.Companion.global_Var_MENTOR_NAME_certificate_name
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.mentorProfile.MentorsCertificate
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentMentorCertificatesRecyclerviewItemBinding

/**
 * MMM-Team-7
 * Adapter for the mentor certificate screen
 */

class mentor_Certificates_adapter(var mentor_certificates: List<MentorsCertificate>, ) : RecyclerView.Adapter<mentor_Certificates_adapter.ViewHolder>() {

    /**
     * holds the views for the class
     */

    inner class ViewHolder(val binding: FragmentMentorCertificatesRecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FragmentMentorCertificatesRecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(mentor_certificates[position]){
                binding.CertficateName.text = this.certificateName

                global_Var_MENTOR_NAME_certificate_name=this.certificateName

                //binding.ace_1.text = this.Report_creation_infor
//                binding.mentorProgramPic.setImageResource(this.program_profile_pic)
                binding.dropdownsD.setOnClickListener {
                    Navigation.findNavController(it).navigate(R.id.action_mentor_certificates_fragment_to_mentors_certificate_generate)
                }
            }
            }
        }

    override fun getItemCount(): Int {
        return mentor_certificates.size
    }
}


