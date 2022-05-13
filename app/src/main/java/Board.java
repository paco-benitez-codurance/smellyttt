import java.util.ArrayList;
import java.util.List;

public class Board {
  private final List<Tile> plays = new ArrayList<>();

  public Board() {
    fillBoardWithEmptyTiles();
  }

  private void fillBoardWithEmptyTiles() {
    for (int i = 0; i < 3; i++) {
      addEmptyRow(i);
    }
  }

  private void addEmptyRow(int row) {
    for (int j = 0; j < 3; j++) {
      Tile tile = Tile.emptyTitle(row, j);
      plays.add(tile);
    }
  }

  public Tile tileAt(int x, int y) {
    return
      plays
        .stream()
        .filter(tile -> tile.iAmXY(x, y))
        .findFirst()
        .orElse(null);
  }

  public void addTileAt(Symbol symbol, int x, int y) {
    Tile tile = tileAt(x, y);
    plays.remove(tile);
    plays.add(tile.copy(symbol));
  }
}