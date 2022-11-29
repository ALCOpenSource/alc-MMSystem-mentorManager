package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.disscussion_forum

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentCommentsBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.CommentAdapter
import com.peculiaruc.alc_mmsystem_mentormanager.util.OnDeleteClickListener
import com.peculiaruc.alc_mmsystem_mentormanager.util.OnEditClickListener

class CommentsFragment : Fragment() {

    private var _binding: FragmentCommentsBinding? = null
    private val binding
        get() = _binding!!

    private val comments = arrayOf(
        "Sarah Tasha", "Sarah Tasha", "Sarah Tasha", "Sarah Tasha", "Sarah Tasha", "Sarah Tasha",
    )

    private val adapters = CommentAdapter(comments)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCommentsBinding.inflate(inflater, container, false)


        binding.commentBack.setOnClickListener {
            Navigation.findNavController(requireView()).popBackStack(R.id.discussionForumFragment2, false)
        }

        binding.commentIconMessage.setOnClickListener {
            val fragment = DeleteSuccessDialogueFragment()
            fragment.show(requireActivity().supportFragmentManager, "show deleted")
        }

        binding.commentList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapters
        }

        handleBookmarkClick()

        handleClickEventsOnCommentList()

        return binding.root
    }

    private fun handleBookmarkClick() {
        binding.commentIconBookmark.setOnClickListener {

            binding.commentIconBookmark.setColorFilter(ContextCompat.getColor(requireContext(), R.color.mms_pry_2))

            val snackbar = requireView().let { Snackbar.make(it, "", Snackbar.LENGTH_LONG) }
            val customSnackView = layoutInflater.inflate(R.layout.snackbar_layout, null)
            snackbar.view.setBackgroundColor(Color.TRANSPARENT)

            val snackbarLayout = snackbar.view as Snackbar.SnackbarLayout

            snackbarLayout.setPadding(0,0,0,0)
            val undoButton = customSnackView.findViewById<CardView>(R.id.undoCard)

            undoButton.setOnClickListener {
                binding.commentIconBookmark.setColorFilter(ContextCompat.getColor(requireContext(), R.color.mms_black_5))
                Toast.makeText(requireContext(), "Removed from Bookmark", Toast.LENGTH_LONG).show()
                snackbar.dismiss()
            }
            snackbarLayout.addView(customSnackView, 0)
            snackbar.show()
        }
    }

    private fun handleClickEventsOnCommentList() {
        adapters.apply {
            setOnEditClickListener(object : OnEditClickListener{
                override fun onEditClick() {
                    Toast.makeText(requireContext(), "Edit Clicked", Toast.LENGTH_LONG).show()
                }
            })

            setOnDeleteClickListener(object : OnDeleteClickListener{
                override fun onDeleteClick() {
                    val fragment = CommentDeletedDialogue()
                    fragment.show(requireActivity().supportFragmentManager, "show delete dialogue")
                }
            })
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}