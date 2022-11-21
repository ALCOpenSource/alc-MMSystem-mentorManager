package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.mentor_reports

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.view.MenuProvider
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentProgramListBinding

class ProgramListFragment : Fragment() {
    private var _binding: FragmentProgramListBinding? = null
    private val binding
    get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProgramListBinding.inflate(inflater, container, false)

        binding.programListToolbar.apply {
            setNavigationIcon(R.drawable.ic_back)
            addMenuProvider(object : MenuProvider {
                override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                    menuInflater.inflate(R.menu.menu_item, menu)
                }

                override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                    return true
                }

            })
        }

        return binding.root
    }

}