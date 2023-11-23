package com.starter.message.ui

import androidx.compose.runtime.Immutable
import com.slack.circuit.runtime.CircuitUiState

@Immutable internal data class NextUiState(val content: String) : CircuitUiState
