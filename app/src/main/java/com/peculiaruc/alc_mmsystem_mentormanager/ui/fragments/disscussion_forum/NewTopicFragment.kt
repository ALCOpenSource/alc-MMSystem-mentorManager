package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.disscussion_forum

/**
 * to implement the functionality of the new topic screen
 * no functionality implemented yet
 */
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentNewTopicBinding

class NewTopicFragment : Fragment() {

    private var _binding: FragmentNewTopicBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewTopicBinding.inflate(inflater, container, false)

        binding.newTopicBack.setOnClickListener {
            Navigation.findNavController(requireView()).popBackStack(R.id.discussionForumFragment2, false)
        }

        return binding.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}