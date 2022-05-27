package ttt;

import ttt.model.Coordinate;
import ttt.model.Symbol;

public interface Game {
  void play(Symbol symbol, Coordinate coordinate);
  Symbol winner();
}
