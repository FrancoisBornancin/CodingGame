package org.dontpanic.episode1;

import org.dontpanic.episode1.gameplay.clone.Clone;
import org.dontpanic.episode1.gameplay.clone.CloneDirection;
import org.dontpanic.episode1.gameplay.clone.CloneQualifier;
import org.dontpanic.episode1.gameplay.clone.CloneState;
import org.dontpanic.episode1.gameplay.elements.Elevator;
import org.dontpanic.episode1.gameplay.elements.FinishDoor;
import org.dontpanic.episode1.gameplay.elements.GameElementsContainer;
import org.dontpanic.episode1.gameplay.elements.StartingDoor;
import org.dontpanic.episode1.logging.map.GameMap;
import org.dontpanic.episode1.logging.map.GameMapUpdater;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GameMapUpdaterTest {
    @Test
    void itShouldUpdateMapWithClones(){
        GameMap gameMap =
                new GameMap(
                    List.of(
                            "_____F",
                            "_E____",
                            "____E_",
                            "__E__S"
                    )
                );
        GameElementsContainer gameElementsContainer = new GameElementsContainer();
        gameElementsContainer.finishDoor = new FinishDoor(5, 3);
        gameElementsContainer.startingDoor = new StartingDoor(5, 0);
        gameElementsContainer.elevatorList =
                List.of(
                        new Elevator(1, 2),
                        new Elevator(4, 1),
                        new Elevator(2, 0)
                );
        gameElementsContainer.cloneList =
                List.of(
                        new Clone(3, 3, CloneQualifier.LEADING_CLONE, CloneState.NOT_BLOCKED, CloneDirection.RIGHT),
                        new Clone(2, 2, CloneQualifier.SOLDIER_CLONE, CloneState.NOT_BLOCKED, CloneDirection.RIGHT),
                        new Clone(0, 1, CloneQualifier.SOLDIER_CLONE, CloneState.BLOCKED, CloneDirection.RIGHT),
                        new Clone(2, 0, CloneQualifier.SOLDIER_CLONE, CloneState.NOT_BLOCKED, CloneDirection.RIGHT)
                );
        GameMapUpdater gameMapUpdater = new GameMapUpdater();
        gameMapUpdater.updateGameMap(gameMap, gameElementsContainer);

        List<String> expectedGameMap =
                new ArrayList<>(
                        List.of(
                                "___C_F",
                                "_Ec___",
                                "B___E_",
                                "__X__S"
                        )
                );

        for(int a = 0 ; a < expectedGameMap.size() ; a++){
            Assertions.assertEquals(expectedGameMap.get(a), gameMap.map.get(a));
        }
    }
}
