
record Tile(int x, int y, char symbol) {

  public boolean iAmXY(int x, int y) {
    return this.x == x && this.y == y;
  }

  public boolean isNotEmpty() {
    return symbol != ' ';
  }

  public boolean sameSymbol(Tile tile) {
    return this.symbol == tile.symbol();
  }
}