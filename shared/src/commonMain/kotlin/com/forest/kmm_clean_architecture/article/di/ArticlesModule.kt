package com.forest.kmm_clean_architecture.article.di

import com.forest.kmm_clean_architecture.article.data.ArticlesDataSource
import com.forest.kmm_clean_architecture.article.data.ArticlesRepository
import com.forest.kmm_clean_architecture.article.data.ArticlesService
import com.forest.kmm_clean_architecture.article.domain.ArticlesUseCase
import com.forest.kmm_clean_architecture.article.presentation.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {
    single<ArticlesService> { ArticlesService(get(), get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
    single<ArticlesDataSource> { ArticlesDataSource(get()) }
    single<ArticlesRepository> { ArticlesRepository(get(), get()) }
}