//
//  ItemViewModel.swift
//  NewsFeed
//
//  Created by iyyoon on 6/15/24.
//

import SwiftUI

class ItemViewModel: ObservableObject, Identifiable {
    let id = UUID()
    
    @Published private(set) var isSelected: Bool = false
    
    let newsfeed: NewsFeed
    
    init(newsfeed: NewsFeed) {
        self.newsfeed = newsfeed
    }

    var title: String {
        return self.newsfeed.title
    }
    
    var imageUrl: String? {
        return self.newsfeed.urlToImage
    }
    
    var url: String {
        return self.newsfeed.url
    }
    
    var publishedAt: String {
        return self.newsfeed.publishedAt.toDateString()
    }
    
    func setSelected() {
        self.isSelected.on()
    }
}
