package com.forest.kmm_clean_architecture.article.presentation

import com.forest.kmm_clean_architecture.article.domain.Article

data class ArticlesState (
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)