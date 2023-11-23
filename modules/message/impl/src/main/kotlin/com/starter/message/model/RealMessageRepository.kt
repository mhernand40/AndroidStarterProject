package com.starter.message.model

import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds
import kotlinx.coroutines.delay

internal class RealMessageRepository @Inject constructor() : MessageRepository {
  override suspend fun getMessage(): String {
    delay(2.seconds)
    return "Hello World!"
  }
}
