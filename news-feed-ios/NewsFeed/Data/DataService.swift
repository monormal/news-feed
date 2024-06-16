//
//  DataService.swift
//  NewsFeed
//
//  Created by iyyoon on 6/15/24.
//

import CoreData
import Foundation

protocol DataProtocol {
    func updateData(list: [NewsFeed])
    func loadData() -> [NewsFeed]
}

class DataService: DataProtocol {
    static let shared = DataService()
    private init() {}
    
    lazy var persistentContainer: NSPersistentContainer = {
        /*
         The persistent container for the application. This implementation
         creates and returns a container, having loaded the store for the
         application to it. This property is optional since there are legitimate
         error conditions that could cause the creation of the store to fail.
         */
        let container = NSPersistentContainer(name: "NewsFeed")
        container.loadPersistentStores(completionHandler: { (storeDescription, error) in
            if let error = error as NSError? {
                // Replace this implementation with code to handle the error appropriately.
                // fatalError() causes the application to generate a crash log and terminate. You should not use this function in a shipping application, although it may be useful during development.
                
                /*
                 Typical reasons for an error here include:
                 * The parent directory does not exist, cannot be created, or disallows writing.
                 * The persistent store is not accessible, due to permissions or data protection when the device is locked.
                 * The device is out of space.
                 * The store could not be migrated to the current model version.
                 Check the error message to determine what the actual problem was.
                 */
                fatalError("Unresolved error \(error), \(error.userInfo)")
            }
        })
        return container
    }()
    
    private lazy var viewContext = self.persistentContainer.viewContext
    
    func updateData(list: [NewsFeed]) {
        clearData()
        saveData(list: list)
        saveContext()
    }
    
    func loadData() -> [NewsFeed] {
        let fetchRequest = FeedData.fetchRequest()
        fetchRequest.sortDescriptors = [NSSortDescriptor(keyPath: \FeedData.publishedAt, ascending: false)]
        
        do {
            let objects = try viewContext.fetch(fetchRequest) as [FeedData]
            return objects.map { data in
                NewsFeed.from(feedData: data)
            }
        } catch {
            return []
        }
    }
    
    private func saveData(list: [NewsFeed]) {
        _ = list.map { newsFeed in
            newsFeed.apply(feedData: FeedData(context: viewContext))
        }
        
    }
    
    private func clearData() {
        do {
            let fetchRequest = NSFetchRequest<NSFetchRequestResult>(entityName: String(describing: FeedData.self))
            do {
                let objects  = try viewContext.fetch(fetchRequest) as? [NSManagedObject]
                _ = objects.map{$0.map{viewContext.delete($0)}}
            } catch _ {
                
            }
        }
    }
    
    private func saveContext() {
        if viewContext.hasChanges {
            do {
                try viewContext.save()
            } catch _ {
                
            }
        }
    }
}

private extension NewsFeed {
    
    static func from(feedData: FeedData) -> NewsFeed {
        return NewsFeed(
            title: feedData.title.orEmpty(),
            url: feedData.url.orEmpty(),
            urlToImage: feedData.urlToImage.orEmpty(),
            publishedAt: feedData.publishedAt.orEmpty()
        )
    }
    
    func apply(feedData: FeedData) -> FeedData {
        feedData.title = self.title
        feedData.url = self.url
        feedData.urlToImage = self.urlToImage
        feedData.publishedAt = self.publishedAt
        return feedData
    }
}
