package game.xo.model;

import game.xo.model.Figure;
import game.xo.model.Player;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Dmitry on 05.07.2015.
 */
public class PlayerTest {

    @Test
    public void testGetName() throws Exception {
        final String inputValue = "Slava";
        final String expectedValue = inputValue;

        final Player player = new Player(inputValue, null);

        final String actualValue = player.getName();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testGetFigure() throws Exception {
        final Figure inputValue = Figure.X;
        final Figure expectedValue = inputValue;

        final Player player = new Player(null, inputValue);

        final Figure actualValue = player.getFigure();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testEquals() throws Exception {
        Player p1 = new Player("Vasiliy", Figure.O);
        Player p2= new Player("Vasiliy", Figure.O);

        Player p3 = new Player("Vasiliy", Figure.X);
        Player p4 = new Player("Vasilii", Figure.O);
        Player p5 = new Player("Vasiliy", null);
        Player p6 = new Player(null, Figure.O);
        assertTrue(p1.equals(p2));
        assertFalse(p1.equals(p3));
        assertFalse(p1.equals(p4));
        assertFalse(p1.equals(p5));
        assertFalse(p1.equals(p6));
    }

}