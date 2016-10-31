package game.xo;

import game.xo.model.Field;
import game.xo.model.Figure;
import game.xo.model.exceptions.InvalidPointException;

import java.awt.*;

/**
 * Created by Dmitry on 05.07.2015.
 */
public class TestHelper {

    public static Field fieldGenerator(String[][] figure, int fieldSizeX, int fieldSizeY) throws InvalitInputFigureException{

        Field field = new Field(fieldSizeX, fieldSizeY);

        for(int i=0; i<fieldSizeX; i++){
            for(int j=0; j<fieldSizeY; j++){
                Figure fig;

                switch (figure[i][j].toString()) {
                 case "X" :   fig = Figure.X;
                    break;

                case "O" :   fig = Figure.O;
                    break;

                case " " :   fig = null;
                    break;

                default: throw new InvalitInputFigureException();

                }

                try {
                    field.setFigure(new Point(i, j), fig);
                } catch (InvalidPointException e) {
                    new RuntimeException("InvalidPointException");
                }
            }
        }

        return field;
    }
}
