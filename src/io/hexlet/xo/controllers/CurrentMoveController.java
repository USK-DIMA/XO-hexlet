package io.hexlet.xo.controllers;


import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class CurrentMoveController {

    public Figure currentMove(final Field field) {
        int countFigure = 0;
        for (int x = 0; x < field.getSizeX(); x++) {
            countFigure += countFiguresInTheRow(field, x);
        }

        if (countFigure == field.getSizeX() * field.getSizeY())
            return null;

        if (countFigure % 2 == 0)
            return Figure.X;

        return Figure.O;
    }

    private int countFiguresInTheRow(final Field field, final int row) {
        int countFigure = 0;
        for (int x = 0; x < field.getSizeY(); x++) {
            try {
                if (field.getFigure(new Point(x, row)) != null)
                    countFigure++;
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
        }
        return countFigure;
    }

}