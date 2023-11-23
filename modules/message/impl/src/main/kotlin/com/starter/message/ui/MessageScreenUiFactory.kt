package com.starter.message.ui

import com.slack.circuit.runtime.CircuitContext
import com.slack.circuit.runtime.screen.Screen
import com.slack.circuit.runtime.ui.Ui
import com.slack.circuit.runtime.ui.ui
import javax.inject.Inject

internal class MessageScreenUiFactory @Inject constructor() : Ui.Factory {
  override fun create(screen: Screen, context: CircuitContext): Ui<*>? {
    return when (screen) {
      is MessageScreen -> messageContentUi()
      else -> null
    }
  }

  private fun messageContentUi() =
      ui<MessageUiState> { uiState, modifier ->
        MessageContent(
            uiState = uiState,
            modifier = modifier,
        )
      }
}
