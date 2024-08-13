package com.forest.kmm_clean_architecture.di

import com.forest.kmm_clean_architecture.common.ApiGateway
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module
import io.ktor.client.engine.cio.*

val networkModule = module {
    single<ApiGateway> { ApiGateway() }
    single<HttpClient> {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
////            install(Logging) {
////                logger = Logger.DEFAULT
////                level = LogLevel.INFO
////                println("Running on Logging 1")
////            }
////            install(Auth) {
////                bearer {
////                    loadTokens {
////                        val accessToken = TokenManager.getAccessToken() ?: ""
////                        BearerTokens(accessToken, "")
////                    }
////                    println("BearerTokens")
////                }
////            }
//            install(HttpRequestRetry) {
//                maxRetries = 3
//                retryOnServerErrors(maxRetries)
//                exponentialDelay()
//            }
//
//            install(HttpTimeout) {
//                requestTimeoutMillis = 15_000
//            }
//            HttpResponseValidator {
//                validateResponse { response ->
//                    if (response.status == HttpStatusCode.Unauthorized) {
//                        // Handle 401 Unauthorized
//                        println("Unauthorized response. Handling token refresh...")
//                    }
//                }
//            }
        }
    }
}