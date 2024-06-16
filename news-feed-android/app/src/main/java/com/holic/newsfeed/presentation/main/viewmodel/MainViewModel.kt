package com.holic.newsfeed.presentation.main.viewmodel


import androidx.lifecycle.viewModelScope
import com.holic.newsfeed.common.log.L
import com.holic.newsfeed.domain.UseCaseResult
import com.holic.newsfeed.domain.feed.NewsFeedUseCase
import com.holic.newsfeed.presentation.base.viewmodel.BaseViewModel
import com.holic.newsfeed.presentation.main.item.FeedItemMapper
import com.holic.newsfeed.presentation.main.item.list.FeedListItemViewModel
import com.holic.newsfeed.presentation.main.model.MainAction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: NewsFeedUseCase,
) : BaseViewModel() {
    private val itemList = mutableListOf<FeedListItemViewModel>()

    fun load() {
        fetchList()
    }

    private fun fetchList() {
        viewModelScope.launch(CoroutineExceptionHandler { _, throwable ->
            L.e(throwable)
        }) {
            when (val result = useCase.execute()) {
                is UseCaseResult.Success -> {
                    itemList.addAll(
                        FeedItemMapper.getItemList(
                            result.data,
                            eventNotifier = this@MainViewModel
                        )
                    )
                    notifyActionEvent(MainAction.UpdateList(itemList))
                }

                is UseCaseResult.Error -> {
                    L.e(result.error, result.message)
                }
            }
        }
    }
}