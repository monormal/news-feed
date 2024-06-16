package com.holic.newsfeed.common.log

import com.holic.newsfeed.common.util.BuildTypeUtil
import timber.log.Timber

/**
 * Logger
 *
 * Timber wrapper
 */
@Suppress("NOTHING_TO_INLINE", "unused")
object L {

    fun init() {
        if (BuildTypeUtil.isDevelopMode()) {
            Timber.plant(Timber.DebugTree())
        }
    }

    inline fun v(message: String?) {
        Timber.v(message)
    }


    inline fun d(message: String?) {
        Timber.d(message)
    }


    inline fun d(throwable: Throwable?) {
        Timber.d(throwable)
    }

    inline fun d(throwable: Throwable, message: String?) {
        Timber.d(throwable, message)
    }

    inline fun i(message: String?) {
        Timber.i(message)
    }


    inline fun w(message: String?) {
        Timber.w(message)
    }

    inline fun e(message: String?) {
        Timber.e(message)
    }

    inline fun e(throwable: Throwable?) {
        Timber.e(throwable)
    }

    inline fun e(throwable: Throwable?, message: String?) {
        Timber.e(throwable, message)

    }
}