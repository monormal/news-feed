//
//  NetworkService.swift
//  NewsFeed
//
//  Created by iyyoon on 6/15/24.
//

import Alamofire
import Combine
import Foundation

enum NetworkErrors: Error {
    case urlErxror
    case responseError
    case decoderError
    case unknownError
}

struct NetworkError: Error {
    let initialError: AFError
    let backendError: BackendError?
}

struct BackendError: Codable, Error {
    var status: String
    var message: String
}

protocol NetworkProtocol {
    func getTopHeadlines() -> AnyPublisher<ResponseModel, NetworkErrors>
}

class NetworkService {
    static let shared = NetworkService()
    private init() {}
}

extension NetworkService: NetworkProtocol {
    func getTopHeadlines() -> AnyPublisher<ResponseModel, NetworkErrors> {
        let url = "https://newsapi.org/v2/top-headlines?country=kr&apiKey=99e55d2f2f114ba6b2e980eaecfe6097"

        return AF.request(url)
            .publishDecodable(type: ResponseModel.self)
            .value()
            .mapError { _ in NetworkErrors.unknownError }
            .eraseToAnyPublisher()
    }
}
