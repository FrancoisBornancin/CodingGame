package org.thefall.episode2.gameplay.nextblock;

import org.thefall.episode2.gameplay.elements.support.BaseElement;

import java.util.List;

public class Coordinates extends BaseElement {
    public String value;

    public GameDirection direction;
    public Coordinates previousCoordinates;
    public List<Coordinates> nextCoordinates;

    public Coordinates(int cordX, int cordY, String value) {
        super(cordX, cordY);
        this.value = value;
    }
    public Coordinates(int cordX, int cordY, GameDirection gameDirection) {
        super(cordX, cordY);
        this.direction = gameDirection;
    }

    public Coordinates(int cordX, int cordY, GameDirection gameDirection, String value) {
        super(cordX, cordY);
        this.direction = gameDirection;
        this.value = value;
    }

    public Coordinates(int cordX, int cordY) {
        super(cordX, cordY);
    }

    public Coordinates(Coordinates coordinates) {
        super(coordinates.cordX, coordinates.cordY);
        this.direction = coordinates.direction;
        this.value = coordinates.value;
    }
}
