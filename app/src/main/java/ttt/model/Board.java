package ttt.model;

import java.util.ArrayList;
import java.util.List;

import static ttt.model.Coordinate.coord;
import static ttt.model.Symbol.emptySymbol;

public class Board {
  private final List<Tile> plays = new ArrayList<>();

  public Board() {
    fillBoardWithEmptyTiles();
  }

  public void addTileAt(Symbol symbol, Coordinate coordinate) {
    Tile tile = tileAt(coordinate);
    plays.remove(tile);
    plays.add(tile.copy(symbol));
  }

  public boolean isEmpty(Coordinate coordinate) {
    return tileAt(coordinate).isEmpty();
  }

  public Symbol winner() {
    if (sameSymbolNotFreeInRow(0)) {
      return tileAt(coord(0, 0)).symbol();
    }
    if (sameSymbolNotFreeInRow(1)) {
      return tileAt(coord(1, 0)).symbol();
    }
    if (sameSymbolNotFreeInRow(2)) {
      return tileAt(coord(2, 0)).symbol();
    }
    return emptySymbol();
  }

  private void fillBoardWithEmptyTiles() {
    Coordinate.giveMeAllCoordinates(
      coordinate -> plays.add(Tile.emptyTitle(coordinate))
    );
  }

  private Tile tileAt(Coordinate coordinate) {
    return
      plays
        .stream()
        .filter(tile -> tile.iAmXY(coordinate))
        .findFirst()
        .orElseThrow();
  }

  private boolean isRowWithTiles(int row) {
    return !tileAt(coord(row, 0)).isEmpty() &&
      !tileAt(coord(row, 1)).isEmpty() &&
      !tileAt(coord(row, 2)).isEmpty();
  }

  private boolean sameSymbolInRow(int row) {
    return tileAt(coord(row, 0)).sameSymbol(tileAt(coord(row, 1))) &&
      tileAt(coord(row, 2)).sameSymbol(tileAt(coord(row, 1)));
  }

  private boolean sameSymbolNotFreeInRow(int row) {
    return isRowWithTiles(row) && sameSymbolInRow(row);
  }
}