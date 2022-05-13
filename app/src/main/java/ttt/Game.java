package ttt;

import static ttt.Coordinate.coord;
import static ttt.Symbol.O;
import static ttt.Symbol.emptySymbol;

public class Game {
  private Symbol lastSymbol = emptySymbol();
  private final Board board = new Board();

  public void play(Symbol symbol, Coordinate coordinate) throws Exception {
    if (lastSymbol == emptySymbol()) {
      if (symbol == O()) {
        throw new Exception("Invalid first player");
      }
    } else if (symbol == lastSymbol) {
      throw new Exception("Invalid next player");
    } else if (board.tileAt(coordinate).isNotEmpty()) {
      throw new Exception("Invalid position");
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

