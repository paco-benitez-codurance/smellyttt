import java.util.ArrayList;
import java.util.List;

public class Board {
  private final List<Tile> plays = new ArrayList<>();

  public Board() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        Tile tile = Tile.emptyTitle(i, j);
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
    Tile tile = tileAt(x, y);
    plays.remove(tile);
    plays.add(tile.copy(symbol));
  }
}