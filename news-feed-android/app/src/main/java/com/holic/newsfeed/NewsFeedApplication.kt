package com.holic.newsfeed

import android.app.Application
import com.holic.newsfeed.common.log.L
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NewsFeedApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        L.init()
    }
}