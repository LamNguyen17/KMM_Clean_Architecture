package com.forest.kmm_clean_architecture.di

import com.forest.kmm_clean_architecture.di.networkModule
import com.forest.kmm_clean_architecture.photo.di.photosModule

val sharedKoinModules = listOf(
    photosModule,
    networkModule
)