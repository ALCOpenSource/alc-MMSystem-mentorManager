package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.Reports
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentReportBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.ReportsAdapter
import com.peculiaruc.alc_mmsystem_mentormanager.util.OnDownloadClickListener
import com.peculiaruc.alc_mmsystem_mentormanager.util.OnItemClickListener
import com.peculiaruc.alc_mmsystem_mentormanager.util.OnShareClickListener

class ReportFragment : Fragment() {
    private var _binding: FragmentReportBinding? = null
    private val binding
        get() = _binding!!

    private val reports = listOf<Reports>(Reports(
        "Google African Developer Scholarship Report",
        "By Ibrahim -",
        "19th-20th oct 22"
    ))

    private val adapters = ReportsAdapter(reports)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReportBinding.inflate(inflater, container, false)

        binding.reportToolbar.apply {
            setNavigationIcon(R.drawable.ic_back)
            addMenuProvider(object : MenuProvider{
                override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                    menuInflater.inflate(R.menu.menu_item, menu)
                }

                override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                    return true
                }

            })
        }

        binding.reportList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapters
        }

        adapters.apply {
            setOnItemClickListener(object : OnItemClickListener{
                override fun onItemClickedListener() {
                    val reportsDetails = ReportDetailsFragment()
                    activity?.supportFragmentManager?.commit {
                        setCustomAnimations(
                            R.anim.slide_in,
                            R.anim.fade_out,
                            R.anim.fade_out,
                            R.anim.slide_in
                        )
                        replace(R.id.fragment_container_view, reportsDetails)
                        addToBackStack(null)
                    }
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
                    fragment.show(activity!!.supportFragmentManager, "show share dialogue")
                }

            })
        }

        binding.reportFab.setOnClickListener {
            val composeReportFragment = ComposeReportFragment()
            activity?.supportFragmentManager?.commit {
                setCustomAnimations(
                    R.anim.slide_in,
                    R.anim.fade_out,
                    R.anim.fade_out,
                    R.anim.slide_in
                )
                replace(R.id.fragment_container_view, composeReportFragment)
                addToBackStack(null)
            }

        }

        return binding.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}