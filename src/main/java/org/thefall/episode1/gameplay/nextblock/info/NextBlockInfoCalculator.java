package org.thefall.episode1.gameplay.nextblock.info;

import org.thefall.episode1.gameplay.elements.exit.ExitDoor;
import org.thefall.episode1.gameplay.elements.tunnel.TunnelElement;
import org.thefall.episode1.gameplay.elements.tunnel.TunnelMapElementRetriever;
import org.thefall.episode1.gameplay.nextblock.Coordinates;
import org.thefall.episode1.gameplay.nextblock.GameDirection;
import org.thefall.episode1.gameplay.nextblock.builder.NextBlockMapBuilder;

import java.util.ArrayList;

public class NextBlockInfoCalculator {
    NextBlockMapBuilder nextBlockMapBuilder;
    TunnelMapElementRetriever tunnelMapElementRetriever;
    NextBlockInfo nextBlockInfo;
    ExitDoor exitDoor;
    public NextBlockInfoCalculator(TunnelMapElementRetriever tunnelMapElementRetriever, NextBlockMapBuilder nextBlockMapBuilder){
        this.tunnelMapElementRetriever = tunnelMapElementRetriever;
        this.nextBlockMapBuilder = nextBlockMapBuilder;
    }
    public NextBlockInfo isNextBlockNonBlocking(Coordinates currentCoordinates, NextBlockInfo nextBlockInfo, ExitDoor exitDoor, String[][] mapTab){
        nextBlockInfo.isANonBlockingBlock = false;
        this.nextBlockInfo = nextBlockInfo;
        this.exitDoor = exitDoor;
        return getInfo(currentCoordinates, nextBlockInfo, exitDoor, mapTab);
    }

    private NextBlockInfo getInfo(Coordinates currentCoordinates, NextBlockInfo nextBlockInfo, ExitDoor exitDoor, String[][] mapTab){
        try {
            String nextMapValue = getMapValue(mapTab, currentCoordinates);
            TunnelElement startingTunnelElement = tunnelMapElementRetriever.getByStringValue(currentCoordinates.value);
            TunnelElement nextTunnelElement = tunnelMapElementRetriever.getByStringValue(nextMapValue);
            Coordinates nextCoordinatesValues = nextBlockMapBuilder.buildMap().get(startingTunnelElement).get(currentCoordinates.direction).get(nextTunnelElement);
            if(nextBlockInfo.funnelCoordinates == null){
                nextBlockInfo.funnelCoordinates = new ArrayList<>();
            }
            nextCoordinatesValues.cordX = currentCoordinates.cordX + nextCoordinatesValues.cordX;
            nextCoordinatesValues.cordY = currentCoordinates.cordY + nextCoordinatesValues.cordY;
            Coordinates nextCoordinates = new Coordinates(nextCoordinatesValues.cordX, nextCoordinatesValues.cordY, nextCoordinatesValues.direction, nextCoordinatesValues.value);
            nextBlockInfo.funnelCoordinates.add(nextCoordinates);
            return isNextBlockNonBlocking(nextCoordinates, nextBlockInfo, exitDoor, mapTab);
        }catch (Exception e){
            if(currentCoordinates.cordX == exitDoor.cordX && currentCoordinates.cordY == exitDoor.cordY){
                nextBlockInfo.funnelCoordinates.add(currentCoordinates);
            }
            System.err.println("***** No next Coordinates possible *****");
            return nextBlockInfo;
        }
    }

    private String getMapValue(String[][] mapTab, Coordinates coordinates){
        if(coordinates.direction == GameDirection.DOWN){
            return mapTab[coordinates.cordY + 1][coordinates.cordX];
        }else if(coordinates.direction == GameDirection.LEFT){
            return mapTab[coordinates.cordY][coordinates.cordX - 1];
        }else {
            return mapTab[coordinates.cordY][coordinates.cordX + 1];
        }
    }


}
