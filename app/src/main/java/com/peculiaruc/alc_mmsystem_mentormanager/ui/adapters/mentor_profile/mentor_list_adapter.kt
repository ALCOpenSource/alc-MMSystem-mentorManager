package com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.mentor_profile


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.alc_mmsystem_mentormanager.MentorManagerApplication.Companion.global_Var_MENTOR_NAME
import com.peculiaruc.alc_mmsystem_mentormanager.MentorManagerApplication.Companion.global_Var_MENTOR_NAME_pic
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.local.mentor_profile.mentor_list
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentMentorListRecyclerviewItemBinding

/**
 * MMM-Team-7
 * Adapter for the mentor list screen
 */

class mentor_list_adapter(private var mentor_list:ArrayList<mentor_list>, ) : RecyclerView.Adapter<mentor_list_adapter.ViewHolder>() {

    inner class ViewHolder(val binding: FragmentMentorListRecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FragmentMentorListRecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }
    // method for filtering our recyclerview items.
    // method for filtering our recyclerview items.
    fun filterList(filterlist: ArrayList<mentor_list>) {
        // below line is to add our filtered
        // list in our course array list.
        mentor_list = filterlist
        // below line is to notify our adapter
        // as change in recycler view data.
        notifyDataSetChanged()
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(mentor_list[position]){
                binding.mentorName.text = this.name
                binding.bioData.text = this.Bio_data
                binding.Title.text = this.Title
                binding.role.text = this.Role
                binding.mentorProfilePic.setImageResource(this.profile_pic)
                binding.dropdownsD.setOnClickListener {

                    val bundle = bundleOf("Mentor_name" to binding.mentorName.text.toString().trim())
                    global_Var_MENTOR_NAME=binding.mentorName.text.toString()
                    global_Var_MENTOR_NAME_pic=this.profile_pic
                    Navigation.findNavController(it).navigate(R.id.action_FirstFragment_to_SecondFragment2,bundle)
                }
            }
            }
        }

    override fun getItemCount(): Int {
        return mentor_list.size
    }
}



