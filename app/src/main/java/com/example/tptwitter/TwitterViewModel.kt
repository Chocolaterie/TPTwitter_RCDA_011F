package com.example.tptwitter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TwitterViewModel : ViewModel() {

    var tweets = MutableLiveData<List<Tweet>>()

    fun appelAPI(){
        // Données liste de tweets mock
        viewModelScope.launch {
            tweets.value = TweetApi.retrofitService.getTweets()
        }
    }
}