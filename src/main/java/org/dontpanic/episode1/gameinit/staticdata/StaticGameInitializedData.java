package org.dontpanic.episode1.gameinit.staticdata;

import java.util.List;
import java.util.Map;

public class StaticGameInitializedData {
    public int nbFloors;
    public int mapWidth;
    public Map<Integer, List<Integer>> elevatorsMap;
    public Map<Integer, Integer> finishDoor;
    public int maxNbRounds;

    public StaticGameInitializedData(int nbFloors,
                                     int mapWidth,
                                     Map<Integer, List<Integer>> elevatorsMap,
                                     Map<Integer, Integer> finishDoor,
                                     int maxNbRounds
    ) {
        this.nbFloors = nbFloors;
        this.mapWidth = mapWidth;
        this.elevatorsMap = elevatorsMap;
        this.finishDoor = finishDoor;
        this.maxNbRounds = maxNbRounds;
    }
}
