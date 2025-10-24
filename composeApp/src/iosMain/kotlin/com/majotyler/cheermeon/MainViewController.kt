package com.majotyler.cheermeon

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.majotyler.cheermeon.presentation.cheer.CheerScreen
import com.majotyler.cheermeon.presentation.cheer.CheerViewModel

fun MainViewController() = ComposeUIViewController {
    val vm = remember { CheerViewModel() }
    CheerScreen(viewModel = vm)
}