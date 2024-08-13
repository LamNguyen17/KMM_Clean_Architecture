package com.forest.kmm_clean_architecture.photo.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PhotosResponse(
    @SerialName("total")
    val total: Int,
    @SerialName("totalHits")
    val totalHits: Int,
    @SerialName("hits")
    val hits: List<PhotoRaw>
)
