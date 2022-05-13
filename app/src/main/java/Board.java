import java.util.ArrayList;
import java.util.List;

public class Board {
  private final List<Tile> plays = new ArrayList<>();

  public Board() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        Tile tile = new Tile(i, j, Symbol.emptySymbol());
        plays.add(tile);
      }
    }
  }

  public Tile tileAt(int x, int y) {
    for (Tile t : plays) {
      if (t.iAmXY(x, y)) {
        return t;
      }
    }
    return null;
  }

  public void addTileAt(Symbol symbol, int x, int y) {
    plays.remove(tileAt(x, y));
    plays.add(new Tile(x, y, symbol));
  }
}