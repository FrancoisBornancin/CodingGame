package org.thefall.episode2.gameplay.map;

import org.thefall.episode2.gameplay.nextblock.Coordinates;
import org.thefall.episode2.gameplay.nextblock.GameDirection;

public class NextMapValueRetriever {
    public String getMapValue(Coordinates coordinates, String[][] mapTab){
        try {
            if(coordinates.direction == GameDirection.DOWN) return mapTab[coordinates.cordY + 1][coordinates.cordX];
            else if(coordinates.direction == GameDirection.LEFT) return mapTab[coordinates.cordY][coordinates.cordX - 1];
            else return mapTab[coordinates.cordY][coordinates.cordX + 1];
        }catch (ArrayIndexOutOfBoundsException e){
            return "0";
        }
    }
}
