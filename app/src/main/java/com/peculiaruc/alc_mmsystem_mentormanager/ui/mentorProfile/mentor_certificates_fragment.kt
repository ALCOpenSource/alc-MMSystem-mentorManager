package com.peculiaruc.alc_mmsystem_mentormanager.ui.mentorProfile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.alc_mmsystem_mentormanager.MentorManagerApplication
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.mentorProfile.MentorsCertificate
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentMentorCertificatesFragmentBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.mentor_profile.mentor_Certificates_adapter

/** this class handles the display of the mentor certificates,
*currents only the Ui is in place and loading of a dummy mentor certificate  list
*/

class mentor_certificates_fragment : Fragment() {

    private var _binding: FragmentMentorCertificatesFragmentBinding? = null
    private lateinit var rvAdapter: mentor_Certificates_adapter
    private lateinit var mentors_certificates : List<MentorsCertificate>
    /**This property is only valid between onCreateView and
    * onDestroyView.
     */
    val binding_to_layout_File get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        load_dummy_programms()
        _binding = FragmentMentorCertificatesFragmentBinding.inflate(inflater, container, false)
        return binding_to_layout_File.root
    }

    /**
     * load dummy data to the list of programs
     */
     fun load_dummy_programms() {
        mentors_certificates = listOf(
            MentorsCertificate("GADS CLOUD 2022 - COMPLETION1",R.id.certificate),
            MentorsCertificate("GADS CLOUD 2022 - COMPLETION2",R.id.certificate),
            MentorsCertificate("GADS CLOUD 2022 - COMPLETION3",R.id.certificate),
            MentorsCertificate("GADS CLOUD 2022 - COMPLETION4",R.id.certificate),
            MentorsCertificate("GADS CLOUD 2022 - COMPLETION5",R.id.certificate),
            MentorsCertificate("GADS CLOUD 2022 - COMPLETION6",R.id.certificate),
            MentorsCertificate("GADS CLOUD 2022 - COMPLETION7",R.id.certificate),
            MentorsCertificate("GADS CLOUD 2022 - COMPLETION8",R.id.certificate),
            MentorsCertificate("GADS CLOUD 2022 - COMPLETION9",R.id.certificate),
            MentorsCertificate("GADS CLOUD 2022 - COMPLETION10",R.id.certificate),
            MentorsCertificate("GADS CLOUD 2022 - COMPLETION11",R.id.certificate),
            MentorsCertificate("GADS CLOUD 2022 - COMPLETION12",R.id.certificate),
            MentorsCertificate("GADS CLOUD 2022 - COMPLETION13",R.id.certificate),



            )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        // pass it to rvLists layoutManager
        binding_to_layout_File.mentorCertificatesRecycleview.setLayoutManager(layoutManager)
        // initialize the adapter,
        // and pass the required argument
        rvAdapter = mentor_Certificates_adapter(mentors_certificates)
        // attach adapter to the recycler view
        binding_to_layout_File.mentorCertificatesRecycleview.adapter = rvAdapter

        binding_to_layout_File.mentors.text= MentorManagerApplication.global_Var_MENTOR_NAME
        binding_to_layout_File.body2.text= MentorManagerApplication.global_Var_MENTOR_NAME
        binding_to_layout_File.mentorProgramPic.setImageResource(MentorManagerApplication.global_Var_MENTOR_NAME_pic)

        binding_to_layout_File.arrowLeft.setOnClickListener {
            activity?.onBackPressed();
        }

        binding_to_layout_File.reports.setOnClickListener {
            activity?.onBackPressed();
        }






    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding =null
    }



}