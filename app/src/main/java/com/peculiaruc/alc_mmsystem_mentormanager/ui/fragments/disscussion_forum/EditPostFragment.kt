package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.disscussion_forum

/**
 * implements the functionality of the fragment edit task screen
 */


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentEditPostBinding

class EditPostFragment : Fragment() {

    private var _binding: FragmentEditPostBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditPostBinding.inflate(inflater, container, false)

        binding.editPostBack.setOnClickListener {
            Navigation.findNavController(requireView()).popBackStack(R.id.discussionForumFragment2, false)
        }

        binding.editPostButtonChange.setOnClickListener {
            val fragment = PostUpdatedDialogueFragment()
            fragment.show(requireActivity().supportFragmentManager, "show updated")
        }

        binding.editPostButtonCancel.setOnClickListener {
            val fragment = CommentDeletedDialogue()
            fragment.show(requireActivity().supportFragmentManager, "show updated")
        }

        return binding.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}