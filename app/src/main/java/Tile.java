
record Tile(int x, int y, Symbol symbol) {

  public boolean iAmXY(int x, int y) {
    return this.x == x && this.y == y;
  }

  public boolean isNotEmpty() {
    return symbol.isNotEmpty();
  }

  public boolean sameSymbol(Tile tile) {
    return this.symbol == tile.symbol();
  }

}

enum Symbol {
  EMPTY, X, O;

  public boolean isNotEmpty() {
    return this != EMPTY;
  }
  public static Symbol emptySymbol() {
    return EMPTY;
  }

  public static Symbol X() {
    return X;
  }

  public static Symbol O() {
    return O;
  }
}