package com.holic.newsfeed.di

import android.content.Context
import com.holic.newsfeed.common.Property
import com.holic.newsfeed.data.local.NewsFeedStoreManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun provideNewsFeedStoreManager(@ApplicationContext context: Context) =
        NewsFeedStoreManager(
            context.getSharedPreferences(
                Property.SharedPreferences.NEWS_FEED_STORE,
                Context.MODE_PRIVATE
            )
        )
}