//
//  ResponseModel.swift
//  NewsFeed
//
//  Created by iyyoon on 6/15/24.
//

import Foundation

struct ResponseModel: Decodable {
    let articles: [NewsFeed]
}
