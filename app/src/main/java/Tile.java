
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

  public static char emptySymbol() {
    return ' ';
  }
  public static char X() {
    return 'X';
  }
  public static char O() {
    return 'O';
  }
}