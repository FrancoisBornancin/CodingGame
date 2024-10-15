package org.dontpanic.episode1;

import org.dontpanic.episode1.gameplay.clone.Clone;
import org.dontpanic.episode1.gameplay.clone.CloneDirection;
import org.dontpanic.episode1.gameplay.clone.CloneInitializer;
import org.dontpanic.episode1.gameplay.clone.CloneQualifier;
import org.dontpanic.episode1.gameplay.clone.CloneState;
import org.dontpanic.episode1.gameplay.elements.GameElementsContainer;
import org.dontpanic.episode1.gameplay.elements.StartingDoor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CloneInitializerTest {
    @Test
    void cloneShouldBeAddedBasedOnExitDoorCoordinates(){
        Clone clone1 = new Clone(1, 6, CloneQualifier.LEADING_CLONE, CloneState.NOT_BLOCKED, CloneDirection.RIGHT);
        Clone clone2 = new Clone(3, 3, CloneQualifier.SOLDIER_CLONE, CloneState.NOT_BLOCKED, CloneDirection.RIGHT);
        Clone clone3 = new Clone(7, 2, CloneQualifier.SOLDIER_CLONE, CloneState.NOT_BLOCKED, CloneDirection.RIGHT);

        CloneInitializer cloneInitializer = new CloneInitializer();
        GameElementsContainer gameElementsContainer = new GameElementsContainer();
        gameElementsContainer.cloneList =
                new ArrayList<>(
                        List.of(clone1, clone2, clone3)
                );;
        gameElementsContainer.startingDoor = new StartingDoor(7, 1);

        cloneInitializer.addNewClone(gameElementsContainer, CloneDirection.RIGHT);

        Clone newClone =
                gameElementsContainer.cloneList.stream()
                    .filter(clone -> clone.cordY == 1)
                    .findFirst().get();

        Assertions.assertEquals(4, gameElementsContainer.cloneList.size());
        Assertions.assertEquals(gameElementsContainer.startingDoor.cordX, newClone.cordX);
        Assertions.assertEquals(gameElementsContainer.startingDoor.cordY, newClone.cordY);
    }

    @Test
    void newCloneShouldBeSoldierIfListIsNotEmpty(){
        Clone clone1 = new Clone(1, 6, CloneQualifier.LEADING_CLONE, CloneState.NOT_BLOCKED, CloneDirection.RIGHT);
        Clone clone2 = new Clone(3, 3, CloneQualifier.SOLDIER_CLONE, CloneState.NOT_BLOCKED, CloneDirection.RIGHT);
        Clone clone3 = new Clone(7, 2, CloneQualifier.SOLDIER_CLONE, CloneState.NOT_BLOCKED, CloneDirection.RIGHT);

        CloneInitializer cloneInitializer = new CloneInitializer();
        GameElementsContainer gameElementsContainer = new GameElementsContainer();
        gameElementsContainer.cloneList =
                new ArrayList<>(
                        List.of(clone1, clone2, clone3)
                );
        gameElementsContainer.startingDoor = new StartingDoor(7, 1);

        cloneInitializer.addNewClone(gameElementsContainer, CloneDirection.RIGHT);

        Clone newClone =
                gameElementsContainer.cloneList.stream()
                        .filter(clone -> clone.cordY == 1)
                        .findFirst().get();

        Assertions.assertEquals(CloneQualifier.SOLDIER_CLONE, newClone.qualifier);
    }

    @Test
    void newCloneShouldBeLeadingCloneIfNotBlockedClonesListIsEmpty(){
        Clone blockClone = new Clone(3, 3, CloneQualifier.SOLDIER_CLONE, CloneState.BLOCKED, CloneDirection.RIGHT);

        CloneInitializer cloneInitializer = new CloneInitializer();
        GameElementsContainer gameElementsContainer = new GameElementsContainer();
        gameElementsContainer.cloneList = new ArrayList<>(List.of(blockClone));
        gameElementsContainer.startingDoor = new StartingDoor(7, 1);

        cloneInitializer.addNewClone(gameElementsContainer, CloneDirection.RIGHT);

        Clone newClone =
                gameElementsContainer.cloneList.stream()
                        .filter(clone -> clone.cordY == 1)
                        .findFirst().get();

        Assertions.assertEquals(CloneQualifier.LEADING_CLONE, newClone.qualifier);
    }

    @Test
    void newCloneShouldBeNotBlocked(){
        Clone clone1 = new Clone(1, 6, CloneQualifier.LEADING_CLONE, CloneState.NOT_BLOCKED, CloneDirection.RIGHT);
        Clone clone2 = new Clone(3, 3, CloneQualifier.SOLDIER_CLONE, CloneState.NOT_BLOCKED, CloneDirection.RIGHT);
        Clone clone3 = new Clone(7, 2, CloneQualifier.SOLDIER_CLONE, CloneState.NOT_BLOCKED, CloneDirection.RIGHT);

        CloneInitializer cloneInitializer = new CloneInitializer();
        GameElementsContainer gameElementsContainer = new GameElementsContainer();
        gameElementsContainer.cloneList =
                new ArrayList<>(
                    List.of(clone1, clone2, clone3)
                );
        gameElementsContainer.startingDoor = new StartingDoor(7, 1);

        cloneInitializer.addNewClone(gameElementsContainer, CloneDirection.RIGHT);

        Clone newClone =
                gameElementsContainer.cloneList.stream()
                        .filter(clone -> clone.cordY == 1)
                        .findFirst().get();

        Assertions.assertEquals(CloneState.NOT_BLOCKED, newClone.state);
    }

    @Test
    void newCloneShouldLinkedPreviousClone(){
        Clone clone1 = new Clone(1, 6, CloneQualifier.LEADING_CLONE, CloneState.NOT_BLOCKED, CloneDirection.RIGHT);
        Clone clone2 = new Clone(3, 3, CloneQualifier.SOLDIER_CLONE, CloneState.NOT_BLOCKED, CloneDirection.RIGHT);
        Clone clone3 = new Clone(7, 2, CloneQualifier.SOLDIER_CLONE, CloneState.NOT_BLOCKED, CloneDirection.RIGHT);

        clone1.previousClone = clone2;
        clone2.previousClone = clone3;

        CloneInitializer cloneInitializer = new CloneInitializer();
        GameElementsContainer gameElementsContainer = new GameElementsContainer();
        gameElementsContainer.cloneList =
                new ArrayList<>(
                        List.of(clone1, clone2, clone3)
                );
        gameElementsContainer.startingDoor = new StartingDoor(7, 1);

        cloneInitializer.addNewClone(gameElementsContainer, CloneDirection.RIGHT);

        Clone newClone =
                gameElementsContainer.cloneList.stream()
                        .filter(clone -> clone.cordY == 1)
                        .findFirst().get();

        Assertions.assertEquals(clone3.previousClone, newClone);
    }
}
