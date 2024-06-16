package com.holic.newsfeed.data.local

import android.content.SharedPreferences
import com.holic.newsfeed.common.log.L
import com.holic.newsfeed.core.model.NewsFeed
import com.holic.newsfeed.data.local.model.NewsFeedList
import com.squareup.moshi.Moshi
import javax.inject.Inject

class NewsFeedStoreManager @Inject constructor(
    private val preferences: SharedPreferences
) {
    private val jsonAdapter = Moshi.Builder().build().adapter(NewsFeedList::class.java)

    fun get(): MutableList<NewsFeed> =
        preferences.getString(NAME, null)?.asMediaKeys()?.list?.toMutableList()
            ?: mutableListOf()

    fun put(list: List<NewsFeed>) =
        preferences.edit().putString(NAME, list.asJsonString()).apply()

    fun clear() = preferences.edit().clear().apply()

    private fun String.asMediaKeys(): NewsFeedList? {
        return try {
            jsonAdapter.fromJson(this)
        } catch (e: Exception) {
            L.e(e)
            null
        }
    }

    private fun List<NewsFeed>.asJsonString(): String? {
        return try {
            jsonAdapter.toJson(NewsFeedList(this))
        } catch (e: Exception) {
            L.e(e)
            null
        }
    }

    companion object {
        private const val NAME = "news_feed_list"
    }
}