package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.mentor_reports

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.Reports
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentReportBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.ReportsAdapter
import com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.SpinnerAdapter
import com.peculiaruc.alc_mmsystem_mentormanager.util.OnDownloadClickListener
import com.peculiaruc.alc_mmsystem_mentormanager.util.OnItemClickListener
import com.peculiaruc.alc_mmsystem_mentormanager.util.OnShareClickListener

class ReportFragment : Fragment() {
    private var _binding: FragmentReportBinding? = null
    private val binding
        get() = _binding!!

    private val reports = listOf(Reports("Google African Developer Scholarship Report", "By Ibrahim -", "19th-20th oct 22"),
        Reports("Google African Developer Scholarship Report", "By Ibrahim -", "19th-20th oct 22"),
        Reports("Google African Developer Scholarship Report", "By Ibrahim -", "19th-20th oct 22"),
        Reports("Google African Developer Scholarship Report", "By Ibrahim -", "19th-20th oct 22"),
        Reports("Google African Developer Scholarship Report", "By Ibrahim -", "19th-20th oct 22"),
        Reports("Google African Developer Scholarship Report", "By Ibrahim -", "19th-20th oct 22"),
        Reports("Google African Developer Scholarship Report", "By Ibrahim -", "19th-20th oct 22"),
        Reports("Google African Developer Scholarship Report", "By Ibrahim -", "19th-20th oct 22"),
        Reports("Google African Developer Scholarship Report", "By Ibrahim -", "19th-20th oct 22"),
        Reports("Google African Developer Scholarship Report", "By Ibrahim -", "19th-20th oct 22"),
        Reports("Google African Developer Scholarship Report", "By Ibrahim -", "19th-20th oct 22"),
        Reports("Google African Developer Scholarship Report", "By Ibrahim -", "19th-20th oct 22"),
        Reports("Google African Developer Scholarship Report", "By Ibrahim -", "19th-20th oct 22"),
        Reports("Google African Developer Scholarship Report", "By Ibrahim -", "19th-20th oct 22"),
        Reports("Google African Developer Scholarship Report", "By Ibrahim -", "19th-20th oct 22"),
        Reports("Google African Developer Scholarship Report", "By Ibrahim -", "19th-20th oct 22"),
        Reports("Google African Developer Scholarship Report", "By Ibrahim -", "19th-20th oct 22"),
        Reports("Google African Developer Scholarship Report", "By Ibrahim -", "19th-20th oct 22"),
        Reports("Google African Developer Scholarship Report", "By Ibrahim -", "19th-20th oct 22"),
        Reports("Google African Developer Scholarship Report", "By Ibrahim -", "19th-20th oct 22"),
        Reports("Google African Developer Scholarship Report", "By Ibrahim -", "19th-20th oct 22"),
        Reports("Google African Developer Scholarship Report", "By Ibrahim -", "19th-20th oct 22"),
        Reports("Google African Developer Scholarship Report", "By Ibrahim -", "19th-20th oct 22"),


        )

    private val adapters = ReportsAdapter(reports)
    private val spinnerList = arrayListOf("All Reports", "Program Reports", "Task Reports")
    private lateinit var spinnerArrayAdapter: SpinnerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReportBinding.inflate(inflater, container, false)

        spinnerArrayAdapter = SpinnerAdapter(requireActivity(), spinnerList)
        binding.reportSpinner.adapter = spinnerArrayAdapter

        handleSpinnerSelected()

        handleSearchClicked()

        binding.reportList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapters
        }

        handleReportListItemsSelection()

        binding.reportFab.setOnClickListener {
            binding.reportSearch.isIconified = true
            binding.reportSearch.onActionViewCollapsed()
            findNavController().navigate(R.id.action_reportFragment_to_composeReportFragment)
        }

        return binding.root
    }

    // This method handles the events from the click listener interface
    private fun handleReportListItemsSelection() {
        adapters.apply {
            setOnItemClickListener(object : OnItemClickListener{
                override fun onItemClickedListener() {
                    binding.reportSearch.isIconified = true
                    binding.reportSearch.onActionViewCollapsed()
                    findNavController().navigate(R.id.action_reportFragment_to_reportDetailsFragment)
                }
            })

            setShareClickListener(object : OnShareClickListener{
                override fun onShareClick() {
                    val fragment = ShareDialogueFragment()
                    fragment.show(activity!!.supportFragmentManager, "show share dialogue")
                }
            })

            setOnDownloadClickListener(object : OnDownloadClickListener{
                override fun onDownloadClick() {
                    val fragment = DownloadDialogueFragment()
                    fragment.show(requireActivity().supportFragmentManager, "show share dialogue")
                }

            })
        }
    }

    private fun handleSpinnerSelected() {
        binding.reportSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                binding.reportSpinner.dropDownWidth = 300
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }
    }

    // This method handles the search icon click event
    private fun handleSearchClicked() {
        binding.reportSearch.setOnSearchClickListener {
            binding.reportSearch.isIconifiedByDefault = false
            binding.reportSearch.background = AppCompatResources.getDrawable(requireContext(), R.drawable.card_border)
            binding.reportTitle.visibility = View.INVISIBLE
        }

        binding.reportSearch.setOnCloseListener {
            binding.reportSearch.background = null
            binding.reportTitle.visibility = View.VISIBLE
            false
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}