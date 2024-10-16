package org.thefall.episode1.gameplay.nextblock.info;

import org.thefall.episode1.gameplay.elements.tunnel.TunnelElement;
import org.thefall.episode1.gameplay.elements.tunnel.TunnelMapElementRetriever;
import org.thefall.episode1.gameplay.nextblock.Coordinates;
import org.thefall.episode1.gameplay.nextblock.GameDirection;
import org.thefall.episode1.gameplay.nextblock.builder.NextBlockMapBuilder;

public class NextBlockInfoCalculator {
    NextBlockMapBuilder nextBlockMapBuilder;
    TunnelMapElementRetriever tunnelMapElementRetriever;
    public NextBlockInfoCalculator(TunnelMapElementRetriever tunnelMapElementRetriever, NextBlockMapBuilder nextBlockMapBuilder){
        this.tunnelMapElementRetriever = tunnelMapElementRetriever;
        this.nextBlockMapBuilder = nextBlockMapBuilder;
    }
    public NextBlockInfo isNextBlockNonBlocking(String[][] mapTab, Coordinates currentCoordinates, Coordinates nextCoordinates, NextBlockInfo nextBlockInfo){
        nextBlockInfo.isANonBlockingBlock = false;
        nextBlockInfo.isAFunnelCase = false;
        TunnelElement startingTunnelElement = tunnelMapElementRetriever.getByStringValue(currentCoordinates.value);
        TunnelElement nextTunnelElement = tunnelMapElementRetriever.getByStringValue(nextCoordinates.value);
        if(nextTunnelElement == TunnelElement.DIRECTION_BLOCK) return nextBlockInfo;
        else if(nextTunnelElement == TunnelElement.DIRECTION_TWO_CURVES_REVERSE){
            if(currentCoordinates.direction == GameDirection.DOWN){
                nextCoordinates.direction = GameDirection.RIGHT;
                return funnelCase(mapTab, currentCoordinates, nextCoordinates, nextBlockInfo, nextTunnelElement);
            }else if(currentCoordinates.direction == GameDirection.RIGHT){
                nextCoordinates.direction = GameDirection.DOWN;
                return funnelCase(mapTab, currentCoordinates, nextCoordinates, nextBlockInfo, nextTunnelElement);
            }else return nextBlockInfo;
        }
        else if(nextTunnelElement == TunnelElement.DIRECTION_TWO_CURVES){
            if(currentCoordinates.direction == GameDirection.DOWN){
                nextCoordinates.direction = GameDirection.LEFT;
                return funnelCase(mapTab, currentCoordinates, nextCoordinates, nextBlockInfo, nextTunnelElement);
            }else if(currentCoordinates.direction == GameDirection.LEFT){
                nextCoordinates.direction = GameDirection.DOWN;
                return funnelCase(mapTab, currentCoordinates, nextCoordinates, nextBlockInfo, nextTunnelElement);
            }else return nextBlockInfo;
        }
        else {
            nextBlockInfo.isANonBlockingBlock = nextBlockMapBuilder.buildMap().get(startingTunnelElement).get(currentCoordinates.direction).contains(nextTunnelElement);
            return nextBlockInfo;
        }
    }

    private NextBlockInfo funnelCase(String[][] mapTab, Coordinates currentCoordinates, Coordinates nextCoordinates, NextBlockInfo nextBlockInfo, TunnelElement nextTunnelElement){
        nextBlockInfo.isANonBlockingBlock = getInfo(nextCoordinates, mapTab, nextTunnelElement);
        if(nextBlockInfo.isANonBlockingBlock) {
            currentCoordinates.nextCoordinates = nextCoordinates;
            nextBlockInfo.isAFunnelCase = true;
        }
        return nextBlockInfo;
    }

    private boolean getInfo(Coordinates nextCoordinates, String[][] mapTab, TunnelElement nextTunnelElement){
        try {
            String nextNextCordValue = getMapValue(mapTab, nextCoordinates);
            TunnelElement nextNextTunnelElement = tunnelMapElementRetriever.getByStringValue(nextNextCordValue);
            return nextBlockMapBuilder.buildMap().get(nextTunnelElement).get(nextCoordinates.direction).contains(nextNextTunnelElement);
        }catch (ArrayIndexOutOfBoundsException e){
            return false;
        }
    }



    private String getMapValue(String[][] mapTab, Coordinates nextCoordinates){
        if(nextCoordinates.direction == GameDirection.DOWN){
            return mapTab[nextCoordinates.cordY + 1][nextCoordinates.cordX];
        }else if(nextCoordinates.direction == GameDirection.RIGHT){
            return mapTab[nextCoordinates.cordY][nextCoordinates.cordX + 1];
        }else{
            return mapTab[nextCoordinates.cordY][nextCoordinates.cordX - 1];
        }
    }
}
