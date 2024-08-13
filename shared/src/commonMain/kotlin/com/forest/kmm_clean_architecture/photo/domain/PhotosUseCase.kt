package com.forest.kmm_clean_architecture.photo.domain

import com.forest.kmm_clean_architecture.photo.data.PhotoRaw
import com.forest.kmm_clean_architecture.photo.data.PhotosRepository

class PhotosUseCase(private val repo: PhotosRepository) {

    suspend fun getPhotos(forceFetch: Boolean): List<Photo> {
        val photosRaw = repo.getPhotos(forceFetch)
        return mapPhotos(photosRaw)
    }
    private fun mapPhotos(photosRaw: List<PhotoRaw>): List<Photo> = photosRaw.map { raw ->
        Photo(
            raw.id ?: -1,
            raw.pageURL ?: "Click to find out more",
            raw.type ?: "",
            raw.tags ?: "",
            raw.previewURL ?: "https://cdn.pixabay.com/photo/2024/08/07/21/57/giraffe-8953172_150.jpg",
            raw.previewWidth ?: 150,
            raw.previewHeight ?: 150,
            raw.webformatURL ?: "https://cdn.pixabay.com/photo/2024/08/07/21/57/giraffe-8953172_150.jpg",
            raw.webformatWidth ?: 150,
            raw.webformatHeight ?: 150,
            raw.largeImageURL ?: "https://cdn.pixabay.com/photo/2024/08/07/21/57/giraffe-8953172_150.jpg",
            raw.imageWidth ?: 150,
            raw.imageHeight ?: 150,
            raw.imageSize ?: 150,
            raw.views ?: 0,
            raw.downloads ?: 0,
            raw.collections ?: 0,
            raw.likes ?: 0,
            raw.comments ?: 0,
            raw.userId ?: 0,
            raw.user ?: "Unknown",
            raw.userImageURL ?: "https://cdn.pixabay.com/photo/2024/08/07/21/57/giraffe-8953172_150.jpg",
        )
    }
}