
class Tile
{
    private final int X;
    private final int Y;
    private char symbol;

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

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}