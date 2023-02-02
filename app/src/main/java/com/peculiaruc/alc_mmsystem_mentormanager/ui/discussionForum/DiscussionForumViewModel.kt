package com.peculiaruc.alc_mmsystem_mentormanager.ui.discussionForum

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.peculiaruc.alc_mmsystem_mentormanager.data.models.Discussion
import com.peculiaruc.alc_mmsystem_mentormanager.utilities.event.Event

class DiscussionForumViewModel : ViewModel(), DiscussionInteractionListener {

    private val _selectEditPost = MutableLiveData<Event<Discussion>>()
    val selectEditPost: LiveData<Event<Discussion>> = _selectEditPost

    private val _selectCommentOnPost = MutableLiveData<Event<Discussion>>()
    val selectCommentOnPost: LiveData<Event<Discussion>> = _selectCommentOnPost

    private val _createPostEvent = MutableLiveData<Event<Boolean>>()
    val createPostEvent: LiveData<Event<Boolean>> = _createPostEvent

    override fun onItemEditDiscussionSelected(item: Discussion) {
        _selectEditPost.postValue(Event(item))
    }

    override fun onItemCommentOnPostSelected(item: Discussion) {
        _selectCommentOnPost.postValue(Event(item))
    }

    fun onClickCreatePost() {
        _createPostEvent.postValue(Event(true))
    }

}