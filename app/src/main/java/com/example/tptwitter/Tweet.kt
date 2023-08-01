package com.example.tptwitter

import com.squareup.moshi.Json

class Tweet(@Json(name="id") var id: Int,
            @Json(name="author") var author: String,
            @Json(name="message") var message :String) {
}