package com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.disscussion_forum

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.alc_mmsystem_mentormanager.R
import com.peculiaruc.alc_mmsystem_mentormanager.data.local.chat_messages.individual_chat_messages
import com.peculiaruc.alc_mmsystem_mentormanager.databinding.FragmentMmChats2Binding
import com.peculiaruc.alc_mmsystem_mentormanager.ui.adapters.disscussion_forum.fragment_mm_chat2_adapter
import com.peculiaruc.alc_mmsystem_mentormanager.ui.fragments.chat_messages.home.HomeViewModel

class fragment_mm_chat2 : Fragment() {
    private var _binding: FragmentMmChats2Binding? = null
    private val binding get() = _binding!!
    private lateinit var rvAdapter: fragment_mm_chat2_adapter
    private lateinit var chat_messages: List<individual_chat_messages>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ):
            View? {
        _binding = FragmentMmChats2Binding.inflate(inflater, container, false)
        load_messages()
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentMmChats2Binding.inflate(inflater, container, false)
        val root: View = binding.root
        homeViewModel.text.observe(viewLifecycleOwner) {
        }
        return binding.root
    }

    private fun load_messages() {

        chat_messages = listOf(
            individual_chat_messages("Peculiar C. Umeh 1","Hello Kabiru, trust you are well?",1,"10:30 am", R.drawable.ann_2),
            individual_chat_messages("Kabiru M. Magaya 2","Hi Peculiar, i am well. Thanks",0,"10:30 am", R.drawable.ann_2),
            individual_chat_messages("Peculiar C. Umeh 3","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent dignissim pharetra metus, ut cursus purus efficitur et. Duis ac enim tellus. Phasellus eget tortor dapibus, laoreet mauris sed, dignissim lectus.",1,"10:30 am", R.drawable.ann_2),
            individual_chat_messages("Peculiar C. Umeh 4","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent dignissim pharetra metus, ut cursus purus efficitur et. Duis ac enim tellus. Phasellus eget tortor dapibus, laoreet mauris sed, dignissim lectus.",2,"10:30 am", R.drawable.ann_2),
            individual_chat_messages("Kabiru M. Magaya 5","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent dignissim pharetra metus, ut cursus purus efficitur et. Duis ac enim tellus. Phasellus eget tortor dapibus, laoreet mauris sed, dignissim lectus.",0,"10:30 am", R.drawable.ann_2),
            individual_chat_messages("Peculiar C. Umeh 6","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent dignissim pharetra metus, ut cursus purus efficitur et. Duis ac enim tellus. Phasellus eget tortor dapibus, laoreet mauris sed, dignissim lectus.",0,"10:30 am", R.drawable.ann_2),
            individual_chat_messages("Kabiru M. Magaya 7","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent dignissim pharetra metus, ut cursus purus efficitur et. Duis ac enim tellus. Phasellus eget tortor dapibus, laoreet mauris sed, dignissim lectus.",2,"10:30 am", R.drawable.ann_2),
            individual_chat_messages("Peculiar C. Umeh 8","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent dignissim pharetra metus, ut cursus purus efficitur et. Duis ac enim tellus. Phasellus eget tortor dapibus, laoreet mauris sed, dignissim lectus.",1,"10:30 am", R.drawable.ann_2),
            individual_chat_messages("Kabiru M. Magaya 9","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent dignissim pharetra metus, ut cursus purus efficitur et. Duis ac enim tellus. Phasellus eget tortor dapibus, laoreet mauris sed, dignissim lectus.",2,"10:30 am", R.drawable.ann_2),
            individual_chat_messages("Peculiar C. Umeh 10","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent dignissim pharetra metus, ut cursus purus efficitur et. Duis ac enim tellus. Phasellus eget tortor dapibus, laoreet mauris sed, dignissim lectus.",1,"10:30 am", R.drawable.ann_2),
            )

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        // pass it to rvLists layoutManager
        binding.mentorTasksRecycleview.setLayoutManager(layoutManager)

        rvAdapter= fragment_mm_chat2_adapter(chat_messages)
        // attach adapter to the recycler view
        binding.mentorTasksRecycleview.adapter = rvAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()


    }
}