package com.starter.message.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
internal fun NextContent(
    uiState: NextUiState,
    modifier: Modifier = Modifier,
) {
  Box(
      contentAlignment = Alignment.Center,
      modifier = modifier.fillMaxSize(),
  ) {
    Text(text = uiState.content)
  }
}
