package com.forest.kmm_clean_architecture.photo.presentation

import com.forest.kmm_clean_architecture.photo.domain.Photo

data class PhotosState (
    val photos: List<Photo> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)