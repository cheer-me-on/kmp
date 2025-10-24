package com.majotyler.cheermeon.data

import com.majotyler.cheermeon.domain.MessagesRepository
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.auth
import dev.gitlive.firebase.firestore.firestore

class MessagesRepositoryImpl : MessagesRepository {
    override suspend fun sendText(from: String, text: String) {

        /** TODO (Tyler):
         * Very unideal. Have to figure out where to move this.
         * Without this there is a permission RTE. */
        Firebase.auth.signInAnonymously()

        val ref = Firebase.firestore.collection("messages").document

        ref.set(
            mapOf(
                "from" to from,
                "type" to "text",
                "text" to text,
            )
        )
    }
}