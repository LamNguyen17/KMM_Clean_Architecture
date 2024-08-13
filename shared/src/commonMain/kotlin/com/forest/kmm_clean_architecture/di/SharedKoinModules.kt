package com.forest.kmm_clean_architecture.di

import com.forest.kmm_clean_architecture.di.networkModule
import com.forest.kmm_clean_architecture.article.di.articlesModule
import com.forest.kmm_clean_architecture.photo.di.photosModule

val sharedKoinModules = listOf(
    articlesModule,
    photosModule,
    networkModule
)