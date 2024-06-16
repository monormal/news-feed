package com.holic.newsfeed.presentation.base.event

interface EventNotifier {
    fun notifyActionEvent(action: Action)
}
