package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.disscussion_forum

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.fragment.app.commit
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentDiscussionForumBinding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.DiscussionForumAdapter
import com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.mentor_reports.ComposeReportFragment
import com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.mentor_reports.DownloadDialogueFragment
import com.peculiaruc.alc_mmsystem_mentormanager.util.OnBookmarkClickListener
import com.peculiaruc.alc_mmsystem_mentormanager.util.OnDeleteClickListener
import com.peculiaruc.alc_mmsystem_mentormanager.util.OnEditClickListener
import com.peculiaruc.alc_mmsystem_mentormanager.util.OnMessageClickListener

/**
 * class displays the  discussion forum recycleview items
 *
 */
class DiscussionForumFragment : Fragment() {

    private var _binding: FragmentDiscussionForumBinding? = null
    private val binding
        get() = _binding!!

    private val discussions = arrayOf(
        "Samuel Kebede 1", "Samuel Kebede 2", "Samuel Kebede 3", "Samuel Kebede 4", "Samuel Kebede 5", "Samuel Kebede 6",
    )

    private lateinit var adapters: DiscussionForumAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDiscussionForumBinding.inflate(inflater, container, false)
        adapters = DiscussionForumAdapter(requireContext(), discussions)

        handleSearchClicked()

        handleItemsClicked()


        binding.forumList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapters
        }

        binding.discussionForumFab.setOnClickListener {
            binding.discussionForumSearch.isIconified = true
            binding.discussionForumSearch.onActionViewCollapsed()
            //findNavController().navigate(R.id.action_discussionForumFragment2_to_newTopicFragment)
        }
        return binding.root
    }
    // This method handles the events from the click listener interface
    private fun handleItemsClicked() {
        adapters.apply {
            setOnMessageClickListener(object : OnMessageClickListener{
                override fun onMessageClick() {
                    //binding.discussionForumSearch.isIconified = true
                   // binding.discussionForumSearch.onActionViewCollapsed()
                    //findNavController().navigate(R.id.action_discussionForumFragment2_to_commentFragment)
                }
            })

            setOnBookmarkClickListener(object : OnBookmarkClickListener{
                override fun onBookmarkClick() {
                    val snackbar = view!!.let { Snackbar.make(it, "", Snackbar.LENGTH_LONG) }
                    val customSnackView = layoutInflater.inflate(R.layout.snackbar_layout, null)
                    snackbar.view.setBackgroundColor(Color.TRANSPARENT)

                    val snackbarLayout = snackbar.view as Snackbar.SnackbarLayout

                    snackbarLayout.setPadding(0,0,0,0)
                    val undoButton = customSnackView.findViewById<CardView>(R.id.undoCard)
                    val bookmarkButton = activity?.findViewById<ImageView>(R.id.forumIconBookmark)

                    undoButton.setOnClickListener {
                        bookmarkButton?.setColorFilter(ContextCompat.getColor(requireContext(), R.color.mms_black_5))
                        Toast.makeText(requireContext(), "Removed from Bookmark", Toast.LENGTH_LONG).show()
                        snackbar.dismiss()
                    }
                    snackbarLayout.addView(customSnackView, 0)
                    snackbar.show()
                }
            })

            setOnEditClickListener(object : OnEditClickListener{
                override fun onEditClick() {
                    //binding.discussionForumSearch.isIconified = true
                    //binding.discussionForumSearch.onActionViewCollapsed()
                    //findNavController().navigate(R.id.action_discussionForumFragment2_to_editPostFragment)
                }
            })

            setOnDeleteClickListener(object : OnDeleteClickListener{
                override fun onDeleteClick() {
                    val fragment = DeleteSuccessDialogueFragment()
                    fragment.show(requireActivity().supportFragmentManager, "show delete dialogue")
                }
            })
        }
    }

    private fun handleSearchClicked() {
        binding.discussionForumSearch.setOnSearchClickListener {
            binding.discussionForumSearch.isIconifiedByDefault = false
            binding.discussionForumSearch.background = AppCompatResources.getDrawable(requireContext(), R.drawable.card_border)
            binding.discussionForumBookmark.visibility = View.INVISIBLE
            binding.discussionForumTitle.visibility = View.INVISIBLE
        }

        binding.discussionForumSearch.setOnCloseListener {
            binding.discussionForumSearch.background = null
            binding.discussionForumBookmark.visibility = View.VISIBLE
            binding.discussionForumTitle.visibility = View.VISIBLE
            false
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}