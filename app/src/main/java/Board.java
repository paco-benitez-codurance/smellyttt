import java.util.ArrayList;
import java.util.List;

public class Board {
  private final List<Tile> plays = new ArrayList<>();

  public Board() {
    fillBoardWithEmptyTiles();
  }

  private void fillBoardWithEmptyTiles() {
    Tile.giveMeAllCoordinates(
      (x, y) -> plays.add(Tile.emptyTitle(x, y))
    );
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