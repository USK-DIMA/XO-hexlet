package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.AlreadyOccupiedException;
import io.hexlet.xo.model.exceptions.InvalidPointException;
import junit.framework.TestCase;
import org.junit.Test;

import static io.hexlet.xo.TestHelper.*;

import java.awt.*;

/**
 * Created by Dmitry on 05.07.2015.
 */
public class MoveControllerTest extends TestCase {


    final int FIELD_SIZE_X = 3;

    final int FIELD_SIZE_Y = 3;


    @Test
    public void testApplyFigure() throws Exception {
        MoveController moveController = new MoveController(null);
        String[][] fieldString ={
                    {"X", " ", " "},
                    {" ", "O", "X"},
                    {" ", " ", " "}
        };
        Field field = fieldGenerator(fieldString, FIELD_SIZE_X, FIELD_SIZE_Y);

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
    }
}