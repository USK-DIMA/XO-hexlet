package io.hexlet.xo.controllers;


import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.AlreadyOccupiedException;
import io.hexlet.xo.model.exceptions.InvalidPointException;
import io.hexlet.xo.system.Logger;

import java.awt.*;

public class MoveController {

    private Logger logger;

    public MoveController(Logger logger) {
        this.logger = logger;
    }

    /**
     * Ставим на поле фигуру
     * @param field поле, на которое будем ставить
     * @param point координаты клетки
     * @param figure фигура, которую будем ставить
     * @throws InvalidPointException срабатывает, если координаты клетки невалидны (выходят за границы поля)
     * @throws AlreadyOccupiedException срабатывает, если в клетке уже находится фигура
     */
    public void applyFigure(final Field field, final Point point, final Figure figure) throws InvalidPointException, AlreadyOccupiedException {
        if (field.getFigure(point) != null) {
            throw new AlreadyOccupiedException();
        }
        field.setFigure(point, figure);
    }

}
