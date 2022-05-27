package ttt.exceptions;

public class InvalidPositionError extends RuntimeException {
  public InvalidPositionError(String msg) {
    super(msg);
  }
}
