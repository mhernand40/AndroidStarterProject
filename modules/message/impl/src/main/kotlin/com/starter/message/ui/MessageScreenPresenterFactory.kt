package com.starter.message.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.slack.circuit.retained.rememberRetained
import com.slack.circuit.runtime.CircuitContext
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.screen.Screen
import com.starter.message.model.MessageRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import javax.inject.Inject

internal class MessageScreenPresenterFactory
@Inject
constructor(
    private val messagePresenterFactory: MessagePresenter.Factory,
) : Presenter.Factory {
  override fun create(
      screen: Screen,
      navigator: Navigator,
      context: CircuitContext,
  ): Presenter<*>? {
    return when (screen) {
      is MessageScreen -> messagePresenterFactory.create(navigator)
      else -> null
    }
  }
}

internal class MessagePresenter
@AssistedInject
constructor(
    @Assisted private val navigator: Navigator,
    private val messageRepository: MessageRepository,
) : Presenter<MessageUiState> {

  @Composable
  override fun present(): MessageUiState {
    var uiState by rememberRetained { mutableStateOf<MessageUiState>(MessageUiState.Loading) }

    LaunchedEffect(messageRepository) {
      uiState =
          MessageUiState.Loaded(message = messageRepository.getMessage()) { event ->
            when (event) {
              MessageUiEvent.NextClick -> navigator.goTo(NextScreen(id = "123"))
            }
          }
    }

    return uiState
  }

  @AssistedFactory
  interface Factory {
    fun create(navigator: Navigator): MessagePresenter
  }
}
