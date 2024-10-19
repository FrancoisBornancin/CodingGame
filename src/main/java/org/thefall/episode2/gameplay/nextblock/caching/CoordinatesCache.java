package org.thefall.episode2.gameplay.nextblock.caching;

import org.thefall.episode2.gameplay.nextblock.Coordinates;
import org.thefall.episode2.gameplay.nextblock.GameDirection;

public class CoordinatesCache {
    public Coordinates coordinates;
    public String nextMapValue;
    public int index;
    public GameDirection gameDirection;

    public CoordinatesCache(Coordinates coordinates, int index, String nexMapValue) {
        this.coordinates = coordinates;
        this.index = index;
        this.nextMapValue = nexMapValue;
    }
}
