package org.thefall.episode2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.thefall.episode2.gameplay.GameResponse;
import org.thefall.episode2.gameplay.nextblock.Coordinates;
import org.thefall.episode2.gameplay.nextblock.GameDirection;
import org.thefall.episode2.gameplay.nextblock.caching.CoordinatesCache;
import org.thefall.episode2.gameplay.nextblock.caching.CoordinatesCacheCommand;
import org.thefall.episode2.gameplay.nextblock.caching.CoordinatesCacheRetriever;
import org.thefall.episode2.gameplay.nextblock.info.MovableBlockQualifier;
import org.thefall.episode2.gameplay.nextblock.info.FunnelCoordinatesContainer;

import java.util.ArrayList;
import java.util.List;

public class CoordinatesCachesCommandTest {
    @Test
    void itShouldInsertIntoCache(){
        CoordinatesCacheRetriever coordinatesCacheRetriever = new CoordinatesCacheRetriever();
        MovableBlockQualifier movableBlockQualifier = new MovableBlockQualifier();
        FunnelCoordinatesContainer funnelCoordinatesContainer = new FunnelCoordinatesContainer();
        CoordinatesCacheCommand coordinatesCacheCommand = new CoordinatesCacheCommand(coordinatesCacheRetriever, movableBlockQualifier, funnelCoordinatesContainer);

        Coordinates movableCoordinates = new Coordinates(0,0);
        movableCoordinates.value = "4";

        coordinatesCacheCommand.insert(movableCoordinates, "5");

        CoordinatesCache coordinatesCache = coordinatesCacheCommand.getLast();
        Assertions.assertNotNull(coordinatesCache);
    }

    @Test
    void itShouldNotInsertIntoCache_caseCoordinatesNull(){
        CoordinatesCacheRetriever coordinatesCacheRetriever = new CoordinatesCacheRetriever();
        MovableBlockQualifier movableBlockQualifier = new MovableBlockQualifier();
        FunnelCoordinatesContainer funnelCoordinatesContainer = new FunnelCoordinatesContainer();
        CoordinatesCacheCommand coordinatesCacheCommand = new CoordinatesCacheCommand(coordinatesCacheRetriever, movableBlockQualifier, funnelCoordinatesContainer);

        Coordinates coordinates = null;

        coordinatesCacheCommand.insert(coordinates, "5");

        CoordinatesCache coordinatesCache = coordinatesCacheCommand.getLast();
        Assertions.assertNull(coordinatesCache);
    }

    @Test
    void itShouldNotInsertIntoCache_caseCoordinatesNotMovable(){
        CoordinatesCacheRetriever coordinatesCacheRetriever = new CoordinatesCacheRetriever();
        MovableBlockQualifier movableBlockQualifier = new MovableBlockQualifier();
        FunnelCoordinatesContainer funnelCoordinatesContainer = new FunnelCoordinatesContainer();
        CoordinatesCacheCommand coordinatesCacheCommand = new CoordinatesCacheCommand(coordinatesCacheRetriever, movableBlockQualifier, funnelCoordinatesContainer);

        Coordinates coordinates = new Coordinates(0,0);

        coordinatesCacheCommand.insert(coordinates, "-3");

        CoordinatesCache coordinatesCache = coordinatesCacheCommand.getLast();
        Assertions.assertNull(coordinatesCache);
    }

    @Test
    void itShouldRemoveFunnelCoordinatesListFromIndexWhenGettingCoordinatesCache(){
        CoordinatesCacheRetriever coordinatesCacheRetriever = new CoordinatesCacheRetriever();
        MovableBlockQualifier movableBlockQualifier = new MovableBlockQualifier();
        FunnelCoordinatesContainer funnelCoordinatesContainer = new FunnelCoordinatesContainer();
        CoordinatesCacheCommand coordinatesCacheCommand = new CoordinatesCacheCommand(coordinatesCacheRetriever, movableBlockQualifier, funnelCoordinatesContainer);

        funnelCoordinatesContainer.funnelCoordinates =
                new ArrayList<>(
                        List.of(
                                new GameResponse(new Coordinates(0,0), GameDirection.RIGHT),
                                new GameResponse(new Coordinates(1,0), GameDirection.RIGHT),
                                new GameResponse(new Coordinates(2,0), GameDirection.RIGHT)
                        )
                );

        Coordinates previousCoordinates = new Coordinates(3,0);
        Coordinates coordinates = new Coordinates(1,0);
        coordinates.value = "4";

        coordinatesCacheCommand.insert(coordinates, "3");

        coordinatesCacheCommand.getLast();

        Assertions.assertEquals(2, funnelCoordinatesContainer.funnelCoordinates.size());
        Assertions.assertEquals(0, funnelCoordinatesContainer.funnelCoordinates.get(0).coordinates.cordX);
        Assertions.assertEquals(0, funnelCoordinatesContainer.funnelCoordinates.get(0).coordinates.cordY);
        Assertions.assertEquals(1, funnelCoordinatesContainer.funnelCoordinates.get(1).coordinates.cordX);
        Assertions.assertEquals(0, funnelCoordinatesContainer.funnelCoordinates.get(1).coordinates.cordY);
    }
}
