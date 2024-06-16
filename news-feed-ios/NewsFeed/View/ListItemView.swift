//
//  ListItemView.swift
//  NewsFeed
//
//  Created by iyyoon on 6/15/24.
//

import Kingfisher
import SwiftUI

struct ListItemView: View {
    @ObservedObject var item: ItemViewModel

    var body: some View {
        HStack {
            VStack(alignment: .leading) {
                KFImage(URL(string: item.imageUrl.orEmpty()))
                    .cancelOnDisappear(true)
                    .placeholder {
                        Rectangle().fill(Color.gray)
                    }
                    .resizable()
                    .scaledToFit()
                    .cornerRadius(8)

                Text(item.title)
                    .lineLimit(nil)
                    .font(.title3)
                    .foregroundColor(item.isSelected ? .red : .black)
                    .padding(.top)
                    .padding(.bottom)

                Text(item.publishedAt)
                    .foregroundColor(.secondary)
                    .lineLimit(1)
                    .padding(.top)
            }
        }
    }
}
