package ttt;

import ttt.exceptions.InvalidPlayerError;
import ttt.exceptions.InvalidPositionError;
import ttt.model.Board;
import ttt.model.Coordinate;
import ttt.model.Symbol;

import static ttt.model.Symbol.emptySymbol;

public class GameImpl implements Game {
  private Symbol lastSymbol = emptySymbol();
  private final Board board = new Board();

  @Override
  public void play(Symbol symbol, Coordinate coordinate) {
    checkPlay(symbol, coordinate);
    lastSymbol = symbol;
    board.addTileAt(symbol, coordinate);
  }

  @Override
  public Symbol winner() {
    return board.winner();
  }

  private void checkPlay(Symbol symbol, Coordinate coordinate) {
    if (!playHasStarted() && symbol == Symbol.o()) {
      throw new InvalidPlayerError("Invalid first player");
    } else if (symbol == lastSymbol) {
      throw new InvalidPlayerError("Invalid next player");
    } else if (!board.isEmpty(coordinate)) {
      throw new InvalidPositionError("Invalid position");
    }
  }

  private boolean playHasStarted() {
    return lastSymbol != emptySymbol();
  }
}

