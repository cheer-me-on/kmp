package com.majotyler.cheermeon.presentation.cheer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun CheerScreen(
    viewModel: CheerViewModel,
) {
    val state = viewModel.state.collectAsState()

    CheerContent(
        cheerText = state.value.cheerText,
        pendingCheer = state.value.pendingCheer,
        onEvent = { viewModel.onEvent(it) },
    )
}

@Composable
private fun CheerContent(
    cheerText: String,
    pendingCheer: Boolean,
    onEvent: (CheerViewEvent) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding(),
        verticalArrangement = Arrangement.Center,
    ) {
        TextField(
            enabled = pendingCheer.not(),
            value = cheerText,
            onValueChange = {
                onEvent(
                    CheerViewEvent.CheerTextChanged(changedTo = it),
                )
            }
        )
        Button(
            enabled = pendingCheer.not(),
            onClick = { onEvent(CheerViewEvent.ClickedSendCheerText) },
        ) {
            Text(
                text = "Send Cheer",
            )
        }
    }
}