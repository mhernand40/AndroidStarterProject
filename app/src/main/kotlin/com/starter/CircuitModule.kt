package com.starter

import com.slack.circuit.foundation.Circuit
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.ui.Ui
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
internal object CircuitModule {
  @Provides
  fun provideCircuit(
      presenterFactories: Set<@JvmSuppressWildcards Presenter.Factory>,
      uiFactories: Set<@JvmSuppressWildcards Ui.Factory>,
  ) =
      Circuit.Builder()
          .addPresenterFactories(presenterFactories)
          .addUiFactories(uiFactories)
          .build()
}
