package com.forest.kmm_clean_architecture.photo.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
data class PhotoRaw(
    @SerialName("id")
    val id: Long?,
    @SerialName("pageURL")
    val pageURL: String?,
    @SerialName("type")
    val type: String?,
    @SerialName("tags")
    val tags: String?,
    @SerialName("previewURL")
    val previewURL: String?,
    @SerialName("previewWidth")
    val previewWidth: Long?,
    @SerialName("previewHeight")
    val previewHeight: Long?,
    @SerialName("webformatURL")
    val webformatURL: String?,
    @SerialName("webformatWidth")
    val webformatWidth: Long?,
    @SerialName("webformatHeight")
    val webformatHeight: Long?,
    @SerialName("largeImageURL")
    val largeImageURL: String?,
    @SerialName("imageWidth")
    val imageWidth: Long?,
    @SerialName("imageHeight")
    val imageHeight: Long?,
    @SerialName("imageSize")
    val imageSize: Long?,
    @SerialName("views")
    val views: Long?,
    @SerialName("downloads")
    val downloads: Long?,
    @SerialName("collections")
    val collections: Long?,
    @SerialName("likes")
    val likes: Long?,
    @SerialName("comments")
    val comments: Long?,
    @SerialName("user_id")
    val userId: Long?,
    @SerialName("user")
    val user: String?,
    @SerialName("userImageURL")
    val userImageURL: String?,
)