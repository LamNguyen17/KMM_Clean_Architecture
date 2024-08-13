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
        VStack (alignment: .leading) {
            HStack(alignment: .top) {
                VStack(alignment: .leading) {
                    KFImage(URL(string: photo.previewURL))
                        .placeholder {
                            ProgressView()
                        }
                        .resizable()
                        .cacheOriginalImage()
                        .cancelOnDisappear(true)
                        .aspectRatio(contentMode: .fill)
                        .frame(width: 100, height: 100) // Set the width and height
                        .cornerRadius(50) // Set the corner radius
                        .clipShape(RoundedRectangle(cornerRadius: 50))
                }
                .frame(maxWidth: 120, alignment: .leading)
                .padding([.leading], 12)
                   
                VStack(alignment: .leading) {
                    Text(photo.user)
                        .fontWeight(.bold)
                        .lineLimit(1)
                        .truncationMode(.tail)
                    
                    Text("Thẻ: \(photo.tags)")
                        .lineLimit(1)
                        .truncationMode(.tail)
                    
                    Text("Lượt thích: \(photo.likes)")
                        .lineLimit(1)
                        .truncationMode(.tail)
                    
                    Text("Bình luận: \(photo.comments)")
                        .lineLimit(1)
                        .truncationMode(.tail)
                }
                .frame(maxWidth: .infinity, alignment: .leading)
                .padding(.leading, 0)
                
                
            }.padding([.top, .bottom, .trailing], 16)
            
        }
        .background(Color.white)
        .frame(maxWidth: .infinity) // Make the VStack fill the width
        .cornerRadius(16)
        .shadow(radius: 5)
        .padding([.leading, .trailing], 12)
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

