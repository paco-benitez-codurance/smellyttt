import java.util.function.Consumer;

record Tile(Coordinate coordinate, Symbol symbol) {

  public static Tile emptyTitle(Coordinate coordinate) {
    return new Tile(coordinate, Symbol.emptySymbol());
  }

  public Tile copy(Symbol symbol) {
    return new Tile(coordinate, symbol);
  }

  public boolean iAmXY(Coordinate coordinate) {
    return this.coordinate.equals(coordinate);
  }

  public boolean isNotEmpty() {
    return symbol.isNotEmpty();
  }

  public boolean sameSymbol(Tile tile) {
    return this.symbol == tile.symbol();
  }

  public static void giveMeAllCoordinates(Consumer<Coordinate> coordinateConsumer) {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        coordinateConsumer.accept(new Coordinate(i, j));
      }
    }
  }
}

record Coordinate(int x, int y) {
  static Coordinate coord(int x, int y) {
    return new Coordinate(x, y);
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