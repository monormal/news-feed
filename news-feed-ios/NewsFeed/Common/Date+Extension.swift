//
//  Date+Extension.swift
//  NewsFeed
//
//  Created by iyyoon on 6/15/24.
//

import Foundation

extension Date {
    func toString() -> String{
        let df = DateFormatter()
        df.dateFormat = "yyyy-MM-dd'T'HH:mm:ssZ"
        df.timeZone = TimeZone.current
        df.dateStyle = .medium
        df.timeStyle = .short
        let dateString = df.string(from: self)
        return dateString
    }
}

