//
//  FeedDetail.swift
//  NewsFeed
//
//  Created by iyyoon on 6/15/24.
//

import SwiftUI

struct FeedDetailView: View {
    var item: ItemViewModel

    var body: some View {
        WebViewContainer(url: item.url)
            .navigationTitle(item.title)
            .navigationBarTitleDisplayMode(.inline)
    }
}
