package com.majotyler.cheermeon.presentation.cheer

import androidx.compose.runtime.Immutable

@Immutable
internal sealed interface CheerViewEvent {
    data class CheerTextChanged(val changedTo: String) : CheerViewEvent
    data object ClickedSendCheerText : CheerViewEvent
}