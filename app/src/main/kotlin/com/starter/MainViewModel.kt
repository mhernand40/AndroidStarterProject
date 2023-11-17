package com.starter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.starter.ui.MessageUiModel
import com.starter.ui.MessageUiModel.Loaded
import com.starter.ui.MessageUiModel.Loading
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
internal class MainViewModel @Inject constructor() : ViewModel() {
  val uiModel: StateFlow<MessageUiModel> =
      flow<MessageUiModel> {
            delay(2.seconds)
            emit(Loaded(message = "Hello World!"))
          }
          .stateIn(
              scope = viewModelScope,
              started = SharingStarted.WhileSubscribed(),
              initialValue = Loading,
          )
}
