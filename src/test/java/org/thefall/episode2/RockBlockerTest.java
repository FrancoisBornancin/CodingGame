package org.thefall.episode2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.thefall.episode2.gameplay.GameResponse;
import org.thefall.episode2.gameplay.map.MapBuilder;
import org.thefall.episode2.gameplay.nextblock.Coordinates;
import org.thefall.episode2.gameplay.nextblock.FunnelCoordinatesListUpdater;
import org.thefall.episode2.gameplay.nextblock.GameDirection;
import org.thefall.episode2.gameplay.nextblock.info.FunnelCoordinatesContainer;
import org.thefall.episode2.gameplay.rocks.RockBlocker;

import java.util.List;


public class RockBlockerTest {
    @Test
    void nextWaitResponseShouldBeReplaced_case1(){
        MapBuilder mapBuilder = new MapBuilder();
        String[][] mapTab =
                mapBuilder.convertListToStringTab(
                        List.of(
                                "-3 0 -3",
                                "11 8 10",
                                "0 3 0"
                        )
                );
        FunnelCoordinatesContainer funnelCoordinatesContainer = new FunnelCoordinatesContainer();
        FunnelCoordinatesListUpdater funnelCoordinatesListUpdater = new FunnelCoordinatesListUpdater(funnelCoordinatesContainer);
        RockBlocker rockBlocker = new RockBlocker(funnelCoordinatesListUpdater, mapTab);
        funnelCoordinatesContainer.funnelCoordinates =
                List.of(
                        new GameResponse(new Coordinates(0,1), null),
                        new GameResponse(new Coordinates(1,1), null),
                        new GameResponse(new Coordinates(1,2), null)
                );

        List<Coordinates> rockCoordinatesList = List.of(new Coordinates(2,0, GameDirection.DOWN, "-3"));

        rockBlocker.blockRock(rockCoordinatesList);

        GameResponse gameResponse1 = funnelCoordinatesContainer.funnelCoordinates.get(0);

        Assertions.assertEquals(2, gameResponse1.coordinates.cordX);
        Assertions.assertEquals(1, gameResponse1.coordinates.cordY);
        Assertions.assertEquals(GameDirection.RIGHT, gameResponse1.gameDirection);
    }

    @Test
    void nextWaitResponseShouldBeReplaced_case2(){
        MapBuilder mapBuilder = new MapBuilder();
        String[][] mapTab =
                mapBuilder.convertListToStringTab(
                        List.of(
                                "-3 0 0 0 -3",
                                "10 2 8 2 10",
                                "0 0 3 0 0"
                        )
                );
        FunnelCoordinatesContainer funnelCoordinatesContainer = new FunnelCoordinatesContainer();
        FunnelCoordinatesListUpdater funnelCoordinatesListUpdater = new FunnelCoordinatesListUpdater(funnelCoordinatesContainer);
        RockBlocker rockBlocker = new RockBlocker(funnelCoordinatesListUpdater, mapTab);
        funnelCoordinatesContainer.funnelCoordinates =
                List.of(
                        new GameResponse(new Coordinates(0,1), GameDirection.RIGHT),
                        new GameResponse(new Coordinates(1,1), null),
                        new GameResponse(new Coordinates(2,1), null),
                        new GameResponse(new Coordinates(2,2), null)
                );

        List<Coordinates> rockCoordinatesList = List.of(new Coordinates(4,0, GameDirection.DOWN, "-3"));

        rockBlocker.blockRock(rockCoordinatesList);

        GameResponse gameResponse1 = funnelCoordinatesContainer.funnelCoordinates.get(1);

        Assertions.assertEquals(3, gameResponse1.coordinates.cordX);
        Assertions.assertEquals(1, gameResponse1.coordinates.cordY);
        Assertions.assertEquals(GameDirection.RIGHT, gameResponse1.gameDirection);
    }
}
