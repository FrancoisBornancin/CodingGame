package org.thefall.episode2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.thefall.episode2.gameplay.nextblock.Coordinates;
import org.thefall.episode2.gameplay.nextblock.GameDirection;
import org.thefall.episode2.gameplay.nextblock.caching.CoordinatesCache;
import org.thefall.episode2.gameplay.nextblock.caching.CoordinatesCacheRetriever;

import java.util.ArrayList;
import java.util.List;

public class CoordinatesCacheRetrieverTest {
    @Test
    void itShouldAddElementWithOneIndexes(){
        CoordinatesCacheRetriever coordinatesCacheRetriever = new CoordinatesCacheRetriever();
        Coordinates coordinates = new Coordinates(0,0);
        coordinatesCacheRetriever.addCoordinates(coordinates, "3");

        CoordinatesCache coordinatesCache = coordinatesCacheRetriever.getLast();

        Assertions.assertEquals(1, coordinatesCache.index);
    }

    @Test
    void itShouldIncrementIndexWhenGettingTheElement(){
        CoordinatesCacheRetriever coordinatesCacheRetriever = new CoordinatesCacheRetriever();
        Coordinates coordinates = new Coordinates(0,0);
        coordinatesCacheRetriever.addCoordinates(coordinates, "3");

        coordinatesCacheRetriever.getLast();
        CoordinatesCache coordinatesCache = coordinatesCacheRetriever.getLast();

        Assertions.assertEquals(2, coordinatesCache.index);
    }

    @Test
    void itShouldGoToLeftWhenIndexOne(){
        CoordinatesCacheRetriever coordinatesCacheRetriever = new CoordinatesCacheRetriever();
        Coordinates coordinates = new Coordinates(0,0);
        coordinatesCacheRetriever.addCoordinates(coordinates, "3");

        CoordinatesCache coordinatesCache = coordinatesCacheRetriever.getLast();

        Assertions.assertEquals(GameDirection.LEFT, coordinatesCache.gameDirection);
    }

    @Test
    void itShouldGoToRightWhenIndexTwo(){
        CoordinatesCacheRetriever coordinatesCacheRetriever = new CoordinatesCacheRetriever();
        Coordinates coordinates = new Coordinates(0,0);
        coordinatesCacheRetriever.addCoordinates(coordinates, "3");

        coordinatesCacheRetriever.getLast();
        CoordinatesCache coordinatesCache = coordinatesCacheRetriever.getLast();

        Assertions.assertEquals(GameDirection.RIGHT, coordinatesCache.gameDirection);
    }

    @Test
    void itShouldOnlyGetTheLastElement(){
        CoordinatesCacheRetriever coordinatesCacheRetriever = new CoordinatesCacheRetriever();
        Coordinates coordinate1 = new Coordinates(1,0);
        Coordinates coordinate2 = new Coordinates(2,0);
        Coordinates coordinate3 = new Coordinates(3,0);

        coordinatesCacheRetriever.addCoordinates(coordinate1, "3");
        coordinatesCacheRetriever.addCoordinates(coordinate2, "3");
        coordinatesCacheRetriever.addCoordinates(coordinate3, "3");

        coordinatesCacheRetriever.getLast();
        CoordinatesCache coordinatesCache = coordinatesCacheRetriever.getLast();

        Assertions.assertEquals(coordinate3, coordinatesCache.coordinates);
    }

    @Test
    void itShouldRemoveElementWhenIndexEqualsFour(){
        CoordinatesCacheRetriever coordinatesCacheRetriever = new CoordinatesCacheRetriever();
        Coordinates coordinate1 = new Coordinates(0,0);
        Coordinates coordinate2 = new Coordinates(1,0);
        Coordinates coordinate3 = new Coordinates(2,0);

        coordinatesCacheRetriever.addCoordinates(coordinate1, "3");
        coordinatesCacheRetriever.addCoordinates(coordinate2, "3");
        coordinatesCacheRetriever.addCoordinates(coordinate3, "3");

        coordinatesCacheRetriever.getLast();
        coordinatesCacheRetriever.getLast();

        CoordinatesCache coordinatesCache1 = coordinatesCacheRetriever.getLast();

        Assertions.assertEquals(3, coordinatesCache1.index);

        CoordinatesCache coordinatesCache2 = coordinatesCacheRetriever.getLast();

        Assertions.assertEquals(coordinate2, coordinatesCache2.coordinates);
    }

