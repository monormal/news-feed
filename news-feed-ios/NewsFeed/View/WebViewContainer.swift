//
//  WebView.swift
//  NewsFeed
//
//  Created by iyyoon on 6/15/24.
//

import SwiftUI
import WebKit

struct WebViewContainer: UIViewRepresentable {
    var url: String

    func makeUIView(context: Context) -> WKWebView {
        guard let url = URL(string: url) else {
            return WKWebView()
        }

        let webView = WKWebView()
        webView.load(URLRequest(url: url))
        return webView
    }

    func updateUIView(_ uiView: WKWebView, context: UIViewRepresentableContext<WebViewContainer>) {}
}

struct WebViewContainer_Previews: PreviewProvider {
    static var previews: some View {
        WebViewContainer(url: "https://www.google.com")
    }
}
