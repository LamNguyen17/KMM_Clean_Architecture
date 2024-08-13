package com.forest.kmm_clean_architecture.photo.data

import com.forest.kmm_clean_architecture.common.ApiGateway
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class PhotosService(private val httpClient: HttpClient, private val api: ApiGateway) {
    private val page = 1
    private val apiKey = "10378494-67ad2479ecf48567970bc1f0e"

    suspend fun fetchPhotos(): List<PhotoRaw> {
        val response: PhotosResponse =
            httpClient.get("https://pixabay.com/api/?key=$apiKey&page=$page&per_page=20")
                .body()
        return response.hits
    }
}