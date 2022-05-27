package ttt.exceptions;

public class InvalidPlayerError extends RuntimeException {
  public InvalidPlayerError(String msg) {
   super(msg);
  }
}
