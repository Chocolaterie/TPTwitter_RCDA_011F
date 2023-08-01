package com.example.tptwitter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass.
 * Use the [TwitterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TwitterFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_twitter, container, false)

        // Récupère le recycler view
        var rvTweets = view.findViewById<RecyclerView>(R.id.rvTweets)

        // Instancier et liéer l'Adapter
        var adapter = TwitterAdapter()
        rvTweets.adapter = adapter

        // Données liste de tweets mock
        lifecycleScope.launch {
            var tweets = TweetApi.retrofitService.getTweets()

            // Submit des données dans la liste
            adapter.submitList(tweets)
        }

        return view
    }
}