package io.hexlet.xo.model;


import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class Field {

    private static final int DEFAULT_FIELD_SIZE=3;

    private static final int MIN_COORDINATE = 0;

    private final Figure[][] field;

    private final int filedSizeX;

    private final int filedSizeY;



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

    public Figure getFigure(final Point point) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        return field[point.x][point.y];
    }

    public void setFigure(final Point point, final Figure figure) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        field[point.x][point.y] = figure;
    }

    private boolean checkPoint(final Point point) {
        return checkCoordinate(point.x, filedSizeX) && checkCoordinate(point.y, filedSizeX);
    }

    private boolean checkCoordinate(final int coordinate, final int maxCoordinate) {
        return coordinate >= MIN_COORDINATE && coordinate < maxCoordinate;
    }

}
