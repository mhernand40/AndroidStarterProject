package com.starter.message.model

internal interface MessageRepository {
  suspend fun getMessage(): String
}
