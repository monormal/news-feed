//
//  ContentView.swift
//  NewsFeed
//
//  Created by iyyoon on 6/15/24.
//

import SwiftUI

struct ContentView: View {
    @StateObject var viewModel: ListViewModel = .init()

    @State private var columnCount = 1

    var columns: [GridItem] { Array(repeating: GridItem(.flexible()), count: columnCount) }

    var body: some View {
        NavigationStack {
            ScrollView {
                LazyVGrid(columns: columns, spacing: 20) {
                    ForEach(viewModel.items, id: \.id) { item in
                        NavigationLink(destination: FeedDetailView(item: item)
                            .onAppear { item.setSelected() })
                        {
                            ListItemView(item: item)
                        }
                    }
                }
                .padding(.horizontal)
            }
            .navigationTitle("NewsFeed")
        }.onAppear {
            setColumnCount(orientation: UIDevice.current.orientation)
        }.onRotate { orientation in
            setColumnCount(orientation: orientation)
        }
    }

    private func setColumnCount(orientation: UIDeviceOrientation) {
        switch orientation {
        case .portrait:
            columnCount = 1
        case .landscapeLeft, .landscapeRight:
            columnCount = 3
        default:
            break
        }
    }
}

#Preview {
    ContentView()
}
