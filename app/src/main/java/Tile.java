
class Tile {
  private final int x;
  private final int y;
  private final char symbol;

  Tile(int x, int y, char symbol) {
    this.x = x;
    this.y = y;
    this.symbol = symbol;
  }

  public boolean iAmXY(int x, int y) {
    return this.x == x && this.y == y;
  }

  public boolean isNotEmpty() {
    return symbol != ' ';
  }

  public char symbol() {
    return this.symbol;
  }

  public boolean sameSymbol(Tile tile) {
    return this.symbol == tile.symbol();
  }
}