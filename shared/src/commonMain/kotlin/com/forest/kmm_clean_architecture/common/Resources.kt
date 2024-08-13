package com.forest.kmm_clean_architecture.common

import kotlinx.serialization.Serializable

@Serializable
sealed class Resources<T> {
    @Serializable
    data class Success<T>(val data: T?) : Resources<T>()

    @Serializable
    data class Error<T>(val message: String, val data: T? = null) : Resources<T>()

    @Serializable
    data class Loading<T>(val isLoading: Boolean = true) : Resources<T>()
}