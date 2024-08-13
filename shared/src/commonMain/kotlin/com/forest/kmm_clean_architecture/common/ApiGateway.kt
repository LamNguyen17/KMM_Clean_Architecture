package com.forest.kmm_clean_architecture.common

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.HttpRequestRetry
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.request.delete
import io.ktor.client.request.forms.MultiPartFormDataContent
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.content.PartData
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class ApiGateway {
    companion object {
        private val client = ApiGateway().createHttpClient()
    }

    private fun createHttpClient(): HttpClient {
        return HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.INFO
                println("Running on Logging")
            }
            install(HttpRequestRetry) {
                maxRetries = 3
                retryOnServerErrors(maxRetries)
                exponentialDelay()
            }

            install(HttpTimeout) {
                requestTimeoutMillis = 15_000
            }
            HttpResponseValidator {
                validateResponse { response ->
                    if (response.status == HttpStatusCode.Unauthorized) {
                        // Handle 401 Unauthorized
                        println("Unauthorized response. Handling token refresh...")
                    }
                }
            }
        }
    }

    suspend fun get(url: String): HttpResponse {
        val response: HttpResponse = client.get(url)
        return response
    }

    suspend fun post(url: String, body: String): HttpResponse {
        val response: HttpResponse = client.post(url) {
            setBody(body)
        }
        return response
    }

    suspend fun put(url: String, body: String): HttpResponse {
        val response: HttpResponse = client.put(url) {
            setBody(body)
        }
        return response
    }

    suspend fun delete(url: String): HttpResponse {
        val response: HttpResponse = client.delete(url)
        return response
    }

    suspend fun postMultipart(url: String, parts: List<PartData>): HttpResponse {
        val response: HttpResponse = client.post(url) {
            setBody(MultiPartFormDataContent(parts))
        }
        return response
    }

    suspend fun putMultipart(url: String, parts: List<PartData>): HttpResponse {
        val response: HttpResponse = client.put(url) {
            setBody(MultiPartFormDataContent(parts))
        }
        return response
    }
}