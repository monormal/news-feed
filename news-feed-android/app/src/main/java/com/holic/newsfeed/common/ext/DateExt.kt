@file:Suppress("NOTHING_TO_INLINE")

package com.holic.newsfeed.common.ext

import com.holic.newsfeed.common.datetime.DateTimePattern
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

inline fun Date?.toFormatString(
    pattern: String = DateTimePattern.KOREAN_FULL_DATE_TIME
): String? = try {
    this?.let { SimpleDateFormat(pattern, Locale.KOREA).format(it) }
} catch (e: Exception) {
    null
}