package game.xo.controllers;


import game.xo.model.Field;
import game.xo.system.Logger;
import game.xo.model.Figure;
import game.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class CurrentMoveController {

    Logger logger;

    public CurrentMoveController(Logger logger) {
        this.logger = logger;
    }

    /**
     * Возвращает ту фигуру, чей сейчас ход. Если ходов нет, Возвращает null
     * @param field поле
     * @return
     */
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
                if (field.getFigure(new Point(x, row)) != null) {
                    countFigure++;
                }
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
        }
        return countFigure;
    }

}
