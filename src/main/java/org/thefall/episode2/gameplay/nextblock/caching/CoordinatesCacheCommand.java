package org.thefall.episode2.gameplay.nextblock.caching;

import org.thefall.episode2.gameplay.GameResponse;
import org.thefall.episode2.gameplay.nextblock.Coordinates;
import org.thefall.episode2.gameplay.nextblock.info.MovableBlockQualifier;
import org.thefall.episode2.gameplay.nextblock.info.FunnelCoordinatesContainer;

import java.util.ArrayList;
import java.util.List;

public class CoordinatesCacheCommand {
    public CoordinatesCacheRetriever coordinatesCacheRetriever;
    MovableBlockQualifier movableBlockQualifier;
    FunnelCoordinatesContainer funnelCoordinatesContainer;

    public CoordinatesCacheCommand(
            CoordinatesCacheRetriever coordinatesCacheRetriever,
            MovableBlockQualifier movableBlockQualifier,
            FunnelCoordinatesContainer funnelCoordinatesContainer
    ){
        this.coordinatesCacheRetriever = coordinatesCacheRetriever;
        this.movableBlockQualifier = movableBlockQualifier;
        this.funnelCoordinatesContainer = funnelCoordinatesContainer;
    }

    public void insert(Coordinates movableCoordinate, String nextMapValue){
        if(movableCoordinate != null && movableBlockQualifier.isMovable(nextMapValue)){
            Coordinates movableCoordinateCopy = new Coordinates(movableCoordinate.cordX, movableCoordinate.cordY, movableCoordinate.direction, movableCoordinate.value);
            coordinatesCacheRetriever.addCoordinates(movableCoordinateCopy, nextMapValue);
        }
    }

    public CoordinatesCache getLast(){
        try {
            CoordinatesCache coordinatesCache = coordinatesCacheRetriever.getLast();
            if(funnelCoordinatesContainer.funnelCoordinates != null){
                int indexToStartRemove = getIndexToStartRemove(coordinatesCache);
                if(indexToStartRemove != -1){
                    List<GameResponse> responseListToRemove = new ArrayList<>();
                    for(int a = indexToStartRemove; a < funnelCoordinatesContainer.funnelCoordinates.size() ; a++){
                        responseListToRemove.add(funnelCoordinatesContainer.funnelCoordinates.get(a));
                    }
                    funnelCoordinatesContainer.funnelCoordinates.removeAll(responseListToRemove);
                }
            }

            return coordinatesCache;
        }catch (NullPointerException e){
            return null;
        }
    }

    private int getIndexToStartRemove(CoordinatesCache coordinatesFromCache){
        for(int a = 0; a < funnelCoordinatesContainer.funnelCoordinates.size() ; a++){
            Coordinates funnelCoordinates = funnelCoordinatesContainer.funnelCoordinates.get(a).coordinates;
            if(funnelCoordinates.cordX == coordinatesFromCache.coordinates.cordX && funnelCoordinates.cordY == coordinatesFromCache.coordinates.cordY
            ){
                return a + 1;
            }
        }
        return -1;
    }
}
