package ttt.model;

import static ttt.model.Symbol.emptySymbol;

public record Tile(Coordinate coordinate, Symbol symbol) {

  public static Tile emptyTitle(Coordinate coordinate) {
    return new Tile(coordinate, emptySymbol());
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

}

