package com.holic.newsfeed.common.util

import com.holic.newsfeed.BuildConfig


object BuildTypeUtil {

    fun isDevelopMode(): Boolean = BuildConfig.BUILD_TYPE == "debug"

    fun isReleaseMode(): Boolean = isDevelopMode().not()
}