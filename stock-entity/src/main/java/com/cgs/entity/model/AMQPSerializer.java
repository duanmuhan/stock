package com.cgs.entity.model;

public interface AMQPSerializer<T> {

  String toMessage();
  T parseFromMessage(String string);
}
