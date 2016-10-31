package game.xo.controllers;


import game.xo.model.Field;
import game.xo.model.exceptions.AlreadyOccupiedException;
import game.xo.system.Logger;
import game.xo.model.Figure;
import game.xo.model.exceptions.InvalidPointException;

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
            if(logger!=null) {logger.warning("Пользователь ввёл некорректные координаты");}
            throw new AlreadyOccupiedException();
        }
        field.setFigure(point, figure);
    }

}
