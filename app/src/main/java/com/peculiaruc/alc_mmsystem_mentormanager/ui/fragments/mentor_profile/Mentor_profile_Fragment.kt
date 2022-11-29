package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.mentor_profile

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.core.view.MenuProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentMentorProfileBinding
import kotlin.properties.Delegates


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class Mentor_profile_Fragment : Fragment() {
    private var _binding: FragmentMentorProfileBinding? = null
    lateinit var  mentor_name:String


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentMentorProfileBinding.inflate(inflater, container, false)

        mentor_name = requireArguments().getString("Mentor_name").toString()

binding.reportToolbar.setNavigationOnClickListener(){

    requireActivity().onBackPressedDispatcher
        .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().popBackStack()
            }
        })


}

        binding.reportToolbar.apply {
            setNavigationIcon(R.drawable.ic_back)
            addMenuProvider(object : MenuProvider {
                override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                    menuInflater.inflate(R.menu.mentor_profile_menu_item, menu)
                }
                override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                    // below line is to get our menu item.
                    val searchItem: MenuItem = menu.findItem(R.id.app_bar_search)
                    // getting search view of our item.
                    val searchView: SearchView = searchItem.getActionView() as SearchView
                    // below line is to call set on query text listener method.
                    searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
                        android.widget.SearchView.OnQueryTextListener {
                        override fun onQueryTextSubmit(p0: String?): Boolean {
                            return false
                        }
                        override fun onQueryTextChange(msg: String): Boolean {
                            // inside on query text change method we are
                            // calling a method to filter our recycler view.
//                            filter(msg)
                            return false
                        }
                    })
                    return true
                }
            })
        }
        binding.pagetitle.text=mentor_name
        binding.body2.text=mentor_name


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.Programs.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_SecondFragment_to_mentors_programs_fragment2)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding =null
    }
}