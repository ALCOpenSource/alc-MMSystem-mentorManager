package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.mentor_profile
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.local.mentor_profile.mentor_list
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentMentorListBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.SpinnerAdapter
import com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.mentor_profile.mentor_list_adapter
import com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.mentor_reports.DownloadDialogueFragment
import com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.mentor_reports.ShareDialogueFragment
import com.peculiaruc.alc_mmsystem_mentormanager.util.OnDownloadClickListener
import com.peculiaruc.alc_mmsystem_mentormanager.util.OnItemClickListener
import com.peculiaruc.alc_mmsystem_mentormanager.util.OnShareClickListener
import java.util.*
import javax.activation.*
import javax.mail.*
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeBodyPart
import javax.mail.internet.MimeMessage
import javax.mail.internet.MimeMultipart


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

        binding.arrowDropd.setOnClickListener {
            Toast.makeText(context, "i am clicked", Toast.LENGTH_SHORT).show()
            if (spinner.getVisibility() == View.INVISIBLE) {
                spinner.setVisibility(View.VISIBLE);
                spinner.performClick()
            } else {
                spinner.setVisibility(View.INVISIBLE);
            }
        }
        // Respond to selection of item in a spinner
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
            val dialogadd_mentor = layoutInflater.inflate(R.layout.alert_dialog_box_add_mentor, null)
            val dialog_confirmsend = layoutInflater.inflate(R.layout.alert_dialog_box_done_adding_mentor, null)
            //display the add mentor dialog box
            val customDialog = context?.let { it1 -> AlertDialog.Builder(it1).setView(dialogadd_mentor).show() }
          // on click of cancel button close the dialog box
            val btn_add_mentor_dialog_cancel = dialogadd_mentor.findViewById<RelativeLayout>(R.id.frame_352)
            btn_add_mentor_dialog_cancel.setOnClickListener { if (customDialog != null) { customDialog.dismiss() } }
            // on click of send button opend the confirm_send dialog box the
            val btnsend = dialogadd_mentor.findViewById<RelativeLayout>(R.id.frame_351)

            btnsend.setOnClickListener {


            }


        }
    }
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
            mentor_list(
                "Peculiar C. Umeh",
                "Program Assistant, Andela, She/her",
                "PROGRAM ASST.",
                "MENTOR-GAD",
                R.drawable.ann,
                true
            ),
            mentor_list(
                "Mohammend J. Hassan",
                "Program Assistant, Andela, She/her",
                "PROGRAM ASST.",
                "MENTOR-GAD",
                R.drawable.ann_2,
                false
            ),
            mentor_list(
                "Ombasanjo R. Uke",
                "Program Assistant, Andela, She/her",
                "PROGRAM ASST.",
                "MENTOR-GAD",
                R.drawable.grace,
                true
            ),
            mentor_list(
                "James Karim Michael",
                "Program Assistant, Andela, She/her",
                "PROGRAM ASST.",
                "MENTOR-GAD",
                R.drawable.profile,
                false,
            ),
            mentor_list(
                "Josep K Ndururro",
                "Program Assistant, Andela, She/her",
                "PROGRAM ASST.",
                "MENTOR-GAD",
                R.drawable.ann_2,
                true,
            ),
            mentor_list(
                "Abdul Hassan Mohamed",
                "Program Assistant, Andela, She/her",
                "PROGRAM ASST.",
                "MENTOR-GAD",
                R.drawable.ann,
                false
            ),
            mentor_list(
                "MiKe Njoronge Macharia",
                "Program Assistant, Andela, She/her",
                "PROGRAM ASST.",
                "MENTOR-GAD",
                R.drawable.profile,
                true
            ),
            mentor_list(
                "Pendo Karisa Haddassah",
                "Program Assistant, Andela, She/her",
                "PROGRAM ASST.",
                "MENTOR-GAD",
                R.drawable.grace,
                false
            ),
            mentor_list(
                "Peculiar C. Umeh",
                "Program Assistant, Andela, She/her",
                "PROGRAM ASST.",
                "MENTOR-GAD",
                R.drawable.ann,
                true
            ),
            mentor_list(
                "Mohammend J. Hassan",
                "Program Assistant, Andela, She/her",
                "PROGRAM ASST.",
                "MENTOR-GAD",
                R.drawable.ann_2,
                false
            ),
            mentor_list(
                "Ombasanjo R. Uke",
                "Program Assistant, Andela, She/her",
                "PROGRAM ASST.",
                "MENTOR-GAD",
                R.drawable.grace,
                true
            ),
            mentor_list(
                "James Karim Michael",
                "Program Assistant, Andela, She/her",
                "PROGRAM ASST.",
                "MENTOR-GAD",
                R.drawable.profile,
                false
            ),
            mentor_list(
                "Josep K Ndururro",
                "Program Assistant, Andela, She/her",
                "PROGRAM ASST.",
                "MENTOR-GAD",
                R.drawable.ann_2,
                true
            ),
            mentor_list(
                "Abdul Hassan Mohamed",
                "Program Assistant, Andela, She/her",
                "PROGRAM ASST.",
                "MENTOR-GAD",
                R.drawable.ann,
                false
            ),
            mentor_list(
                "MiKe Njoronge Macharia",
                "Program Assistant, Andela, She/her",
                "PROGRAM ASST.",
                "MENTOR-GAD",
                R.drawable.profile,
                true
            ),
            mentor_list(
                "Pendo Karisa Haddassah",
                "Program Assistant, Andela, She/her",
                "PROGRAM ASST.",
                "MENTOR-GAD",
                R.drawable.grace,
                false
            ),
            mentor_list(
                "Peculiar C. Umeh",
                "Program Assistant, Andela, She/her",
                "PROGRAM ASST.",
                "MENTOR-GAD",
                R.drawable.ann,
                true
            ),
        )

    }

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

    private fun handleSearchClicked() {
        binding.Searchicon.setOnSearchClickListener {
            binding.Searchicon.background = AppCompatResources.getDrawable(requireContext(), R.drawable.card_border)
            binding.reportTitle.visibility = View.INVISIBLE
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
            false
        }


    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}



