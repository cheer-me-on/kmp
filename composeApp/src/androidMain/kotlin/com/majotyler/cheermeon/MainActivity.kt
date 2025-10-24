package com.majotyler.cheermeon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.google.firebase.FirebaseApp
import com.majotyler.cheermeon.data.MessagesRepositoryImpl
import com.majotyler.cheermeon.presentation.cheer.CheerScreen
import com.majotyler.cheermeon.presentation.cheer.CheerViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()

        super.onCreate(savedInstanceState)

        setContent {
            CheerScreen(
                viewModel = CheerViewModel(
                    messagesRepository = MessagesRepositoryImpl(),
                )
            )
        }
    }
}