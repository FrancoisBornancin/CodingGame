package org.thefall.episode2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.thefall.episode2.gameplay.GameResponse;
import org.thefall.episode2.gameplay.elements.exit.ExitDoor;
import org.thefall.episode2.gameplay.map.MapBuilder;
import org.thefall.episode2.gameplay.nextblock.Coordinates;
import org.thefall.episode2.gameplay.nextblock.GameDirection;
import org.thefall.episode2.gameplay.nextblock.info.FunnelCoordinatesContainer;
import org.thefall.episode2.gameplay.nextblock.info.HeroPathCalculator;

import java.util.ArrayList;
import java.util.List;

public class HeroPathCalculatorTest {
    @Test
    void itShouldBuildPath(){
        MapBuilder mapBuilder = new MapBuilder();
        String[][] mapTab =
            mapBuilder.convertListToStringTab(
                    new ArrayList<>(
                            List.of(
                                    "0 0 0 -3",
                                    "0 0 0 3",
                                    "2 2 2 6",
                                    "0 0 0 3",
                                    "0 0 0 3"
                            )
                    )
            );
        FunnelCoordinatesContainer funnelCoordinatesContainer = new FunnelCoordinatesContainer();
        HeroPathCalculator heroPathCalculator = new HeroPathCalculator(funnelCoordinatesContainer);
        heroPathCalculator.mapTab = mapTab;
        heroPathCalculator.exitDoor = new ExitDoor(3,4);

        heroPathCalculator.buildPath(new Coordinates(3,0, GameDirection.DOWN, "-3"));

        List<GameResponse> expectedGameResponseList =
                List.of(
                        new GameResponse(new Coordinates(3,1), null),
                        new GameResponse(new Coordinates(3,2), GameDirection.LEFT),
                        new GameResponse(new Coordinates(3,3), null),
                        new GameResponse(new Coordinates(3,4), null)
                );

        for(int a = 0 ; a < expectedGameResponseList.size() ; a++){
            Assertions.assertEquals(expectedGameResponseList.get(a).coordinates.cordX, funnelCoordinatesContainer.funnelCoordinates.get(a).coordinates.cordX);
            Assertions.assertEquals(expectedGameResponseList.get(a).coordinates.cordY, funnelCoordinatesContainer.funnelCoordinates.get(a).coordinates.cordY);
            Assertions.assertEquals(expectedGameResponseList.get(a).gameDirection, funnelCoordinatesContainer.funnelCoordinates.get(a).gameDirection);
        }
    }
}
