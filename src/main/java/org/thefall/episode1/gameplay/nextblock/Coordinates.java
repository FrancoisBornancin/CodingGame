package org.thefall.episode1.gameplay.nextblock;

import org.thefall.episode1.gameplay.elements.support.BaseElement;

import java.util.ArrayList;
import java.util.List;

public class Coordinates extends BaseElement {
    public String value;
    public List<Coordinates> nextCoordinatesList = new ArrayList<>();
    public List<Coordinates> previousCoordinatesList = new ArrayList<>();

    public GameDirection direction;
    public Coordinates nextCoordinates;

    public Coordinates(int cordX, int cordY, String value) {
        super(cordX, cordY);
        this.value = value;
    }
}
