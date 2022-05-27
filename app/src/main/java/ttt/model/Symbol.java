package ttt.model;

public enum Symbol {
  EMPTY, X, O;

  public boolean isEmpty() {
    return this == EMPTY;
  }

  public static Symbol emptySymbol() {
    return EMPTY;
  }

  public static Symbol x() {
    return X;
  }

  public static Symbol o() {
    return O;
  }
}
