package com.starter.message.ui

import com.slack.circuit.runtime.CircuitUiEvent

internal sealed interface MessageUiEvent : CircuitUiEvent {
  data object NextClick : MessageUiEvent
}
