package com.forest.kmm_clean_architecture.di

import com.forest.kmm_clean_architecture.photo.presentation.PhotosViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

fun initKoin() {
    val modules = sharedKoinModules + databaseModule
    startKoin {
        modules(modules)
    }
}

class PhotosInjector : KoinComponent {
    val photosViewModel: PhotosViewModel by inject()
}