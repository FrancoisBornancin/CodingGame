package org.dontpanic.episode1;

import org.dontpanic.episode1.gameinit.staticdata.InitializedData;
import org.dontpanic.episode1.gameinit.staticdata.StaticGameInitializedData;
import org.dontpanic.episode1.gameplay.elements.Elevator;
import org.dontpanic.episode1.gameplay.elements.FinishDoor;
import org.dontpanic.episode1.gameplay.elements.GameElementBuilder;
import org.dontpanic.episode1.gameplay.elements.GameElementsContainer;
import org.dontpanic.episode1.gameplay.elements.StartingDoor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameElementBuilderTest {
    @Test
    void itShouldInitElevatorsOfGameElementContainers(){
        GameElementBuilder gameElementBuilder = new GameElementBuilder();
        GameElementsContainer gameElementsContainer = new GameElementsContainer();
        StaticGameInitializedData staticGameInitializedData =
                new StaticGameInitializedData(
                        4,
                        5,
                        Map.of(
                                1, new ArrayList<>(List.of(0)),
                                2, new ArrayList<>(List.of(3)),
                                3, new ArrayList<>(List.of(1))
                        ),
                        Map.of(0, 4),
                        12
                );

        InitializedData initializedData = new InitializedData();
        initializedData.staticGameInitializedData = staticGameInitializedData;
        initializedData.startingDoor = new StartingDoor(4, 3);

        gameElementBuilder.initElementContainers(gameElementsContainer, initializedData);

        Assertions.assertEquals(3, gameElementsContainer.elevatorList.size());

        Elevator elevator1 =
                gameElementsContainer.elevatorList.stream()
                        .filter(elevator -> elevator.cordY == 1)
                        .findFirst().get();

        Elevator elevator2 =
                gameElementsContainer.elevatorList.stream()
                        .filter(elevator -> elevator.cordY == 2)
                        .findFirst().get();

        Elevator elevator3 =
                gameElementsContainer.elevatorList.stream()
                        .filter(elevator -> elevator.cordY == 3)
                        .findFirst().get();

        Assertions.assertNotNull(elevator1);
        Assertions.assertNotNull(elevator2);
        Assertions.assertNotNull(elevator3);

    }

    @Test
    void itShouldInitFinishDoorOfGameElementContainers(){
        GameElementBuilder gameElementBuilder = new GameElementBuilder();
        GameElementsContainer gameElementsContainer = new GameElementsContainer();
        StaticGameInitializedData staticGameInitializedData =
                new StaticGameInitializedData(
                        4,
                        5,
                        Map.of(
                                1, new ArrayList<>(List.of(0)),
                                2, new ArrayList<>(List.of(3)),
                                3, new ArrayList<>(List.of(1))
                        ),
                        Map.of(0, 4),
                        12
                );

        InitializedData initializedData = new InitializedData();
        initializedData.staticGameInitializedData = staticGameInitializedData;
        initializedData.startingDoor = new StartingDoor(0, 0);

        gameElementBuilder.initElementContainers(gameElementsContainer, initializedData);

        FinishDoor finishDoor = gameElementsContainer.finishDoor;

        Assertions.assertNotNull(finishDoor);
        Assertions.assertEquals(0, finishDoor.cordY);
        Assertions.assertEquals(4, finishDoor.cordX);
    }

    @Test
    void itShouldInitStartingDoorOfGameElementContainers(){
        GameElementBuilder gameElementBuilder = new GameElementBuilder();
        GameElementsContainer gameElementsContainer = new GameElementsContainer();
        StaticGameInitializedData staticGameInitializedData =
                new StaticGameInitializedData(
                        4,
                        5,
                        Map.of(
                                1, new ArrayList<>(List.of(0)),
                                2, new ArrayList<>(List.of(3)),
                                3, new ArrayList<>(List.of(1))
                        ),
                        Map.of(0, 4),
                        12
                );

        InitializedData initializedData = new InitializedData();
        initializedData.staticGameInitializedData = staticGameInitializedData;
        initializedData.startingDoor = new StartingDoor(3, 3);

        gameElementBuilder.initElementContainers(gameElementsContainer, initializedData);

        StartingDoor finalStartingDoor = gameElementsContainer.startingDoor;

        Assertions.assertNotNull(finalStartingDoor);
        Assertions.assertEquals(3, finalStartingDoor.cordY);
        Assertions.assertEquals(3, finalStartingDoor.cordX);
    }

}
