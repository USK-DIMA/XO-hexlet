package io.hexlet.xo.model;

/**
 * Объект-игрок
 */
public class Player {

    private final String name;

    private final Figure figure;

    public Player(final String name,
                  final Figure figure) {
        this.name = name;
        this.figure = figure;
    }

    public String getName() {
        return name;
    }

    public Figure getFigure() {
        return figure;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Player)){
            return false;
        }
        Player p = (Player) obj;
        return this.name.equals(p.name) && this.figure.equals(p.figure);
    }
}
