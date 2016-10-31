package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import junit.framework.TestCase;
import static io.hexlet.xo.TestHelper.*;
import org.junit.Test;

import java.awt.*;


public class WinnerControllerTest extends TestCase {

    final int FIELD_SIZE_X = 3;

    final int FIELD_SIZE_Y = 3;

    @Test
    public void testGetWinner() throws Exception {

        WinnerController winnerController = new WinnerController(null);

        String[][][] fArray = {
                {
                        {"X", "X", " "},
                        {"O", "X", " "},
                        {"X", " ", "O"}
                },

                {
                        {"X", " ", " "},
                        {"O", " ", " "},
                        {"X", " ", "O"}
                },
                {
                        {"X", "O", "X"},
                        {"O", "O", " "},
                        {"X", " ", "X"}
                },
                {
                        {"X", "O", "X"},
                        {"O", "O", "O"},
                        {"X", " ", "X"}
                },
                {
                        {"X", "O", "X"},
                        {"O", "X", "O"},
                        {"X", "O", "X"}
                },
                {
                        {"X", " ", " "},
                        {"O", "X", " "},
                        {" ", " ", " "}
                },
                {
                        {" ", "X", " "},
                        {"O", "X", " "},
                        {" ", " ", " "}
                },
                {
                        {" ", "O", " "},
                        {"O", "X", " "},
                        {"X", "X", " "}
                },
        };
        Figure[] resultArray={null, null, null, Figure.O, Figure.X, null, null, null};

        for(int i=0; i<fArray.length; i++) {
            assertEquals(resultArray[i], winnerController.getWinner(fieldGenerator(fArray[i], FIELD_SIZE_X, FIELD_SIZE_Y)));
        }
    }

    @Test
    public void testGetWinnerEmptyField() throws Exception {
        final int FIELD_SIZE=3;

        WinnerController winnerController = new WinnerController(null);

        Field field = new Field(FIELD_SIZE);

        assertNull(winnerController.getWinner(field));
    }

    @Test
    public void testGetWinnerX() throws Exception {

        WinnerController winnerController = new WinnerController(null);

        Field field;
        Figure winnerFigure = Figure.O;

        for (int i = 0; i < FIELD_SIZE_X; i++) {
            field = new Field(FIELD_SIZE_X, FIELD_SIZE_Y);

            for (int j = 0; j < field.getSizeY(); j++) {
                field.setFigure(new Point(i, j), winnerFigure);
            }
            assertEquals(winnerFigure, winnerController.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerY() throws Exception {

        Field field;

        Figure winnerFigure = Figure.O;

        WinnerController winnerController = new WinnerController(null);

        for (int j = 0; j < FIELD_SIZE_Y; j++) {
            field = new Field(FIELD_SIZE_X, FIELD_SIZE_Y);

            for (int i = 0; i < field.getSizeX(); i++) {
                field.setFigure(new Point(i, j), winnerFigure);
            }
            assertEquals(winnerFigure, winnerController.getWinner(field));
        }
    }

    @Test
    public void testGetWinnerFirstDiagonal() throws Exception {

        Field field;

        Figure winnerFigure = Figure.O;

        WinnerController winnerController = new WinnerController(null);

            field = new Field(FIELD_SIZE_X, FIELD_SIZE_Y);

            for (int i = 0; i < field.getSizeX(); i++) {
                field.setFigure(new Point(i, i), winnerFigure);
            }

        assertEquals(winnerFigure, winnerController.getWinner(field));
    }

    @Test
    public void testGetWinnerSecondDiagonal() throws Exception {

        Field field;

        Figure winnerFigure = Figure.O;

        WinnerController winnerController = new WinnerController(null);

        field = new Field(FIELD_SIZE_X, FIELD_SIZE_Y);


        field.setFigure(new Point(0, 2), winnerFigure);
        field.setFigure(new Point(1, 1), winnerFigure);
        field.setFigure(new Point(2, 0), winnerFigure);

        assertEquals(winnerFigure, winnerController.getWinner(field));
    }

}