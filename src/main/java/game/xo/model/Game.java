package game.xo.model;

/**
 * Объект, содержащий в себе всё необходимое для игры, а именно игровое поле, игроков, ну и название игры.
 * Будет использоваться в одном из контроллеров
 */
public class Game {

    private final Player[] players;

    private final Field field;

    private final String name;

    public Game(final Player[] players,
                final Field field,
                final String name) {
        this.players = players;
        this.field = field;
        this.name = name;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Field getField() {
        return field;
    }

    public String getName() {
        return name;
    }

}
