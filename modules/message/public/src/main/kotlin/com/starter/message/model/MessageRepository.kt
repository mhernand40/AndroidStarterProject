package com.starter.message.model

public interface MessageRepository {
  public suspend fun getMessage(): String
}
