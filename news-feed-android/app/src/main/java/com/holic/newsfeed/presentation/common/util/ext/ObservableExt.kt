package com.holic.newsfeed.presentation.common.util.ext

import androidx.databinding.ObservableBoolean

fun ObservableBoolean.on() = set(true)

fun ObservableBoolean.off() = set(false)
