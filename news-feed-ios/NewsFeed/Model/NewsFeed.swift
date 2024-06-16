//
//  NewsFeed.swift
//  NewsFeed
//
//  Created by iyyoon on 6/15/24.
//

import Foundation

struct NewsFeed: Codable {
    let title: String
    let url: String
    let urlToImage: String?
    let publishedAt: String
}
