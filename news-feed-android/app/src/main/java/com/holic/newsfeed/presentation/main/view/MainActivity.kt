package com.holic.newsfeed.presentation.main.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.holic.newsfeed.common.livedata.observeHandledEvent
import com.holic.newsfeed.databinding.ActivityMainBinding
import com.holic.newsfeed.presentation.base.event.Action
import com.holic.newsfeed.presentation.detail.view.DetailActivity
import com.holic.newsfeed.presentation.main.model.MainAction
import com.holic.newsfeed.presentation.main.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater).apply {
            lifecycleOwner = this@MainActivity
            viewModel = this@MainActivity.viewModel
        }
    }

    private val listAdapter by lazy { FeedListAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        initView()
        initObserver()
        viewModel.load()
    }

    private fun initView() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.container) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.list.recyclerView.adapter = listAdapter
    }

    private fun initObserver() {
        observeHandledEvent(viewModel.event.action) {
            handleActionEvent(it)
        }
    }

    private fun handleActionEvent(action: Action) {
        when (action) {
            is MainAction.UpdateList -> {
                listAdapter.clear()
                listAdapter.addAll(action.itemList)
            }

            is MainAction.SelectItem -> {
                moveToDetail(action.item.newsFeed.url)
            }
        }
    }

    private fun moveToDetail(url: String) {
        DetailActivity.start(this, url)
    }
}