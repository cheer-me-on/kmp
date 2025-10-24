package com.majotyler.cheermeon

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform