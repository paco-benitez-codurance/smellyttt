public class Game {
  private Symbol lastSymbol = Symbol.emptySymbol();
  private final Board board = new Board();

  public void play(Symbol symbol, Coordinate coordinate) throws Exception {
    if (lastSymbol == Symbol.emptySymbol()) {
      if (symbol == Symbol.O()) {
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
      return board.tileAt(new Coordinate(0, 0)).symbol();
    }
    if (sameSymbolNotFreeInRow(1)) {
      return board.tileAt(new Coordinate(1, 0)).symbol();
    }
    if (sameSymbolNotFreeInRow(2)) {
      return board.tileAt(new Coordinate(2, 0)).symbol();
    }

    return Symbol.emptySymbol();
  }

  private boolean sameSymbolNotFreeInRow(int row) {
    return isRowNotFree(row) && sameSymbolInRow(row);
  }

  private boolean sameSymbolInRow(int row) {
    return board.tileAt(new Coordinate(row, 0)).sameSymbol(board.tileAt(new Coordinate(row, 1))) &&
      board.tileAt(new Coordinate(row, 2)).sameSymbol(board.tileAt(new Coordinate(row, 1)));
  }

  private boolean isRowNotFree(int row) {
    return board.tileAt(new Coordinate(row, 0)).isNotEmpty() &&
      board.tileAt(new Coordinate(row, 1)).isNotEmpty() &&
      board.tileAt(new Coordinate(row, 2)).isNotEmpty();
  }
}

