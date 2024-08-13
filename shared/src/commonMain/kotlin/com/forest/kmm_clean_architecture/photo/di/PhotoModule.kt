package com.forest.kmm_clean_architecture.photo.di


import com.forest.kmm_clean_architecture.photo.data.PhotosService
import com.forest.kmm_clean_architecture.photo.data.PhotosDataSource
import com.forest.kmm_clean_architecture.photo.data.PhotosRepository
import com.forest.kmm_clean_architecture.photo.domain.PhotosUseCase
import com.forest.kmm_clean_architecture.photo.presentation.PhotosViewModel
import org.koin.dsl.module

val photosModule = module {
    single<PhotosService> { PhotosService(get(), get()) }
    single<PhotosUseCase> { PhotosUseCase(get()) }
    single<PhotosViewModel> { PhotosViewModel(get()) }
    single<PhotosDataSource> { PhotosDataSource(get()) }
    single<PhotosRepository> { PhotosRepository(get(), get()) }
}