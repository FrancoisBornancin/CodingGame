package org.dontpanic.episode1.gameplay.elements;

import org.dontpanic.episode1.gameinit.staticdata.InitializedData;
import org.dontpanic.episode1.gameinit.staticdata.StaticGameInitializedData;

public class GameElementBuilder {
    public void initElementContainers(GameElementsContainer gameElementsContainer, InitializedData initializedData){
        StaticGameInitializedData staticData = initializedData.staticGameInitializedData;
        gameElementsContainer.elevatorList =
                staticData.elevatorsMap.keySet().stream()
                        .map(key -> new Elevator(staticData.elevatorsMap.get(key).get(0), key))
                        .toList();

        gameElementsContainer.startingDoor = initializedData.startingDoor;

        int finishDoorCordY =
                staticData.finishDoor.keySet().stream().toList()
                        .get(0);

        gameElementsContainer.finishDoor =
                new FinishDoor(
                        staticData.finishDoor.get(finishDoorCordY),
                        finishDoorCordY
                );
    }
}
