package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.mentor_profile
import android.os.Bundle

import android.view.*
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.local.mentor_profile.mentor_list
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.AlertDialogBoxAddMentorBinding
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentMentorListBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.SpinnerAdapter
import com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.mentor_profile.mentor_list_adapter
import com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.mentor_reports.ShareDialogueFragment
import java.util.*


/**
 *  to implement the functionality of the mentor list screen
 *  no functionality implmented yet
 */

class Mentor_list_Fragment : Fragment() {
    private var _binding:FragmentMentorListBinding? = null
    private val binding get() = _binding!!
    private lateinit var rvAdapter: mentor_list_adapter
    private lateinit var mentorLists :ArrayList<mentor_list>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):
            View? {
        _binding = FragmentMentorListBinding.inflate(inflater, container, false)
        //  Load dummy data on the mentors list
        load_mentors_dummy_list()
        //Handle Search  icon
        handleSearchClicked()
        // intialize mentor filter spinner and assign it values
        val spinner: Spinner = binding.MentorsSpinner
        val mList = arrayListOf("All Mentors", "Assigned", "Unassigned")
        // Create an adapter  for the spinner
       val spinnerArrayAdapter = SpinnerAdapter(requireActivity(), mList)
        binding.MentorsSpinner.adapter = spinnerArrayAdapter
        spinnerArrayAdapter?.setDropDownViewResource(R.layout.spinner_list_item)

        handleSpinnerSelected()
        /**Respond to selection of item in a spinner
         *
         */

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                binding.body1.setText(mList.get(position));
                if (mList[position] =="Assigned"){
                    sort_mentors(true)
                }
                else if(mList[position] =="Unassigned"){
                    sort_mentors(false)
                }
                else{
                    val mentor_recyleview=binding.mentorsRv
                    mentor_recyleview.getAdapter()?.notifyItemInserted(mentorLists.size );
                    mentor_recyleview.getAdapter()?.notifyDataSetChanged();
                    mentor_recyleview.setHasFixedSize(true);
                    mentor_recyleview.setLayoutManager(LinearLayoutManager(requireView().getContext()));
                    mentor_recyleview.setAdapter(mentor_list_adapter(mentorLists))
                }
                spinner.setVisibility(View.GONE);
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(context, "", Toast.LENGTH_SHORT).show()
            }
        }




        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // populate the mentors recyclerview with list of all mentros
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        binding.mentorsRv.setLayoutManager(layoutManager)
        rvAdapter = mentor_list_adapter(mentorLists)
        binding.mentorsRv.adapter = rvAdapter
        // add new mentor
        binding.carbonAdd.setOnClickListener {
            val fragment = addmentorDialogueFragment()
            fragment.show(requireActivity().supportFragmentManager, "show add dialogue")
        }
    }

    //this function is executed when the spinner element is selected to  sort menotrs list based on the selected item
    private fun sort_mentors(text: Boolean) {
        val filteredlist = ArrayList<mentor_list>()
        for (item in mentorLists) {
            if (item.assignne?.equals(text)==true) {
                filteredlist.add(item)
            }
        }
        if (filteredlist.isEmpty()) {
            val mentor_recyleview=binding.mentorsRv
            mentor_recyleview.getAdapter()?.notifyItemInserted(mentorLists.size );
            mentor_recyleview.getAdapter()?.notifyDataSetChanged();
            mentor_recyleview.setHasFixedSize(true);
            mentor_recyleview.setLayoutManager(LinearLayoutManager(requireView().getContext()));
            mentor_recyleview.setAdapter(mentor_list_adapter( filteredlist))

        } else {
            val mentor_recyleview=binding.mentorsRv
            mentor_recyleview.getAdapter()?.notifyItemInserted(mentorLists.size );
            mentor_recyleview.getAdapter()?.notifyDataSetChanged();
            mentor_recyleview.setHasFixedSize(true);
            mentor_recyleview.setLayoutManager(LinearLayoutManager(requireView().getContext()));
            mentor_recyleview.setAdapter(mentor_list_adapter( filteredlist))
        }
    }

    private fun load_mentors_dummy_list() {
        mentorLists = arrayListOf(
            mentor_list("Peculiar C. Umeh1", "Program Assistant, Andela, She.her", "PROGRAM SST.", "MENTOR-GDs", R.drawable.ann, true),
            mentor_list(
                "Mohammend J. Hassan",
                "Program Assistant1, Andela, She-her",
                "PROGRAM ASST",
                "MENTOR-GADs",
                R.drawable.ann_2,
                false
            ),
            mentor_list(
                "Ombasanjo R. Uke",
                "Program Assistant2, Andela, She her",
                "PROGRAM ASST.",
                "MENTOR-GAD",
                R.drawable.grace,
                true
            ),
            mentor_list(
                "James Karim Michael",
                "Program Assistant3, Andela, She",
                "PROGRAM AST.",
                "MENTOR GAD",
                R.drawable.profile,
                false,
            ),


        )

    }

 //  filter function does instant sreach of the emntors list on change of text in the search button

    private fun filter(text: String) {
        val filteredlist = ArrayList<mentor_list>()
        for (item in mentorLists) {
            if (item.name?.toLowerCase()?.contains(text.lowercase(Locale.getDefault())) == true) {
                filteredlist.add(item)
            }
        }
        if (filteredlist.isEmpty()) {
            val mentor_recyleview=binding.mentorsRv
            mentor_recyleview.getAdapter()?.notifyItemInserted(mentorLists.size );
            mentor_recyleview.getAdapter()?.notifyDataSetChanged();
            mentor_recyleview.setHasFixedSize(true);
            mentor_recyleview.setLayoutManager(LinearLayoutManager(requireView().getContext()));
            mentor_recyleview.setAdapter(mentor_list_adapter( filteredlist))
        } else {
            val mentor_recyleview=binding.mentorsRv
            mentor_recyleview.getAdapter()?.notifyItemInserted(mentorLists.size );
            mentor_recyleview.getAdapter()?.notifyDataSetChanged();
            mentor_recyleview.setHasFixedSize(true);
            mentor_recyleview.setLayoutManager(LinearLayoutManager(requireView().getContext()));
            mentor_recyleview.setAdapter(mentor_list_adapter( filteredlist))
        }
    }
// handle the search of the  mentors list when when the search icon is clicked in the customixe app bar
    private fun handleSearchClicked() {
        binding.Searchicon.setOnSearchClickListener {
            binding.Searchicon.background = AppCompatResources.getDrawable(requireContext(), R.drawable.card_border)
            binding.reportTitle.visibility = View.INVISIBLE
            binding.broadcastM.visibility = View.INVISIBLE
        }
        val searchView: android.widget.SearchView = binding.Searchicon
        // below line is to call set on query text listener method.
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(msg: String): Boolean {
                // inside on query text change method we are
                // calling a method to filter our recycler view.
                filter(msg)
                return false
            }
        })
        binding.Searchicon.setOnCloseListener {
            binding.Searchicon.background = null
            binding.reportTitle.visibility = View.VISIBLE
            binding.broadcastM.visibility = View.INVISIBLE
            false
        }


    }

    private fun handleSpinnerSelected() {
        binding.MentorsSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                binding.MentorsSpinner.dropDownWidth = 300
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(context, "to be imlemented", Toast.LENGTH_SHORT).show()
            }

        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}



