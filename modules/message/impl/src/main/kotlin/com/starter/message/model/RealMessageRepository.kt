package com.starter.message.model

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds
import kotlinx.coroutines.delay

internal class RealMessageRepository @Inject constructor() : MessageRepository {
  override suspend fun getMessage(): String {
    delay(2.seconds)
    return "Hello World!"
  }
}

@Module
@InstallIn(ViewModelComponent::class)
internal interface MessageRepositoryModule {
  @Binds fun bindMessageRepository(real: RealMessageRepository): MessageRepository
}
