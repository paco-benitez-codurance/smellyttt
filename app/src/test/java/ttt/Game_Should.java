package ttt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ttt.exceptions.InvalidPlayerError;
import ttt.exceptions.InvalidPositionError;
import ttt.model.Symbol;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static ttt.model.Coordinate.coord;

class Game_Should {
    private Game game;

    @BeforeEach
    void InitializeGame(){
        game = new Game();
    }

    @Test
    void NotAllowPlayerOToPlayFirst() {
        assertThrows(InvalidPlayerError.class, () -> game.play(Symbol.o(), coord(0, 0)));
    }

    @Test
    void NotAllowPlayerXToPlayTwiceInARow() {
        game.play(Symbol.x(), coord(0, 0));
        assertThrows(InvalidPlayerError.class, () ->
            game.play(Symbol.x(), coord(1, 0))
        );
    }

    @Test
    void NotAllowPlayerToPlayInLastPlayedPosition() {
        game.play(Symbol.x(), coord(0, 0));
        assertThrows(InvalidPositionError.class, () ->{
            game.play(Symbol.o(), coord(0, 0));
        });
    }

    @Test
    void NotAllowPlayerToPlayInAnyPlayedPosition() {
        game.play(Symbol.x(), coord(0, 0));
        game.play(Symbol.o(), coord(1, 0));
        assertThrows(InvalidPositionError.class, () ->{
            game.play(Symbol.x(), coord(0, 0));
        });
    }

    @Test
    void DeclarePlayerXAsAWinnerIfThreeInTopRow() throws Exception
    {
        game.play(Symbol.x(), coord(0, 0));
        game.play(Symbol.o(), coord(1, 0));
        game.play(Symbol.x(), coord(0, 1));
        game.play(Symbol.o(), coord(1, 1));
        game.play(Symbol.x(), coord(0, 2));

        Symbol winner = game.winner();

        assertEquals(Symbol.x(), winner);
    }

    @Test
    void DeclarePlayerOAsAWinnerIfThreeInTopRow() throws Exception
    {
        game.play(Symbol.x(), coord(2, 2));
        game.play(Symbol.o(), coord(0, 0));
        game.play(Symbol.x(), coord(1, 0));
        game.play(Symbol.o(), coord(0, 1));
        game.play(Symbol.x(), coord(1, 1));
        game.play(Symbol.o(), coord(0, 2));

        Symbol winner = game.winner();

        assertEquals(Symbol.o(), winner);
    }

    @Test
    void DeclarePlayerXAsAWinnerIfThreeInMiddleRow() throws Exception
    {
        game.play(Symbol.x(), coord(1, 0));
        game.play(Symbol.o(), coord(0, 0));
        game.play(Symbol.x(), coord(1, 1));
        game.play(Symbol.o(), coord(0, 1));
        game.play(Symbol.x(), coord(1, 2));

        Symbol winner = game.winner();

        assertEquals(Symbol.x(), winner);
    }

    @Test
    void DeclarePlayerOAsAWinnerIfThreeInMiddleRow() throws Exception
    {
        game.play(Symbol.x(), coord(0, 0));
        game.play(Symbol.o(), coord(1, 0));
        game.play(Symbol.x(), coord(2, 0));
        game.play(Symbol.o(), coord(1, 1));
        game.play(Symbol.x(), coord(2, 1));
        game.play(Symbol.o(), coord(1, 2));

        Symbol winner = game.winner();

        assertEquals(Symbol.o(), winner);
    }

    @Test
    void DeclarePlayerXAsAWinnerIfThreeInBottomRow() throws Exception
    {
        game.play(Symbol.x(), coord(2, 0));
        game.play(Symbol.o(), coord(0, 0));
        game.play(Symbol.x(), coord(2, 1));
        game.play(Symbol.o(), coord(0, 1));
        game.play(Symbol.x(), coord(2, 2));

        Symbol winner = game.winner();

        assertEquals(Symbol.x(), winner);
    }

    @Test
    void DeclarePlayerOAsAWinnerIfThreeInBottomRow() throws Exception
    {
        game.play(Symbol.x(), coord(0, 0));
        game.play(Symbol.o(), coord(2, 0));
        game.play(Symbol.x(), coord(1, 0));
        game.play(Symbol.o(), coord(2, 1));
        game.play(Symbol.x(), coord(1, 1));
        game.play(Symbol.o(), coord(2, 2));

        Symbol winner = game.winner();

        assertEquals(Symbol.o(), winner);
    }
}
