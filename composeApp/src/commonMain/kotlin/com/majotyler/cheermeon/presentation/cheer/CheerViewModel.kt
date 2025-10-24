package com.majotyler.cheermeon.presentation.cheer

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CheerViewModel : ViewModel() {
    private val _state = MutableStateFlow(value = CheerViewState(cheerText = ""))
    internal val state = _state.asStateFlow()

    internal fun onEvent(event: CheerViewEvent) {
        when (event) {
            is CheerViewEvent.CheerTextChanged -> onCheerTextChanged(event = event)
            is CheerViewEvent.ClickedSendCheerText -> onClickedSendCheerText()
        }
    }

    private fun onCheerTextChanged(event: CheerViewEvent.CheerTextChanged) {
        _state.update {
            it.copy(cheerText = event.changedTo)
        }
    }

    private fun onClickedSendCheerText() {

    }
}