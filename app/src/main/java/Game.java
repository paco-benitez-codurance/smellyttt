public class Game {
    private char _lastSymbol = ' ';
    private Board _board = new Board();

    public void Play(char symbol, int x, int y) throws Exception {
        //if first move
        if (_lastSymbol == ' ') {
            //if player is X
            if (symbol == 'O') {
                throw new Exception("Invalid first player");
            }
        }
        //if not first move but player repeated
        else if (symbol == _lastSymbol) {
            throw new Exception("Invalid next player");
        }
        //if not first move but play on an already played tile
        else if (_board.TileAt(x, y).Symbol != ' ') {
            throw new Exception("Invalid position");
        }

        // update game state
        _lastSymbol = symbol;
        _board.AddTileAt(symbol, x, y);
    }

    public char Winner() {
        if (sameSymbolNotFreeInRow(0)) {
            return _board.TileAt(0, 0).Symbol;
        }
        if (sameSymbolNotFreeInRow(1)) {
            return _board.TileAt(1, 0).Symbol;
        }
        if (sameSymbolNotFreeInRow(2)) {
            return _board.TileAt(2, 0).Symbol;
        }

        return ' ';
    }

    private boolean sameSymbolNotFreeInRow(int row) {
       return isRowNotFree(row) && sameSymbolInRow(row);
    }

    private boolean sameSymbolInRow(int row) {
        return _board.TileAt(row, 0).Symbol == _board.TileAt(row, 1).Symbol &&
          _board.TileAt(row, 2).Symbol == _board.TileAt(row, 1).Symbol;
    }

    private boolean isRowNotFree(int row) {
        return _board.TileAt(row, 0).Symbol != ' ' &&
          _board.TileAt(row, 1).Symbol != ' ' &&
          _board.TileAt(row, 2).Symbol != ' ';
    }
}

