package com.starter.message.ui

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.slack.circuit.runtime.CircuitUiState

@Stable
internal sealed interface MessageUiState : CircuitUiState {
  @Immutable data object Loading : MessageUiState

  @Immutable
  data class Loaded(
      val message: String,
      val eventSink: (MessageUiEvent) -> Unit,
  ) : MessageUiState
}
