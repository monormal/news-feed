//
//  ListViewModel.swift
//  NewsFeed
//
//  Created by iyyoon on 6/15/24.
//

import Alamofire
import Combine
import SwiftUI

class ListViewModel: ObservableObject {
    @Published var items = [ItemViewModel]()

    var dataService: DataProtocol
    var networkService: NetworkProtocol
    private var cancellableSet: Set<AnyCancellable> = []

    init() {
        self.dataService = DataService.shared
        self.networkService = NetworkService.shared
        fetchData()
    }

    private func loadData() {
        debugPrint("loadData")
        items = dataService.loadData().map { ItemViewModel(newsfeed: $0) }
    }

    private func fetchData() {
        networkService.getTopHeadlines().sink(receiveCompletion: { result in
            switch result {
            case .finished:
                debugPrint("Fetch Success")
            case .failure:
                debugPrint("Fetch Failed")
                self.loadData()
            }
        }, receiveValue: { response in
            let list = response.articles
            self.dataService.updateData(list: list)
            self.items = list.map { ItemViewModel(newsfeed: $0) }
        }).store(in: &cancellableSet)
    }
}