    @Test
    void itShouldRemoveElementWithIndexThreeWhenGettingIndexEqualsFour(){
        CoordinatesCacheRetriever coordinatesCacheRetriever = new CoordinatesCacheRetriever();
        Coordinates coordinate1 = new Coordinates(0,0);
        Coordinates coordinate2 = new Coordinates(1,0);
        Coordinates coordinate3 = new Coordinates(2,0);

        coordinatesCacheRetriever.addCoordinates(coordinate1, "3");
        coordinatesCacheRetriever.addCoordinates(coordinate2, "3");

        coordinatesCacheRetriever.getLast();
        coordinatesCacheRetriever.getLast();

        CoordinatesCache coordinatesCacheRetrieved1 =
                coordinatesCacheRetriever.getLast();

        Assertions.assertEquals(3, coordinatesCacheRetrieved1.index);

        coordinatesCacheRetriever.addCoordinates(coordinate3, "3");

        coordinatesCacheRetriever.getLast();
        coordinatesCacheRetriever.getLast();
        coordinatesCacheRetriever.getLast();
        CoordinatesCache coordinatesCacheRetrieved2 =
                coordinatesCacheRetriever.getLast();

        Assertions.assertEquals(coordinate1, coordinatesCacheRetrieved2.coordinates);
    }

    @Test
    void afterLastElementRemovedNextOneShouldBeWithIndexOne(){
        CoordinatesCacheRetriever coordinatesCacheRetriever = new CoordinatesCacheRetriever();
        Coordinates coordinate1 = new Coordinates(0,0);
        Coordinates coordinate2 = new Coordinates(1,0);
        Coordinates coordinate3 = new Coordinates(2,0);

        coordinatesCacheRetriever.addCoordinates(coordinate1, "3");
        coordinatesCacheRetriever.addCoordinates(coordinate2, "3");
        coordinatesCacheRetriever.addCoordinates(coordinate3, "3");

        coordinatesCacheRetriever.getLast();
        coordinatesCacheRetriever.getLast();

        CoordinatesCache coordinatesCache1 = coordinatesCacheRetriever.getLast();

        Assertions.assertEquals(3, coordinatesCache1.index);

        CoordinatesCache coordinatesCache2 = coordinatesCacheRetriever.getLast();

        Assertions.assertEquals(1, coordinatesCache2.index);
    }

    @Test
    void afterLastElementRemovedNextOneShouldBeWithLeftDirection(){
        CoordinatesCacheRetriever coordinatesCacheRetriever = new CoordinatesCacheRetriever();
        Coordinates coordinate1 = new Coordinates(0,0);
        Coordinates coordinate2 = new Coordinates(1,0);
        Coordinates coordinate3 = new Coordinates(2,0);

        coordinatesCacheRetriever.addCoordinates(coordinate1, "3");
        coordinatesCacheRetriever.addCoordinates(coordinate2, "3");
        coordinatesCacheRetriever.addCoordinates(coordinate3, "3");

        coordinatesCacheRetriever.getLast();
        coordinatesCacheRetriever.getLast();

        CoordinatesCache coordinatesCache1 = coordinatesCacheRetriever.getLast();

        Assertions.assertEquals(3, coordinatesCache1.index);

        CoordinatesCache coordinatesCache2 = coordinatesCacheRetriever.getLast();

        Assertions.assertEquals(GameDirection.LEFT, coordinatesCache2.gameDirection);
    }

    @Test
    void itShouldInformIfItContainsACoordinates_case1DoesContains(){
        CoordinatesCacheRetriever coordinatesCacheRetriever = new CoordinatesCacheRetriever();
        Coordinates coordinate = new Coordinates(0,0);

        Coordinates coordinatesToCheck = new Coordinates(0,0);

        coordinatesCacheRetriever.addCoordinates(coordinate, "3");
        Assertions.assertTrue(coordinatesCacheRetriever.getOptional(coordinatesToCheck).isPresent());
    }

