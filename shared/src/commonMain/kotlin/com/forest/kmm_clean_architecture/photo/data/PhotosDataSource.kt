package com.forest.kmm_clean_architecture.photo.data

import forest.kmm_clean_architecture.db.ForestDatabase

class PhotosDataSource(private val database: ForestDatabase) {
    fun getAllPhotos(): List<PhotoRaw> =
        database.forestDatabaseQueries.selectAllPhotos(::mapToPhotoRaw).executeAsList()

    fun insertPhotos(articles: List<PhotoRaw>) {
        database.forestDatabaseQueries.transaction {
            articles.forEach { photoRaw ->
                insertPhoto(photoRaw)
            }
        }
    }

    fun clearPhotos() =
        database.forestDatabaseQueries.removeAllPhotos()

    private fun insertPhoto(photoRaw: PhotoRaw) {
        database.forestDatabaseQueries.insertPhoto(
            photoRaw.id,
            photoRaw.pageURL,
            photoRaw.type,
            photoRaw.tags,
            photoRaw.previewURL,
            photoRaw.previewWidth,
            photoRaw.previewHeight,
            photoRaw.webformatURL,
            photoRaw.webformatWidth,
            photoRaw.webformatHeight,
            photoRaw.largeImageURL,
            photoRaw.imageWidth,
            photoRaw.imageHeight,
            photoRaw.imageSize,
            photoRaw.views,
            photoRaw.downloads,
            photoRaw.collections,
            photoRaw.likes,
            photoRaw.comments,
            photoRaw.userId,
            photoRaw.user,
            photoRaw.userImageURL,
        )
    }

    private fun mapToPhotoRaw(
        id: Long?,
        pageURL: String?,
        type: String?,
        tags: String?,
        previewURL: String?,
        previewWidth: Long?,
        previewHeight: Long?,
        webformatURL: String?,
        webformatWidth: Long?,
        webformatHeight: Long?,
        largeImageURL: String?,
        imageWidth: Long?,
        imageHeight: Long?,
        imageSize: Long?,
        views: Long?,
        downloads: Long?,
        collections: Long?,
        likes: Long?,
        comments: Long?,
        userId: Long?,
        user: String?,
        userImageURL: String?,
    ): PhotoRaw =
        PhotoRaw(
            id,
            pageURL,
            type,
            tags,
            previewURL,
            previewWidth,
            previewHeight,
            webformatURL,
            webformatWidth,
            webformatHeight,
            largeImageURL,
            imageWidth,
            imageHeight,
            imageSize,
            views,
            downloads,
            collections,
            likes,
            comments,
            userId,
            user,
            userImageURL
        )
}