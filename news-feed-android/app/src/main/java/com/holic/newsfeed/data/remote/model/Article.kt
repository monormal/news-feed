package com.holic.newsfeed.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.Date

@JsonClass(generateAdapter = true)
data class Article(
    @field:Json(name = "title")
    val title: String? = null,

    @field:Json(name = "url")
    val url: String? = null,

    @field:Json(name = "urlToImage")
    val image: String? = null,

    @field:Json(name = "publishedAt")
    val datetime: Date? = null,
)