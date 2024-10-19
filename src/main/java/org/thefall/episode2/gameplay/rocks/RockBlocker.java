package org.thefall.episode2.gameplay.rocks;


import org.thefall.episode2.gameplay.nextblock.Coordinates;
import org.thefall.episode2.gameplay.nextblock.FunnelCoordinatesListUpdater;
import org.thefall.episode2.gameplay.nextblock.WaitGameResponseIterator;

import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Optional;

public class RockBlocker {
    NearestRockFinder nearestRockFinder;
    WallBuilder wallBuilder;
    FunnelCoordinatesListUpdater funnelCoordinatesListUpdater;
    WaitGameResponseIterator waitGameResponseIterator;
    RockPathBuilder rockPathBuilder;
    String[][] mapTab;

    public RockBlocker(FunnelCoordinatesListUpdater funnelCoordinatesListUpdater, String[][] mapTab) {
        this.nearestRockFinder = new NearestRockFinder();
        this.wallBuilder = new WallBuilder();
        this.funnelCoordinatesListUpdater = funnelCoordinatesListUpdater;
        this.mapTab = mapTab;
        this.waitGameResponseIterator = new WaitGameResponseIterator();
        this.rockPathBuilder = new RockPathBuilder();
    }

    public void blockRock(List<Coordinates> rockList){
        if(!rockList.isEmpty()){
            List<Coordinates> heroNextCoordinatesList =
                    funnelCoordinatesListUpdater.funnelCoordinatesContainer.funnelCoordinates.stream()
                            .map(gameResponse -> gameResponse.coordinates)
                            .toList();
            Optional<Map<Coordinates, Integer>> optionalNearestRockMap = nearestRockFinder.findNearestRock(rockList, heroNextCoordinatesList, mapTab);
            if(optionalNearestRockMap.isPresent()){
                Map<Coordinates, Integer> nearestRockMap = optionalNearestRockMap.get();
                Coordinates nearestRock = nearestRockMap.keySet().stream().findFirst().get();
                rockPathBuilder.truncatePath(nearestRock, nearestRockMap.get(nearestRock));
                int waitIndex = waitGameResponseIterator.getNextWaitIndex(funnelCoordinatesListUpdater.funnelCoordinatesContainer.funnelCoordinates);
                Optional<Coordinates> optionalWallCoordinates = wallBuilder.buildWallFor(nearestRock, waitIndex);
                optionalWallCoordinates.ifPresent(coordinates -> funnelCoordinatesListUpdater.replaceNextFreeWaitResponse(coordinates, waitIndex));
                updateMap(mapTab);
            }
        }
    }

    private void updateMap(String[][] mapTab){
        this.funnelCoordinatesListUpdater.funnelCoordinatesContainer.funnelCoordinates.stream()
                .filter(gameResponse -> gameResponse.gameDirection != null)
                .forEach(gameResponse -> mapTab[gameResponse.coordinates.cordY][gameResponse.coordinates.cordX] = gameResponse.coordinates.value);
    }
}
