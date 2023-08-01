package com.example.tptwitter

import com.example.tptwitter.TwitterService.Companion.retrofit
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface TwitterService {

    companion object {
        // L'url racine de l'api
        val BASE_URL = "https://raw.githubusercontent.com/Chocolaterie/EniWebService/main/api/"

        // Préparer l'utilitaire qui va permettre de mapper le JSON en Objet
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

        // Utilitaire retrofit
        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .build()
    }

    @GET("tweets.json")
    suspend fun getTweets() : List<Tweet>
}

object TweetApi {
    val retrofitService : TwitterService by lazy { retrofit.create(TwitterService::class.java) }
}