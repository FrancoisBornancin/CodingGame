package org.thefall.episode2.gameplay.nextblock.caching;

import org.thefall.episode2.gameplay.nextblock.Coordinates;
import org.thefall.episode2.gameplay.nextblock.GameDirection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CoordinatesCacheRetriever {
    public List<CoordinatesCache> coordinatesCacheListToRetrieve;
    public List<CoordinatesCache> coordinatesCacheListBeinRemoved;
    private Map<Integer, GameDirection> directionToMoveMap =
        Map.of(
                1, GameDirection.LEFT,
                2, GameDirection.RIGHT,
                3, GameDirection.REVERSE
        );

    public void addCoordinates(Coordinates coordinates, String nextMapValue){
        if(coordinatesCacheListToRetrieve == null) coordinatesCacheListToRetrieve = new ArrayList<>();

        Optional<CoordinatesCache> optionalCoordinatesCacheFromListToRetrieve = this.get(coordinates, coordinatesCacheListToRetrieve);
        Optional<CoordinatesCache> optionalCoordinatesCacheFromListBeinRemoved = this.get(coordinates, coordinatesCacheListBeinRemoved);

        if(optionalCoordinatesCacheFromListToRetrieve.isEmpty() && optionalCoordinatesCacheFromListBeinRemoved.isEmpty()){
            addCoordinatesToList(coordinates, nextMapValue);
        }else if(optionalCoordinatesCacheFromListToRetrieve.isPresent()){
            CoordinatesCache coordinatesCache = optionalCoordinatesCacheFromListToRetrieve.get();
            if(coordinatesCache.coordinates.direction != coordinates.direction){
                addCoordinatesToList(coordinates, nextMapValue);
            }
        } else{
            CoordinatesCache coordinatesCache = optionalCoordinatesCacheFromListBeinRemoved.get();
            if(coordinatesCache.coordinates.direction != coordinates.direction){
                addCoordinatesToList(coordinates, nextMapValue);
            }
        }
    }

    private void addCoordinatesToList(Coordinates coordinates, String nextMapValue){
        CoordinatesCache coordinatesCache = new CoordinatesCache(coordinates, 0, nextMapValue);
        coordinatesCacheListToRetrieve.add(coordinatesCache);
    }

    private Optional<CoordinatesCache> get(Coordinates coordinates, List<CoordinatesCache> coordinatesCacheList){
        if(coordinatesCacheList == null) return Optional.empty();
        return coordinatesCacheList.stream()
                .filter(coordinatesCache -> coordinatesCache.coordinates.cordX == coordinates.cordX && coordinatesCache.coordinates.cordY == coordinates.cordY)
                .findFirst();
    }

    public Optional<CoordinatesCache> getOptional(Coordinates coordinates){
        if(coordinatesCacheListToRetrieve == null) return Optional.empty();
        return coordinatesCacheListToRetrieve.stream()
                .filter(coordinatesCache -> coordinatesCache.coordinates.cordX == coordinates.cordX && coordinatesCache.coordinates.cordY == coordinates.cordY)
                .findFirst();
    }

    public CoordinatesCache getLast(){
        if(coordinatesCacheListBeinRemoved == null) coordinatesCacheListBeinRemoved = new ArrayList<>();
        if(!coordinatesCacheListToRetrieve.isEmpty()){
            int lastIndex = coordinatesCacheListToRetrieve.size() - 1;
            CoordinatesCache coordinatesCache = coordinatesCacheListToRetrieve.get(lastIndex);
            coordinatesCache.index++;
            coordinatesCache.gameDirection = directionToMoveMap.get(coordinatesCache.index);

            if(coordinatesCache.index == 4) {
                coordinatesCacheListBeinRemoved.add(coordinatesCache);
                coordinatesCacheListToRetrieve.remove(lastIndex);

                removeIndexesValueThree();

                if(!coordinatesCacheListToRetrieve.isEmpty()){
                    int newLastIndex = coordinatesCacheListToRetrieve.size() - 1;
                    CoordinatesCache otherCoordinatesCache = coordinatesCacheListToRetrieve.get(newLastIndex);
                    otherCoordinatesCache.index++;
                    otherCoordinatesCache.gameDirection = directionToMoveMap.get(otherCoordinatesCache.index);

                    return coordinatesCacheListToRetrieve.get(newLastIndex);
                }else return null;
            }

            return coordinatesCache;
        }
        return null;
    }

    private void removeIndexesValueThree(){
        List<CoordinatesCache> cacheListToRemove =
            this.coordinatesCacheListToRetrieve.stream()
                    .filter(coordinatesCache -> coordinatesCache.index == 3)
                    .toList();

        coordinatesCacheListBeinRemoved.addAll(cacheListToRemove);
        coordinatesCacheListToRetrieve.removeAll(cacheListToRemove);
    }
}
