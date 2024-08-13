package com.forestt176.kmm_clean_architecture.di

import com.forestt176.kmm_clean_architecture.article.presentation.ArticlesViewModel
import com.forestt176.kmm_clean_architecture.profile.presentation.ProfileViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

fun initKoin() {
    val modules = sharedKoinModules + databaseModule
    startKoin {
        modules(modules)
    }
}

class ArticlesInjector : KoinComponent {
    val articlesViewModel: ArticlesViewModel by inject()
}

class ProfileInjector : KoinComponent {
    val profileViewModel: ProfileViewModel by inject()
}