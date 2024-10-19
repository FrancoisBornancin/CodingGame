package org.thefall.episode2.gameplay.rocks;

import org.thefall.episode2.gameplay.map.NextMapValueRetriever;
import org.thefall.episode2.gameplay.nextblock.Coordinates;
import org.thefall.episode2.gameplay.nextblock.builder.NextBlockBuilder;
import org.thefall.episode2.gameplay.nextblock.builder.NextCoordinatesRetriever;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class NearestRockFinder {
    RockPathBuilder rockPathBuilder;
    WallBuilder wallBuilder;
    WallIdentifier wallIdentifier;



    public NearestRockFinder() {
        this.rockPathBuilder = new RockPathBuilder();
        this.wallBuilder = new WallBuilder();
        this.wallIdentifier = new WallIdentifier();
    }

    public Optional<Map<Coordinates, Integer>> findNearestRock(List<Coordinates> rockList, List<Coordinates> heroNextCoordinates, String[][] mapTab){
        rockList.forEach(rockCoordinates -> rockCoordinates.nextCoordinates = rockPathBuilder.buildPath(rockCoordinates, mapTab, new ArrayList<>()));
        List<Coordinates> noWallRockList =
            rockList.stream()
                    .filter(rockCoordinates -> wallIdentifier.hasNoWall(rockCoordinates, mapTab))
                    .toList();

        Map<Coordinates, Integer> commonCordMap = getNearestRock(noWallRockList, heroNextCoordinates, mapTab);

        if(commonCordMap == null) return Optional.empty();
        else return Optional.of(commonCordMap);
    }

    private Map<Coordinates, Integer> getNearestRock(List<Coordinates> rockList, List<Coordinates> heroNextCoordinates, String[][] mapTab){
        final int[] minDist = {heroNextCoordinates.size()};
        final Coordinates[] coordinates = {null};
        rockList.forEach(rock -> {
            Optional<Map<Coordinates, Integer>> optionalCommonCoordinatesAndDist =
                    getCommonCoordinatesAndDist(rock, heroNextCoordinates, mapTab);
            if(optionalCommonCoordinatesAndDist.isPresent()){
                Map<Coordinates, Integer> commonCoordinatesAndDist = optionalCommonCoordinatesAndDist.get();
                if(commonCoordinatesAndDist.get(rock) < minDist[0]){
                    minDist[0] = commonCoordinatesAndDist.get(rock) - 1;
                    coordinates[0] = rock;
                }
            }
        });

        if(minDist[0] == heroNextCoordinates.size()) return null;
        else {
            Map<Coordinates, Integer> commonCordMap = new HashMap<>();
            commonCordMap.put(coordinates[0], minDist[0]);

            return commonCordMap;
        }
    }

    private Optional<Map<Coordinates, Integer>> getCommonCoordinatesAndDist  (Coordinates rock, List<Coordinates> heroNextCoordinates, String[][] mapTab){
        Map<Coordinates, Integer> commonCoordinatesAndDist = new HashMap<>();
        List<Coordinates> nextRockCoordinates = rock.nextCoordinates;

        int length = 0;
        if(heroNextCoordinates.size() < nextRockCoordinates.size()){
            length = heroNextCoordinates.size();
        }else length = nextRockCoordinates.size();

        for(int a = 0 ; a < length ; a++){
            Coordinates nextRockCoordinate = nextRockCoordinates.get(a);
            Coordinates heroNextCoordinate = heroNextCoordinates.get(a);
            if(heroNextCoordinate.cordX == nextRockCoordinate.cordX && heroNextCoordinate.cordY == nextRockCoordinate.cordY){
                if(commonCoordinatesAndDist.isEmpty()){
                    commonCoordinatesAndDist.put(rock, (a + 1));
                }
            }
        }
        if(commonCoordinatesAndDist.isEmpty()) return Optional.empty();
        else return Optional.of(commonCoordinatesAndDist);
    }
}
