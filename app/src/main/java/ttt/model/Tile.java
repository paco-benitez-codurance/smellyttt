package ttt.model;

import static ttt.model.Symbol.emptySymbol;

public record Tile(Coordinate coordinate, Symbol symbol) {

  static Tile emptyTitle(Coordinate coordinate) {
    return new Tile(coordinate, emptySymbol());
  }

  Tile copy(Symbol symbol) {
    return new Tile(coordinate, symbol);
  }

  boolean iAmXY(Coordinate coordinate) {
    return this.coordinate.equals(coordinate);
  }

  boolean isEmpty() {
    return symbol.isEmpty();
  }

  boolean sameSymbol(Tile tile) {
    return this.symbol == tile.symbol();
  }

}

