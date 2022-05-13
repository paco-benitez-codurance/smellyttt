import java.util.ArrayList;
import java.util.List;

public class Board {
  private final List<Tile> plays = new ArrayList<>();

  public Board() {
    fillBoardWithEmptyTiles();
  }

  private void fillBoardWithEmptyTiles() {
    Tile.giveMeAllCoordinates(
      (coordinate) -> plays.add(Tile.emptyTitle(coordinate))
    );
  }

  public Tile tileAt(Coordinate coordinate) {
    return
      plays
        .stream()
        .filter(tile -> tile.iAmXY(coordinate))
        .findFirst()
        .orElse(null);
  }

  public void addTileAt(Symbol symbol, Coordinate coordinate) {
    Tile tile = tileAt(coordinate);
    plays.remove(tile);
    plays.add(tile.copy(symbol));
  }
}