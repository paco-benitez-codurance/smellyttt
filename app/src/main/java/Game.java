public class Game {
  private char lastSymbol = Tile.emptySymbol();
  private final Board board = new Board();

  public void play(char symbol, int x, int y) throws Exception {
    //if first move
    if (lastSymbol == Tile.emptySymbol()) {
      //if player is X
      if (symbol == Tile.O()) {
        throw new Exception("Invalid first player");
      }
    }
    //if not first move but player repeated
    else if (symbol == lastSymbol) {
      throw new Exception("Invalid next player");
    }
    //if not first move but play on an already played tile
    else if (board.tileAt(x, y).isNotEmpty()) {
      throw new Exception("Invalid position");
    }

    // update game state
    lastSymbol = symbol;
    board.addTileAt(symbol, x, y);
  }

  public char winner() {
    if (sameSymbolNotFreeInRow(0)) {
      return board.tileAt(0, 0).symbol();
    }
    if (sameSymbolNotFreeInRow(1)) {
      return board.tileAt(1, 0).symbol();
    }
    if (sameSymbolNotFreeInRow(2)) {
      return board.tileAt(2, 0).symbol();
    }

    return Tile.emptySymbol();
  }

  private boolean sameSymbolNotFreeInRow(int row) {
    return isRowNotFree(row) && sameSymbolInRow(row);
  }

  private boolean sameSymbolInRow(int row) {
    return board.tileAt(row, 0).sameSymbol(board.tileAt(row, 1)) &&
      board.tileAt(row, 2).sameSymbol(board.tileAt(row, 1));
  }

  private boolean isRowNotFree(int row) {
    return board.tileAt(row, 0).isNotEmpty() &&
      board.tileAt(row, 1).isNotEmpty() &&
      board.tileAt(row, 2).isNotEmpty();
  }
}

