package io.hexlet.xo.view;

import io.hexlet.xo.controllers.CurrentMoveController;
import io.hexlet.xo.controllers.MoveController;
import io.hexlet.xo.controllers.WinnerController;
import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Game;
import io.hexlet.xo.model.Player;

/**
 * Created by Dmitry on 31.10.2016.
 */
public class ConsoleViewSimple {

    public void start() {
        Player p1 = new Player("Player 1", Figure.X);
        Player p2 = new Player("Player 2", Figure.O);
        Field field = new Field(3);
        Game game = new Game(new Player[]{p1, p2}, field, "Simple Game");
        CurrentMoveController currentMoveController = new CurrentMoveController(null);
        MoveController moveController = new MoveController(null);
        WinnerController winnerController = new WinnerController(null);
    }

}
