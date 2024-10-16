package org.thefall.episode1.gameplay.nextblock.nextdirection;

import org.thefall.episode1.gameplay.nextblock.Coordinates;
import org.thefall.episode1.gameplay.nextblock.GameDirection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NextDirectionCalculator{
    private NearestMapConstructor nearestMapConstructor;
    public NextDirectionCalculator(){
        this.nearestMapConstructor = new NearestMapConstructor();
    }
    public Map<GameDirection, Set<GameDirection>> directionsRegardingPrevious =
            Map.of(
                    GameDirection.RIGHT,
                    Set.of(
                            GameDirection.RIGHT,
                            GameDirection.DOWN
                    ),
                    GameDirection.LEFT,
                    Set.of(
                            GameDirection.LEFT,
                            GameDirection.DOWN
                    ),
                    GameDirection.DOWN,
                    Set.of(
                            GameDirection.RIGHT,
                            GameDirection.DOWN,
                            GameDirection.LEFT
                    )
            );

    public Map<GameDirection, Coordinates> getNearestDirections(Coordinates coordinates, String[][] stringTab){
        Map<GameDirection, Coordinates> nearestValues = new HashMap<>();
        if(coordinates.direction == null){
            nearestMapConstructor.constructNearestMap(
                    GameDirection.RIGHT,
                    coordinates.cordX + 1,
                    coordinates.cordY,
                    nearestValues,
                    stringTab
            );
            nearestMapConstructor.constructNearestMap(
                    GameDirection.LEFT,
                    coordinates.cordX - 1,
                    coordinates.cordY,
                    nearestValues,
                    stringTab
            );
            nearestMapConstructor.constructNearestMap(
                    GameDirection.DOWN,
                    coordinates.cordX,
                    coordinates.cordY + 1,
                    nearestValues,
                    stringTab
            );
        }else{
            directionsRegardingPrevious.get(coordinates.direction).stream()
                    .forEach(direction -> {
                        if(direction == GameDirection.RIGHT) {
                            nearestMapConstructor.constructNearestMap(
                                    GameDirection.RIGHT,
                                    coordinates.cordX + 1,
                                    coordinates.cordY,
                                    nearestValues,
                                    stringTab
                            );
                        }
                        else if(direction == GameDirection.LEFT){
                            nearestMapConstructor.constructNearestMap(
                                    GameDirection.LEFT,
                                    coordinates.cordX - 1,
                                    coordinates.cordY,
                                    nearestValues,
                                    stringTab
                            );
                        }else{
                            nearestMapConstructor.constructNearestMap(
                                    GameDirection.DOWN,
                                    coordinates.cordX,
                                    coordinates.cordY + 1,
                                    nearestValues,
                                    stringTab
                            );
                        }
                    });
        }
        return nearestValues;
    }
}
