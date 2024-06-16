package com.holic.newsfeed.presentation.detail.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.holic.newsfeed.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private val binding: ActivityDetailBinding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }

    private val url by lazy { intent?.getStringExtra(URL).orEmpty() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.container) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        with(binding.webView) {
            webViewClient = WebViewClient()
            with(settings) {
                cacheMode = android.webkit.WebSettings.LOAD_NO_CACHE
                setSupportMultipleWindows(false)
                javaScriptEnabled = true
                javaScriptCanOpenWindowsAutomatically = true
                loadWithOverviewMode = true
                useWideViewPort = true
                domStorageEnabled = true
                builtInZoomControls = false

                mixedContentMode = android.webkit.WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
            }

            android.webkit.CookieManager.getInstance().apply {
                setAcceptCookie(true)
                setAcceptThirdPartyCookies(binding.webView, true)
            }

            loadUrl(this@DetailActivity.url)
        }
    }

    companion object {
        private const val URL = "url"

        fun start(
            context: Context,
            url: String,
        ) {
            val intent = Intent(context, DetailActivity::class.java).apply {
                putExtra(URL, url)
            }
            context.startActivity(intent)
        }
    }

}