package org.example;

public class NotEnoughSizeException extends RuntimeException {
  public NotEnoughSizeException(String message) {
    super(message);
  }
}
