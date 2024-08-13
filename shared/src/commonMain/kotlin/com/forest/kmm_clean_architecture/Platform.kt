package com.forest.kmm_clean_architecture

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform