package game.xo.model;


import game.xo.model.exceptions.InvalidPointException;

import java.awt.*;

/**
 * Игровое поле. Перед игрой надо создать поле (размер поля можно выбирать)
 */
public class Field {

    private static final int DEFAULT_FIELD_SIZE=3;

    private static final int MIN_COORDINATE = 0;

    private final Figure[][] field;

    private final int filedSizeX;

    private final int filedSizeY;


    /**
     *
     * @param filedSize размер поля. Создастся поле размером filedSize*filedSize.
     *                  Если будет значение <1, создасться поле размера DEFAULT_FIELD_SIZE*DEFAULT_FIELD_SIZE (DEFAULT_FIELD_SIZE = 3)
     */
    public Field(final int filedSize) {
        this(filedSize, filedSize);
    }

    public Field(final int filedSizeX, final int filedSizeY) {
        if(filedSizeX<=MIN_COORDINATE | filedSizeY<=MIN_COORDINATE){
            this.filedSizeX = DEFAULT_FIELD_SIZE;
            this.filedSizeY = DEFAULT_FIELD_SIZE;
        }
        else {
            this.filedSizeX = filedSizeX;
            this.filedSizeY = filedSizeY;
        }

        field = new Figure[this.filedSizeX][this.filedSizeY];
    }

    public int getSizeX() {
        return filedSizeX;
    }

    public int getSizeY() {
        return filedSizeY;
    }

    /**
     * Возвращает фигуру, которая стоит на клетке point. null, если клетка пуста
     * @param point
     * @return
     * @throws InvalidPointException срабатывает, если указана некорректная точка
     */
    public Figure getFigure(final Point point) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        return field[point.x][point.y];
    }

    /**
     * Ставит фигуру в клетку. Если там есть уже какая-то фигнура, то она перетирается
     * @param point
     * @param figure
     * @throws InvalidPointException
     */
    public void setFigure(final Point point, final Figure figure) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        field[point.x][point.y] = figure;
    }

    /**
     * Проверка координаты клетки  на валидность. (т.е. координаты больше 0 и не выходят за пределы поля)
     * @param point
     * @return true, если координаты валидны
     */
    private boolean checkPoint(final Point point) {
        return checkCoordinate(point.x, filedSizeX) && checkCoordinate(point.y, filedSizeX);
    }

    /**
     * Проверка координаты клетки  на валидность. (т.е. координаты больше 0 и не выходят за пределы поля)
     * @return true, если координаты валидны
     */
    private boolean checkCoordinate(final int coordinate, final int maxCoordinate) {
        return coordinate >= MIN_COORDINATE && coordinate < maxCoordinate;
    }

}
