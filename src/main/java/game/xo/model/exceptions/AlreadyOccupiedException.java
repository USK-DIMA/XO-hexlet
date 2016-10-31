package game.xo.model.exceptions;

import game.xo.controllers.MoveController;

/**
 * Срабатывает, если хотим записать в уже занятую клетку новую фигуру
 * @see MoveController
 */
public class AlreadyOccupiedException extends AbstractXOException {
}
