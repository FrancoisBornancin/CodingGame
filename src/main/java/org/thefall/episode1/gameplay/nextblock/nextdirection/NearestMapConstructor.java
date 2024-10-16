package org.thefall.episode1.gameplay.nextblock.nextdirection;

import org.thefall.episode1.gameplay.nextblock.Coordinates;
import org.thefall.episode1.gameplay.nextblock.GameDirection;

import java.util.Map;

public class NearestMapConstructor {
    public void constructNearestMap(GameDirection direction, int cordX, int cordY, Map<GameDirection, Coordinates> nearestValues, String[][] stringTab){
        try {
            nearestValues.put(direction, new Coordinates(cordX, cordY, stringTab[cordY][cordX]));
        }catch (ArrayIndexOutOfBoundsException e){}
    }
}
