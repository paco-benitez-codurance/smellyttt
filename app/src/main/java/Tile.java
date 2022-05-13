
class Tile
{
    private final int X;
    private final int Y;
    private final char symbol;

    Tile(int x, int y, char symbol) {
        X = x;
        Y = y;
        this.symbol = symbol;
    }

    public boolean iAmXY(int x, int y) {
        return X == x && Y == y;
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