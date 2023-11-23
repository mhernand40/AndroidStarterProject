package com.starter.message.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.starter.message.ui.MessageUiState.Loaded
import com.starter.message.ui.MessageUiState.Loading

@Composable
internal fun MessageContent(
    uiState: MessageUiState,
    modifier: Modifier = Modifier,
) {
  Box(
      contentAlignment = Alignment.Center,
      modifier = modifier.fillMaxSize(),
  ) {
    when (uiState) {
      is Loading -> CircularProgressIndicator()
      is Loaded ->
          Column {
            Text(text = uiState.message)
            Button(
                onClick = { uiState.eventSink(MessageUiEvent.NextClick) },
                content = { Text(text = "Next") },
            )
          }
    }
  }
}

@Preview(showBackground = true)
@Composable
private fun MessageContentPreview_Loading() {
  MessageContent(uiState = Loading)
}

@Preview(showBackground = true)
@Composable
private fun MessageContentPreview_Loaded() {
  MessageContent(uiState = Loaded(message = "Hello World!", eventSink = {}))
}
