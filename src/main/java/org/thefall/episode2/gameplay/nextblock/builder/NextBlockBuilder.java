package org.thefall.episode2.gameplay.nextblock.builder;

import org.thefall.episode2.gameplay.nextblock.Coordinates;

public class NextBlockBuilder {
    public Coordinates buildNextCoordinates(Coordinates currentCoordinates, Coordinates newCoordinates){
        return new Coordinates(
                currentCoordinates.cordX + newCoordinates.cordX,
                currentCoordinates.cordY + newCoordinates.cordY,
                newCoordinates.direction,
                newCoordinates.value
        );
    }
}
