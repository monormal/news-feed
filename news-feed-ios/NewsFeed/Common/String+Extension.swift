//
//  String+Extension.swift
//  NewsFeed
//
//  Created by iyyoon on 6/15/24.
//

import Foundation

extension String {
    func toDateString() -> String {
        let df = DateFormatter()
        df.dateFormat = "yyyy-MM-dd'T'HH:mm:ssZ"
        df.timeZone = .current
        if let date = df.date(from: self) {
            df.dateStyle = .medium
            df.timeStyle = .medium
            return df.string(from: date)
        } else {
            return ""
        }
    }
}

extension String? {
    func orEmpty() -> String {
        return self.unwrap(defaultValue: "")
    }
}
