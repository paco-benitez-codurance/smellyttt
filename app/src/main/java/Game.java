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
        if (isRowNotFree(0)) {
            if (sameSymbolInRow(0)) {
                return _board.TileAt(0, 0).Symbol;
            }
        }

        if (isRowNotFree(1)) {
            if (sameSymbolInRow(1)) {
                return _board.TileAt(1, 0).Symbol;
            }
        }

        if (isRowNotFree(2)) {
            if (sameSymbolInRow(2)) {
                return _board.TileAt(2, 0).Symbol;
            }
        }

        return ' ';
    }

    private boolean sameSymbolInRow(int x) {
        return _board.TileAt(x, 0).Symbol == _board.TileAt(x, 1).Symbol &&
          _board.TileAt(x, 2).Symbol == _board.TileAt(x, 1).Symbol;
    }

    private boolean isRowNotFree(int x) {
        return _board.TileAt(x, 0).Symbol != ' ' &&
          _board.TileAt(x, 1).Symbol != ' ' &&
          _board.TileAt(x, 2).Symbol != ' ';
    }
}