    @Test
    void itShouldInformIfItContainsACoordinates_case1DoesNotContains(){
        CoordinatesCacheRetriever coordinatesCacheRetriever = new CoordinatesCacheRetriever();
        Coordinates coordinate = new Coordinates(0,0);

        Coordinates coordinatesToCheck = new Coordinates(1,0);

        coordinatesCacheRetriever.addCoordinates(coordinate, "3");
        Assertions.assertFalse(coordinatesCacheRetriever.getOptional(coordinatesToCheck).isPresent());
    }

    @Test
    void itShouldInformIfItContainsACoordinates_case2DoesNotContains(){
        CoordinatesCacheRetriever coordinatesCacheRetriever = new CoordinatesCacheRetriever();

        Coordinates coordinatesToCheck = new Coordinates(1,0);

        Assertions.assertFalse(coordinatesCacheRetriever.getOptional(coordinatesToCheck).isPresent());
    }

    @Test
    void itShouldNotAddACoordinatesIfDirectionHasPreviouslyBeenAdded_case1(){
        CoordinatesCacheRetriever coordinatesCacheRetriever = new CoordinatesCacheRetriever();
        coordinatesCacheRetriever.coordinatesCacheListToRetrieve =
                new ArrayList<>(
                        List.of(
                                new CoordinatesCache(new Coordinates(1,0, GameDirection.DOWN), 0, "2")
                        )
                );
        Coordinates coordinate = new Coordinates(1,0, GameDirection.DOWN);

        coordinatesCacheRetriever.addCoordinates(coordinate, "3");

        Assertions.assertEquals(1, coordinatesCacheRetriever.coordinatesCacheListToRetrieve.size());
    }

    @Test
    void itShouldNotAddACoordinatesIfDirectionHasPreviouslyBeenAdded_case2(){
        CoordinatesCacheRetriever coordinatesCacheRetriever = new CoordinatesCacheRetriever();
        coordinatesCacheRetriever.coordinatesCacheListBeinRemoved =
                new ArrayList<>(
                        List.of(
                                new CoordinatesCache(new Coordinates(1,0, GameDirection.DOWN), 0, "2")
                        )
                );
        Coordinates coordinate = new Coordinates(1,0, GameDirection.DOWN);

        coordinatesCacheRetriever.addCoordinates(coordinate, "3");

        Assertions.assertEquals(0, coordinatesCacheRetriever.coordinatesCacheListToRetrieve.size());
    }

    @Test
    void itShouldAddACoordinatesIfDirectionHasNotPreviouslyBeenAdded_case1(){
        CoordinatesCacheRetriever coordinatesCacheRetriever = new CoordinatesCacheRetriever();
        coordinatesCacheRetriever.coordinatesCacheListToRetrieve =
                new ArrayList<>(
                        List.of(
                                new CoordinatesCache(new Coordinates(1,0, GameDirection.LEFT), 0, "2")
                        )
                );
        Coordinates coordinate = new Coordinates(1,0, GameDirection.DOWN);

        coordinatesCacheRetriever.addCoordinates(coordinate, "3");

        Assertions.assertEquals(2, coordinatesCacheRetriever.coordinatesCacheListToRetrieve.size());
    }

    @Test
    void itShouldAddACoordinatesIfDirectionHasNotPreviouslyBeenAdded_case2(){
        CoordinatesCacheRetriever coordinatesCacheRetriever = new CoordinatesCacheRetriever();
        coordinatesCacheRetriever.coordinatesCacheListBeinRemoved =
                new ArrayList<>(
                        List.of(
                                new CoordinatesCache(new Coordinates(1,0, GameDirection.LEFT), 0, "2")
                        )
                );
        Coordinates coordinate = new Coordinates(1,0, GameDirection.DOWN);

        coordinatesCacheRetriever.addCoordinates(coordinate, "3");

        Assertions.assertEquals(1, coordinatesCacheRetriever.coordinatesCacheListToRetrieve.size());
    }

}
