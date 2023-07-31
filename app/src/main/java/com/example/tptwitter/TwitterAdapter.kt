package com.example.tptwitter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tptwitter.databinding.TweetLineBinding

class TweetDiffCallback : DiffUtil.ItemCallback<Tweet> (){
    override fun areItemsTheSame(oldItem: Tweet, newItem: Tweet): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Tweet, newItem: Tweet): Boolean {
        return oldItem.id == newItem.id
    }
}

class TwitterAdapter : ListAdapter<Tweet, TwitterAdapter.ViewHolder>(TweetDiffCallback()) {

    /**
     * Charger la vue de la cellule et son view holder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val listItem = TweetLineBinding.inflate(layoutInflater, parent, false)

        return ViewHolder(listItem)
    }

    /**
     * Envoyer/Alimenter/connecter la donnée dans la cellule
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Récupérer une donnée dans une List ou ArrayList
        val tweet = getItem(position)

        // Je connecte la donne à la vue de la cellule
        holder.listItem.tweet = tweet

        // Notifier le chargement de la cellule
        holder.listItem.executePendingBindings()
    }

    // Une classe interne pour définir la cellule/ligne afficher dans la liste
    class ViewHolder(val listItem : TweetLineBinding) : RecyclerView.ViewHolder(listItem.root) {

    }
}