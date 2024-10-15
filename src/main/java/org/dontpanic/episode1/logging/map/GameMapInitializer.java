package org.dontpanic.episode1.logging.map;

import org.dontpanic.episode1.gameinit.staticdata.InitializedData;
import org.dontpanic.episode1.gameinit.staticdata.StaticGameInitializedData;
import org.dontpanic.episode1.gameplay.elements.GameElementsContainer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameMapInitializer {
    public List<String> initMap(InitializedData initializedData){
        GameMapBuilder gameMapBuilder = new GameMapBuilder();
        StaticGameInitializedData staticData = initializedData.staticGameInitializedData;
        char[][] charTab = gameMapBuilder.initCharTab(staticData.mapWidth, staticData.nbFloors);
        gameMapBuilder.initMap(charTab);
        gameMapBuilder.putElevatorsInMap(staticData.elevatorsMap, charTab);
        gameMapBuilder.putFinishDoorInMap(staticData.finishDoor, charTab);
        gameMapBuilder.putStartingCloneInfoInMap(initializedData.startingDoor, charTab);

        List<String> listToReverse = new ArrayList<>(gameMapBuilder.convertMapCharTabToList(charTab));
        Collections.reverse(listToReverse);
        return listToReverse;
    }
}
