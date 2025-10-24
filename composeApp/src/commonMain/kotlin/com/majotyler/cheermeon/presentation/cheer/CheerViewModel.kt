package com.majotyler.cheermeon.presentation.cheer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.majotyler.cheermeon.domain.MessagesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CheerViewModel(
    private val messagesRepository: MessagesRepository,
) : ViewModel() {
    private val _state = MutableStateFlow(
        value = CheerViewState(
            cheerText = "",
            pendingCheer = false,
        )
    )
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
        viewModelScope.launch {
            try {
                messagesRepository.sendText(
                    from = "Test",
                    text = _state.value.cheerText,
                )
                println("Success.")
            } catch (e: Exception) {
                println("Error $e")
            } finally {
                _state.update {
                    it.copy(
                        pendingCheer = false,
                    )
                }
            }
        }

        _state.update {
            it.copy(
                cheerText = "",
                pendingCheer = true,
            )
        }
    }
}