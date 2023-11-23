package com.starter.message.di

import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.ui.Ui
import com.starter.message.model.MessageRepository
import com.starter.message.model.RealMessageRepository
import com.starter.message.ui.MessageScreenPresenterFactory
import com.starter.message.ui.MessageScreenUiFactory
import com.starter.message.ui.NextScreenPresenterFactory
import com.starter.message.ui.NextScreenUiFactory
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(ActivityRetainedComponent::class)
internal interface MessageModule {
  @Binds
  @IntoSet
  fun bindMessagePresenterFactory(real: MessageScreenPresenterFactory): Presenter.Factory

  @Binds @IntoSet fun bindMessageUiFactory(real: MessageScreenUiFactory): Ui.Factory

  @Binds @IntoSet fun bindNextPresenterFactory(real: NextScreenPresenterFactory): Presenter.Factory

  @Binds @IntoSet fun bindNextUiFactory(real: NextScreenUiFactory): Ui.Factory

  @Binds fun bindMessageRepository(real: RealMessageRepository): MessageRepository
}
