package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.disscussion_forum

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentCommentsBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.CommentAdapter

class CommentsFragment : Fragment() {

    private var _binding: FragmentCommentsBinding? = null
    private val binding
        get() = _binding!!

    private val comments = arrayOf<String>(
        "Sarah Tasha", "Sarah Tasha", "Sarah Tasha", "Sarah Tasha", "Sarah Tasha", "Sarah Tasha",
    )

    private val adapters = CommentAdapter(comments)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCommentsBinding.inflate(inflater, container, false)

        binding.commentToolbar.apply {
            setNavigationIcon(R.drawable.ic_back)
        }

        binding.commentIconMessage.setOnClickListener {
            val fragment = DeleteSuccessDialogueFragment()
            fragment.show(requireActivity().supportFragmentManager, "show deleted")
        }

        binding.commentList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapters
        }

        return binding.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}