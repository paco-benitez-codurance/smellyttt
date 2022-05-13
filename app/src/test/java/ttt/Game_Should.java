package ttt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static ttt.Coordinate.coord;
import static ttt.Symbol.O;
import static ttt.Symbol.X;

public class Game_Should {
    private Game game;

    @BeforeEach
    public void InitializeGame(){
        game = new Game();
    }

    @Test
    public void NotAllowPlayerOToPlayFirst() {
        assertThrows(Exception.class, () -> game.play(O(), coord(0, 0)));
    }

    @Test
    public void NotAllowPlayerXToPlayTwiceInARow() {
        assertThrows(Exception.class, () ->{
            game.play(X(), coord(0, 0));
            game.play(X(), coord(1, 0));
        });
    }

    @Test
    public void NotAllowPlayerToPlayInLastPlayedPosition() {
        assertThrows(Exception.class, () ->{
            game.play(X(), coord(0, 0));
            game.play(O(), coord(0, 0));
        });
    }

    @Test
    public void NotAllowPlayerToPlayInAnyPlayedPosition() {
        assertThrows(Exception.class, () ->{
            game.play(X(), coord(0, 0));
            game.play(O(), coord(1, 0));
            game.play(X(), coord(0, 0));
        });
    }

    @Test
    public void DeclarePlayerXAsAWinnerIfThreeInTopRow() throws Exception
    {
        game.play(X(), coord(0, 0));
        game.play(O(), coord(1, 0));
        game.play(X(), coord(0, 1));
        game.play(O(), coord(1, 1));
        game.play(X(), coord(0, 2));

        Symbol winner = game.winner();

        assertEquals(X(), winner);
    }

    @Test
    public void DeclarePlayerOAsAWinnerIfThreeInTopRow() throws Exception
    {
        game.play(X(), coord(2, 2));
        game.play(O(), coord(0, 0));
        game.play(X(), coord(1, 0));
        game.play(O(), coord(0, 1));
        game.play(X(), coord(1, 1));
        game.play(O(), coord(0, 2));

        Symbol winner = game.winner();

        assertEquals(O(), winner);
    }

    @Test
    public void DeclarePlayerXAsAWinnerIfThreeInMiddleRow() throws Exception
    {
        game.play(X(), coord(1, 0));
        game.play(O(), coord(0, 0));
        game.play(X(), coord(1, 1));
        game.play(O(), coord(0, 1));
        game.play(X(), coord(1, 2));

        Symbol winner = game.winner();

        assertEquals(X(), winner);
    }

    @Test
    public void DeclarePlayerOAsAWinnerIfThreeInMiddleRow() throws Exception
    {
        game.play(X(), coord(0, 0));
        game.play(O(), coord(1, 0));
        game.play(X(), coord(2, 0));
        game.play(O(), coord(1, 1));
        game.play(X(), coord(2, 1));
        game.play(O(), coord(1, 2));

        Symbol winner = game.winner();

        assertEquals(O(), winner);
    }

    @Test
    public void DeclarePlayerXAsAWinnerIfThreeInBottomRow() throws Exception
    {
        game.play(X(), coord(2, 0));
        game.play(O(), coord(0, 0));
        game.play(X(), coord(2, 1));
        game.play(O(), coord(0, 1));
        game.play(X(), coord(2, 2));

        Symbol winner = game.winner();

        assertEquals(X(), winner);
    }

    @Test
    public void DeclarePlayerOAsAWinnerIfThreeInBottomRow() throws Exception
    {
        game.play(X(), coord(0, 0));
        game.play(O(), coord(2, 0));
        game.play(X(), coord(1, 0));
        game.play(O(), coord(2, 1));
        game.play(X(), coord(1, 1));
        game.play(O(), coord(2, 2));

        Symbol winner = game.winner();

        assertEquals(O(), winner);
    }
}
