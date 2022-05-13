
class Tile
{
    private final int X;
    private final int Y;
    public char Symbol;

    Tile(int x, int y, char symbol) {
        X = x;
        Y = y;
        Symbol = symbol;
    }

    public boolean iAmXY(int x, int y) {
        return X == x && Y == y;
    }
}