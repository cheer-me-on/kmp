package com.majotyler.cheermeon.domain

interface MessagesRepository {
    suspend fun sendText(
        from: String,
        text: String,
    )
}