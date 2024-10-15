package org.dontpanic.episode1;

import org.dontpanic.episode1.gameplay.elements.GameElementsContainer;
import org.dontpanic.episode1.gameplay.elements.StartingDoor;
import org.dontpanic.episode1.logging.map.GameMapInitializer;
import org.dontpanic.episode1.gameinit.staticdata.InitializedData;
import org.dontpanic.episode1.gameinit.staticdata.StaticGameInitializedData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameMapInitializerTest {
    @Test
    void itShouldInitMapWithGameData(){
        GameElementsContainer gameElementsContainer = new GameElementsContainer();
        StaticGameInitializedData staticGameInitializedData =
                new StaticGameInitializedData(
                        4,
                            5,
                        Map.of(
                                2, new ArrayList<>(List.of(0)),
                                1, new ArrayList<>(List.of(3)),
                                0, new ArrayList<>(List.of(1))
                        ),
                        Map.of(3, 4),
                        12
                );

        InitializedData initializedData = new InitializedData();
        initializedData.staticGameInitializedData = staticGameInitializedData;
        initializedData.startingDoor = new StartingDoor(4, 0);

        List<String> calculatedGameMap =
        new GameMapInitializer().initMap(initializedData);

        List<String> expectedGameMap =
            List.of(
                    "____F",
                    "E____",
                    "___E_",
                    "_E__S"
            );

        for(int a = 0 ; a < expectedGameMap.size() ; a++){
            Assertions.assertEquals(expectedGameMap.get(a), calculatedGameMap.get(a));
        }
    }
}
