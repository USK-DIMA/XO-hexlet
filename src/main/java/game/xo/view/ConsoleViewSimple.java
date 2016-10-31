package game.xo.view;

import game.xo.model.Field;
import game.xo.controllers.CurrentMoveController;
import game.xo.controllers.MoveController;
import game.xo.controllers.WinnerController;
import game.xo.model.Figure;
import game.xo.model.Game;
import game.xo.model.Player;

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
