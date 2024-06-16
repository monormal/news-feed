//
//  Optional+Extension.swift
//  NewsFeed
//
//  Created by iyyoon on 6/15/24.
//

import Foundation

extension Optional {
    func unwrap(defaultValue: Wrapped) -> Wrapped {
        guard let self = self else {
            return defaultValue
        }
        return self
    }
}
