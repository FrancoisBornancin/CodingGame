package org.dontpanic.episode1;

import org.dontpanic.episode1.gameplay.clone.Clone;
import org.dontpanic.episode1.gameplay.clone.CloneCoordinatesDirectionUpdater;
import org.dontpanic.episode1.gameplay.clone.CloneDirection;
import org.dontpanic.episode1.gameplay.clone.CloneQualifier;
import org.dontpanic.episode1.gameplay.clone.CloneState;
import org.dontpanic.episode1.gameplay.coordinates.YAxisDirection;
import org.dontpanic.episode1.gameplay.coordinates.YAxisDirectionCalculator;
import org.dontpanic.episode1.gameplay.elements.Elevator;
import org.dontpanic.episode1.gameplay.elements.FinishDoor;
import org.dontpanic.episode1.gameplay.elements.GameElementsContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CloneCoordinatesDirectionUpdaterTest {
    @Test
    void itShouldUpdatesCoordinatesRegardingLeftDirection(){
        Clone clone1 = new Clone(1, 6, CloneQualifier.LEADING_CLONE, CloneState.NOT_BLOCKED, CloneDirection.LEFT);
        Clone clone2 = new Clone(3, 3, CloneQualifier.SOLDIER_CLONE, CloneState.NOT_BLOCKED, CloneDirection.LEFT);
        Clone clone3 = new Clone(7, 2, CloneQualifier.SOLDIER_CLONE, CloneState.NOT_BLOCKED, CloneDirection.LEFT);

        GameElementsContainer gameElementsContainer = new GameElementsContainer();
        gameElementsContainer.cloneList = List.of(clone1, clone2, clone3);;
        gameElementsContainer.elevatorList = List.of();

        CloneCoordinatesDirectionUpdater cloneCoordinatesDirectionUpdater = new CloneCoordinatesDirectionUpdater();
        cloneCoordinatesDirectionUpdater.updateClonesCoordinatesAndDirection(gameElementsContainer);
        Assertions.assertEquals(0, clone1.cordX);
        Assertions.assertEquals(2, clone2.cordX);
        Assertions.assertEquals(6, clone3.cordX);
    }

    @Test
    void itShouldUpdatesCoordinatesRegardingRightDirection(){
        Clone clone1 = new Clone(1, 6, CloneQualifier.LEADING_CLONE, CloneState.NOT_BLOCKED, CloneDirection.RIGHT);
        Clone clone2 = new Clone(3, 3, CloneQualifier.SOLDIER_CLONE, CloneState.NOT_BLOCKED, CloneDirection.RIGHT);
        Clone clone3 = new Clone(7, 2, CloneQualifier.SOLDIER_CLONE, CloneState.NOT_BLOCKED, CloneDirection.RIGHT);

        GameElementsContainer gameElementsContainer = new GameElementsContainer();
        gameElementsContainer.cloneList = List.of(clone1, clone2, clone3);;
        gameElementsContainer.elevatorList = List.of();

        CloneCoordinatesDirectionUpdater cloneCoordinatesDirectionUpdater = new CloneCoordinatesDirectionUpdater();
        cloneCoordinatesDirectionUpdater.updateClonesCoordinatesAndDirection(gameElementsContainer);

        Assertions.assertEquals(2, clone1.cordX);
        Assertions.assertEquals(4, clone2.cordX);
        Assertions.assertEquals(8, clone3.cordX);
    }

    @Test
    void itShouldNotUpdateBlockedClones(){
        Clone clone1 = new Clone(1, 6, CloneQualifier.LEADING_CLONE, CloneState.BLOCKED, CloneDirection.LEFT);
        Clone clone2 = new Clone(3, 3, CloneQualifier.SOLDIER_CLONE, CloneState.BLOCKED, CloneDirection.LEFT);
        Clone clone3 = new Clone(7, 2, CloneQualifier.SOLDIER_CLONE, CloneState.BLOCKED, CloneDirection.LEFT);

        GameElementsContainer gameElementsContainer = new GameElementsContainer();
        gameElementsContainer.cloneList = List.of(clone1, clone2, clone3);;
        gameElementsContainer.elevatorList = List.of();

        CloneCoordinatesDirectionUpdater cloneCoordinatesDirectionUpdater = new CloneCoordinatesDirectionUpdater();
        cloneCoordinatesDirectionUpdater.updateClonesCoordinatesAndDirection(gameElementsContainer);

        Assertions.assertEquals(1, clone1.cordX);
        Assertions.assertEquals(3, clone2.cordX);
        Assertions.assertEquals(7, clone3.cordX);

        Assertions.assertEquals(6, clone1.cordY);
        Assertions.assertEquals(3, clone2.cordY);
        Assertions.assertEquals(2, clone3.cordY);
    }

    @Test
    void itShouldOnlyUpdateYCoordinatesWhenOnElevators(){
        Clone clone2 = new Clone(3, 3, CloneQualifier.SOLDIER_CLONE, CloneState.NOT_BLOCKED, CloneDirection.LEFT);
        Clone clone3 = new Clone(7, 2, CloneQualifier.SOLDIER_CLONE, CloneState.NOT_BLOCKED, CloneDirection.LEFT);

        GameElementsContainer gameElementsContainer = new GameElementsContainer();
        gameElementsContainer.cloneList = List.of(clone2, clone3);
        gameElementsContainer.finishDoor = new FinishDoor(0, 0);
        gameElementsContainer.elevatorList =
                List.of(
                        new Elevator(7, 2),
                        new Elevator(3, 3)
                );

        CloneCoordinatesDirectionUpdater cloneCoordinatesDirectionUpdater = new CloneCoordinatesDirectionUpdater();
        cloneCoordinatesDirectionUpdater.updateClonesCoordinatesAndDirection(gameElementsContainer);

        Assertions.assertEquals(3, clone2.cordX);
        Assertions.assertEquals(7, clone3.cordX);
    }

    @Test
    void itShouldUpdateCoordinatesRegardingElevators(){
        YAxisDirectionCalculator.yAxisDirection = YAxisDirection.BOTTOM_TO_TOP;
        Clone clone2 = new Clone(3, 3, CloneQualifier.SOLDIER_CLONE, CloneState.NOT_BLOCKED, CloneDirection.LEFT);
        Clone clone3 = new Clone(7, 2, CloneQualifier.SOLDIER_CLONE, CloneState.NOT_BLOCKED, CloneDirection.LEFT);

        GameElementsContainer gameElementsContainer = new GameElementsContainer();
        gameElementsContainer.cloneList = List.of(clone2, clone3);
        gameElementsContainer.finishDoor = new FinishDoor(0,0);
        gameElementsContainer.elevatorList =
                List.of(
                        new Elevator(7, 2),
                        new Elevator(3, 3)
                );

        CloneCoordinatesDirectionUpdater cloneCoordinatesDirectionUpdater = new CloneCoordinatesDirectionUpdater();
        cloneCoordinatesDirectionUpdater.updateClonesCoordinatesAndDirection(gameElementsContainer);

        Assertions.assertEquals(4, clone2.cordY);
        Assertions.assertEquals(3, clone3.cordY);
    }

    @Test
    void itShouldChangeDirectionWhenEncounterBlockClone(){
        Clone clone1 = new Clone(3, 3, CloneQualifier.SOLDIER_CLONE, CloneState.BLOCKED, CloneDirection.LEFT);
        Clone clone2 = new Clone(7, 2, CloneQualifier.SOLDIER_CLONE, CloneState.BLOCKED, CloneDirection.LEFT);
        Clone clone3 = new Clone(3, 3, CloneQualifier.SOLDIER_CLONE, CloneState.NOT_BLOCKED, CloneDirection.LEFT);
        Clone clone4 = new Clone(7, 2, CloneQualifier.SOLDIER_CLONE, CloneState.NOT_BLOCKED, CloneDirection.LEFT);

        GameElementsContainer gameElementsContainer = new GameElementsContainer();
        gameElementsContainer.cloneList = List.of(clone1, clone2, clone3, clone4);
        gameElementsContainer.elevatorList = List.of();

        CloneCoordinatesDirectionUpdater cloneCoordinatesDirectionUpdater = new CloneCoordinatesDirectionUpdater();
        cloneCoordinatesDirectionUpdater.updateClonesCoordinatesAndDirection(gameElementsContainer);

        Assertions.assertEquals(CloneDirection.RIGHT, clone3.direction);
        Assertions.assertEquals(CloneDirection.RIGHT, clone4.direction);
    }
}
