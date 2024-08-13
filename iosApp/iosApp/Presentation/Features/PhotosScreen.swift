//
//  PhotosScreen.swift
//  iosApp
//
//  Created by Lam Nguyen Tuan on 13/8/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared
import Kingfisher

extension PhotosScreen {
    
    @MainActor
    class PhotosViewModelWrapper: ObservableObject {
        let photosViewModel: PhotosViewModel
        @Published var photosState: PhotosState
        
        init() {
            photosViewModel = PhotosInjector().photosViewModel
            photosState = photosViewModel.photosState.value as! PhotosState
        }
        
        func startObserving() {
            Task {
                self.photosState = photosViewModel.photosState.value as! PhotosState
            }
        }
    }
}

struct PhotosScreen: View {
    @ObservedObject private(set) var viewModel: PhotosViewModelWrapper
    
    
    var body: some View {
        VStack {
            AppBar()
            
            if viewModel.photosState.loading {
                Loader()
            }
            
            if let error = viewModel.photosState.error {
                ErrorMessage(message: error)
            }
            
            if(!viewModel.photosState.photos.isEmpty) {
                ScrollView {
                    LazyVStack(spacing: 10) {
                        ForEach(viewModel.photosState.photos, id: \.self) { photo in
                            PhotoItemView(photo: photo)
                        }
                    }
                }
            }
        }
        .onAppear{
            self.viewModel.startObserving()
        }
        .refreshable {
            self.viewModel.startObserving()
        }
    }
}

struct AppBar: View {
    var body: some View {
        Text("Photos")
            .font(.largeTitle)
            .fontWeight(.bold)
    }
}

struct PhotoItemView: View {
    var photo: Photo
    
    var body: some View {
        
        VStack(alignment: .leading, spacing: 8) {
            KFImage(URL(string: photo.previewURL))
                .placeholder {
                    ProgressView()
                }
                .resizable()
                .cacheOriginalImage()
                .cancelOnDisappear(true)
                .cornerRadius(20)
                .aspectRatio(contentMode: .fit)
//                 .frame(maxWidth: .infinity, maxHeight: 200)
            
            Text("\(photo.user)")
                .font(.title)
                .fontWeight(.bold)
//            Text("Thẻ: \(String(describing: {photo.tags}))")
//            Text("Lượt thích: \(photo.likes)")
//            Text("Bình luận: \(photo.comments)")
        }
        .padding(16)
        
    }
}

struct Loader: View {
    var body: some View {
        ProgressView()
    }
}

struct ErrorMessage: View {
    var message: String
    
    var body: some View {
        Text(message)
            .font(.title)
    }
}

