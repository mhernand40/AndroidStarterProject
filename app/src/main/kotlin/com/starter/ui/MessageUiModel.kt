package com.starter.ui

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable

@Stable
internal sealed interface MessageUiModel {
  @Immutable data object Loading : MessageUiModel

  @Immutable @JvmInline value class Loaded(val message: String) : MessageUiModel
}
