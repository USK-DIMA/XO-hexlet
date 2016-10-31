package game.xo.model;

import game.xo.model.Field;
import game.xo.model.Figure;
import game.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;


public class FieldTest {

    @Test
    public void testGetSize() throws Exception {

        final Field field1 = new Field(3);
        assertEquals(3, field1.getSizeX());
        assertEquals(3, field1.getSizeY());

        final Field field2 = new Field(2, 4);
        assertEquals(2, field2.getSizeX());
        assertEquals(4, field2.getSizeY());

        final Field field3 = new Field(-4, 2);
        assertEquals(3, field3.getSizeX());
        assertEquals(3, field3.getSizeY());

        final Field field4 = new Field(4, 0);
        assertEquals(3, field4.getSizeX());
        assertEquals(3, field4.getSizeY());

        final Field field5 = new Field(-2);
        assertEquals(3, field5.getSizeX());
        assertEquals(3, field5.getSizeY());
    }

    @Test
    public void testSetFigure() throws Exception {
        final Field field = new Field(3);
        final Point inputPoint = new Point(0, 0);
        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);
        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure, actualFigure);
    }

    @Test
    public void testSetFigureWhenIncorrectcCoordinateX() throws Exception {
        final int size=3;
        final Field field = new Field(size);
        final Figure inputFigure = Figure.O;

        try {
            field.setFigure(new Point(size+1, 1), inputFigure);
            fail();
        }
        catch (InvalidPointException e) {
        }

        try {
            field.setFigure(new Point(-1, 2), inputFigure);
            fail();
        }
        catch (InvalidPointException e) {
        }

    }

    @Test
    public void testSetFigureWhenIncorrectcCoordinateY() throws Exception {
        final int size=3;
        final Field field = new Field(size);
        final Figure inputFigure = Figure.O;

        try {
            field.setFigure(new Point(1, size+1), inputFigure);
            fail();
        }
        catch (InvalidPointException e) {
        }

        try {
            field.setFigure(new Point(2, -1), inputFigure);
            fail();
        }
        catch (InvalidPointException e) {
        }

    }

    @Test
    public void testGetFigureWhenFigureIsNotSet() throws Exception {
        final Field field = new Field(3);
        final Point inputPoint = new Point(0, 0);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertNull(actualFigure);
    }

    @Test
    public void testGetFigureWhenXIsLessThenZero() throws Exception {
        final Field field = new Field(3);
        final Point inputPoint = new Point(-1, 0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void testGetFigureWhenYIsLessThenZero() throws Exception {
        final Field field = new Field(3);
        final Point inputPoint = new Point(0, -1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }


    @Test
    public void testGetFigureWhenXIsMoreThenSize() throws Exception {
        final Field field = new Field(3);
        final Point inputPoint = new Point(field.getSizeX() + 1, 0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void testGetFigureWhenYIsMoreThenSize() throws Exception {
        final Field field = new Field(3);
        final Point inputPoint = new Point(0, field.getSizeY() + 1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }


}