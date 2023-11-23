package com.starter.message.ui

import androidx.compose.runtime.Composable
import com.slack.circuit.runtime.CircuitContext
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.screen.Screen
import com.slack.circuit.runtime.ui.Ui
import com.slack.circuit.runtime.ui.ui
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import javax.inject.Inject

internal class NextScreenPresenterFactory
@Inject
constructor(private val nextPresenterFactory: NextPresenter.Factory) : Presenter.Factory {
  override fun create(
      screen: Screen,
      navigator: Navigator,
      context: CircuitContext,
  ): Presenter<*>? {
    return when (screen) {
      is NextScreen -> nextPresenterFactory.create(screen)
      else -> null
    }
  }
}

internal class NextPresenter
@AssistedInject
constructor(
    @Assisted private val screen: NextScreen,
) : Presenter<NextUiState> {
  @Composable
  override fun present(): NextUiState {
    return NextUiState(content = "You've reached the next screen (id = ${screen.id})")
  }

  @AssistedFactory
  interface Factory {
    fun create(screen: NextScreen): NextPresenter
  }
}

internal class NextScreenUiFactory @Inject constructor() : Ui.Factory {
  override fun create(screen: Screen, context: CircuitContext): Ui<*>? {
    return when (screen) {
      is NextScreen -> nextScreen()
      else -> null
    }
  }

  private fun nextScreen() =
      ui<NextUiState> { uiState, modifier ->
        NextContent(
            uiState = uiState,
            modifier = modifier,
        )
      }
}
