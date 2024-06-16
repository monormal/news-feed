package com.holic.newsfeed.di

import com.holic.newsfeed.data.local.NewsFeedStoreManager
import com.holic.newsfeed.data.remote.HeadlineApi
import com.holic.newsfeed.data.respository.feed.NewsFeedRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideNewsFeedRepository(
        api: HeadlineApi,
        manager: NewsFeedStoreManager
    ): NewsFeedRepository = NewsFeedRepository(api, manager)

}