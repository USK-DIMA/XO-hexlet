package io.hexlet.xo.model.exceptions;

/**
 * Срабатывает, если хотим записать в уже занятую клетку новую фигуру
 * @see io.hexlet.xo.controllers.MoveController
 */
public class AlreadyOccupiedException extends AbstractXOException {
}
