package com.forest.kmm_clean_architecture.article.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticlesResponse(
    @SerialName("status")
    val status: String,
    @SerialName("totalResults")
    val results: Int,
    @SerialName("articles")
    val articles: List<ArticleRaw>
)

@Serializable
data class ProfileResponse(
    @SerialName("id")
    val id: Int?,
    @SerialName("email")
    val email: String?,
    @SerialName("full_name")
    val fullName: String?,
    @SerialName("phone")
    val phone: String?,
    @SerialName("avatar")
    val avatar: Int?,
    @SerialName("avatar_url")
    val avatarUrl: String?
)