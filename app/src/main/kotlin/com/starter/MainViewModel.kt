package com.starter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.starter.message.model.MessageRepository
import com.starter.ui.MessageUiModel
import com.starter.ui.MessageUiModel.Loaded
import com.starter.ui.MessageUiModel.Loading
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
internal class MainViewModel
@Inject
constructor(
    private val messageRepository: MessageRepository,
) : ViewModel() {
  val uiModel: StateFlow<MessageUiModel> =
      flow { emit(Loaded(message = messageRepository.getMessage())) }
          .stateIn(
              scope = viewModelScope,
              started = SharingStarted.WhileSubscribed(),
              initialValue = Loading,
          )
}
