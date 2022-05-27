package ttt;

import ttt.exceptions.InvalidPlayerError;
import ttt.exceptions.InvalidPositionError;
import ttt.model.Board;
import ttt.model.Coordinate;
import ttt.model.Symbol;

import static ttt.model.Coordinate.coord;
import static ttt.model.Symbol.emptySymbol;

public class Game {
  private Symbol lastSymbol = emptySymbol();
  private final Board board = new Board();

  public void play(Symbol symbol, Coordinate coordinate) {
    if (lastSymbol == emptySymbol()) {
      if (symbol == Symbol.o()) {
        throw new InvalidPlayerError("Invalid first player");
      }
    } else if (symbol == lastSymbol) {
      throw new InvalidPlayerError("Invalid next player");
    } else if (board.tileAt(coordinate).isNotEmpty()) {
      throw new InvalidPositionError("Invalid position");
    }

    lastSymbol = symbol;
    board.addTileAt(symbol, coordinate);
  }

  public Symbol winner() {
    if (sameSymbolNotFreeInRow(0)) {
      return board.tileAt(coord(0, 0)).symbol();
    }
    if (sameSymbolNotFreeInRow(1)) {
      return board.tileAt(coord(1, 0)).symbol();
    }
    if (sameSymbolNotFreeInRow(2)) {
      return board.tileAt(coord(2, 0)).symbol();
    }

    return emptySymbol();
  }

  private boolean sameSymbolNotFreeInRow(int row) {
    return isRowNotFree(row) && sameSymbolInRow(row);
  }

  private boolean sameSymbolInRow(int row) {
    return board.tileAt(coord(row, 0)).sameSymbol(board.tileAt(coord(row, 1))) &&
      board.tileAt(coord(row, 2)).sameSymbol(board.tileAt(coord(row, 1)));
  }

  private boolean isRowNotFree(int row) {
    return board.tileAt(coord(row, 0)).isNotEmpty() &&
      board.tileAt(coord(row, 1)).isNotEmpty() &&
      board.tileAt(coord(row, 2)).isNotEmpty();
  }
}

