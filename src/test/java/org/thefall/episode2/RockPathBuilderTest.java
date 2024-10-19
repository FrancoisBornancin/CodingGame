package org.thefall.episode2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.thefall.episode2.gameplay.map.MapBuilder;
import org.thefall.episode2.gameplay.map.NextMapValueRetriever;
import org.thefall.episode2.gameplay.nextblock.Coordinates;
import org.thefall.episode2.gameplay.nextblock.GameDirection;
import org.thefall.episode2.gameplay.nextblock.builder.NextBlockMapBuilder;
import org.thefall.episode2.gameplay.rocks.RockPathBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RockPathBuilderTest {
    @Test
    void itShouldBuildPath(){
        RockPathBuilder rockPathBuilder = new RockPathBuilder();

        Coordinates coordinates = new Coordinates(2, 0, GameDirection.DOWN, "-3");
        MapBuilder mapBuilder = new MapBuilder();
        String[][] mapTab =
                mapBuilder.convertListToStringTab(
                        new ArrayList<>(
                                List.of(
                                        "-3 0 -3 0 -3 0 -3 -3",
                                        "11 8 -10 0 3 0 3 3",
                                        "0 1 0 0 3 0 3 3",
                                        "0 11 1 2 10 0 3 3",
                                        "0 0 1 2 2 2 10 3",
                                        "0 0 1 2 2 2 2 10",
                                        "0 0 0 0 0 0 0 0"
                                )
                        )
                );

        List<Coordinates> expectedCoordList =
                List.of(
                    new Coordinates(2,1),
                    new Coordinates(1,1),
                    new Coordinates(1,2),
                    new Coordinates(1,3),
                    new Coordinates(2,3),
                    new Coordinates(2,4),
                    new Coordinates(2,5)
                );

        List<Coordinates> calculatedListCord = rockPathBuilder.buildPath(coordinates, mapTab, new ArrayList<>());

        for(int a = 0 ; a < expectedCoordList.size() ; a++){
            Assertions.assertEquals(calculatedListCord.get(a).cordX, expectedCoordList.get(a).cordX);
            Assertions.assertEquals(calculatedListCord.get(a).cordY, expectedCoordList.get(a).cordY);
        }
    }

    @Test
    void itShouldNotBuildPath_case1(){
        RockPathBuilder rockPathBuilder = new RockPathBuilder();

        Coordinates coordinates = new Coordinates(2, 0);
        MapBuilder mapBuilder = new MapBuilder();
        String[][] mapTab =
                mapBuilder.convertListToStringTab(
                        List.of(
                                "-3 0 -3 0 -3 0 -3 -3",
                                "0 0 2 0 0 0 0 0"
                        )
                );

        List<Coordinates> calculatedListCord = rockPathBuilder.buildPath(coordinates, mapTab, new ArrayList<>());
        Assertions.assertEquals(0, calculatedListCord.size());
    }
}
