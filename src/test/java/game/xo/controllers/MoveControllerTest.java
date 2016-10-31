package game.xo.controllers;

import game.xo.TestHelper;
import game.xo.model.Field;
import game.xo.model.Figure;
import game.xo.model.exceptions.AlreadyOccupiedException;
import game.xo.model.exceptions.InvalidPointException;
import game.xo.system.Logger;
import junit.framework.TestCase;
import org.junit.Test;

import java.awt.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by Dmitry on 05.07.2015.
 */
public class MoveControllerTest extends TestCase {


    final int FIELD_SIZE_X = 3;

    final int FIELD_SIZE_Y = 3;


    @Test
    public void testApplyFigure() throws Exception {

        Logger logger = mock(Logger.class);

        MoveController moveController = new MoveController(logger);
        String[][] fieldString ={
                    {"X", " ", " "},
                    {" ", "O", "X"},
                    {" ", " ", " "}
        };
        Field field = TestHelper.fieldGenerator(fieldString, FIELD_SIZE_X, FIELD_SIZE_Y);

        moveController.applyFigure(field, new Point(1, 0), Figure.O);
        assertEquals(Figure.O, field.getFigure(new Point(1, 0)));

        try {
            moveController.applyFigure(field, new Point(1, 0), Figure.X);
            fail();
        }
        catch (AlreadyOccupiedException e){
        }

        try {
            moveController.applyFigure(field, new Point(-1, 0), Figure.X);
            fail();
        }
        catch (InvalidPointException e){
        }
        verify(logger, times(1)).warning("Пользователь ввёл некорректные координаты");
    }
}