package game.xo.model;

import game.xo.model.Field;
import game.xo.model.Game;
import game.xo.model.Player;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Dmitry on 05.07.2015.
 */
public class GameTest {

    private final int FIEELD_SIZE_X = 3;

    private final int FIEELD_SIZE_Y = 3;

    private final String NAME="test game name";

    private final Player[] PLAYERS = new Player[3];

    private final Field FIELD = new Field(FIEELD_SIZE_X, FIEELD_SIZE_Y);

    private final Game GAME = new Game(PLAYERS, FIELD, NAME);

    @Test
    public void testGetPlayers() throws Exception {
        assertEquals(PLAYERS, GAME.getPlayers());
    }

    @Test
    public void testGetField() throws Exception {
        assertEquals(FIELD, GAME.getField());
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals(NAME, GAME.getName());
    }
}