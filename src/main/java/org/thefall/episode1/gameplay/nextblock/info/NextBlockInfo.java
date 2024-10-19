package org.thefall.episode1.gameplay.nextblock.info;

import org.thefall.episode1.gameplay.nextblock.Coordinates;

import java.util.List;

public class NextBlockInfo {
    public boolean isANonBlockingBlock;
    public List<Coordinates> funnelCoordinates;
    public void printFirst(Coordinates currentCoordinates){
        Coordinates coordinates = funnelCoordinates.get(0);
        System.out.println(coordinates.cordX + " " + coordinates.cordY);
        funnelCoordinates.remove(0);
        currentCoordinates.cordX = coordinates.cordX;
        currentCoordinates.cordY = coordinates.cordY;
    }
}
