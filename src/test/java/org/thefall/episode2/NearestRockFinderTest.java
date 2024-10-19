package org.thefall.episode2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.thefall.episode2.gameplay.map.MapBuilder;
import org.thefall.episode2.gameplay.map.NextMapValueRetriever;
import org.thefall.episode2.gameplay.nextblock.Coordinates;
import org.thefall.episode2.gameplay.nextblock.GameDirection;
import org.thefall.episode2.gameplay.nextblock.builder.NextBlockMapBuilder;
import org.thefall.episode2.gameplay.rocks.NearestRockFinder;
import org.thefall.episode2.gameplay.rocks.RockPathBuilder;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class NearestRockFinderTest {
    @Test
    public void itShouldFindNearestRock_caseTwoRockEncounterSameTunnelAtSameTimeThanHero(){
        MapBuilder mapBuilder = new MapBuilder();
        String[][] mapTab =
                mapBuilder.convertListToStringTab(
                        List.of(
                                "-3 0 -3 0 -3 0 -3 -3",
                                "11 8 -10 0 3 0 3 3",
                                "0 1 0 0 3 0 3 3",
                                "0 11 1 2 10 0 3 3",
                                "0 0 1 2 2 2 10 3",
                                "0 0 1 2 2 2 2 10"
                        )
                );

        Coordinates rock = new Coordinates(2,0, GameDirection.DOWN, "-3");
        List<Coordinates> rockCoordsList =
                List.of(
                        rock,
                        new Coordinates(4,0, GameDirection.DOWN, "-3")
                );

        List<Coordinates> heroNextCoords =
                List.of(
                        new Coordinates(0,1),
                        new Coordinates(1,1),
                        new Coordinates(1,2),
                        new Coordinates(1,3),
                        new Coordinates(2,3),
                        new Coordinates(2,4)
                );

        NearestRockFinder nearestRockFinder = new NearestRockFinder();

        Optional<Map<Coordinates, Integer>> optionalNearestRockMap =
                nearestRockFinder.findNearestRock(rockCoordsList, heroNextCoords, mapTab);

        Assertions.assertTrue(optionalNearestRockMap.isPresent());
        Assertions.assertEquals(rock, optionalNearestRockMap.get().keySet().stream().findFirst().get());
    }

    @Test
    public void itShouldFindNearestRock_caseOnlyOneRockEncounterTunnelAtSameTimeThanHero(){
        MapBuilder mapBuilder = new MapBuilder();
        String[][] mapTab =
                mapBuilder.convertListToStringTab(
                        List.of(
                                "-3 0 -3 0 -3 0 -3 -3",
                                "11 8 -10 0 3 0 3 3",
                                "0 1 0 0 3 0 3 3",
                                "0 11 1 2 10 0 3 3",
                                "0 0 1 2 2 2 10 3",
                                "0 0 1 2 2 2 2 10"
                        )
                );

        Coordinates rock = new Coordinates(2,0, GameDirection.DOWN, "-3");
        List<Coordinates> rockCoordsList =
                List.of(
                        rock,
                        new Coordinates(6,0, GameDirection.DOWN, "-3")
                );

        List<Coordinates> heroNextCoords =
                List.of(
                        new Coordinates(0,1),
                        new Coordinates(1,1),
                        new Coordinates(1,2),
                        new Coordinates(1,3),
                        new Coordinates(2,3),
                        new Coordinates(2,4)
                );

        NearestRockFinder nearestRockFinder = new NearestRockFinder();

        Optional<Map<Coordinates, Integer>> optionalNearestRockMap =
                nearestRockFinder.findNearestRock(rockCoordsList, heroNextCoords, mapTab);

        Assertions.assertTrue(optionalNearestRockMap.isPresent());
        Assertions.assertEquals(rock, optionalNearestRockMap.get().keySet().stream().findFirst().get());
    }

    @Test
    public void itShouldNotFindNearestRock_caseNoRockEncounterTunnelAtSameTimeThanHero(){
        MapBuilder mapBuilder = new MapBuilder();
        String[][] mapTab =
                mapBuilder.convertListToStringTab(
                        List.of(
                                "-3 0 -3 0 -3 0 -3 -3",
                                "11 8 -10 0 3 0 3 3",
                                "0 1 0 0 3 0 3 3",
                                "0 11 1 2 10 0 3 3",
                                "0 0 1 2 2 2 10 3",
                                "0 0 1 2 2 2 2 10"
                        )
                );
        List<Coordinates> rockCoordsList =
                List.of(
                        new Coordinates(6,0, GameDirection.DOWN, "-3"),
                        new Coordinates(7,0, GameDirection.DOWN, "-3")
                );

        List<Coordinates> heroNextCoords =
                List.of(
                        new Coordinates(0,1),
                        new Coordinates(1,1),
                        new Coordinates(1,2),
                        new Coordinates(1,3),
                        new Coordinates(2,3),
                        new Coordinates(2,4),
                        new Coordinates(2,5)
                );
        NearestRockFinder nearestRockFinder = new NearestRockFinder();

        Optional<Map<Coordinates, Integer>> optionalNearestRockMap =
                nearestRockFinder.findNearestRock(rockCoordsList, heroNextCoords, mapTab);

        Assertions.assertEquals(Optional.empty(), optionalNearestRockMap);
    }

    @Test
    public void itShouldNotFindNearestRock_caseAllRocksHasWall(){
        MapBuilder mapBuilder = new MapBuilder();
        String[][] mapTab =
                mapBuilder.convertListToStringTab(
                        List.of(
                                "-3 0 -3 0 -3 0 -3 -3",
                                "11 8 2 0 2 0 3 3",
                                "0 1 0 0 3 0 2 2",
                                "0 11 1 2 10 0 3 3",
                                "0 0 1 2 2 2 10 3",
                                "0 0 1 2 2 2 2 10"
                        )
                );
        List<Coordinates> rockCoordsList =
                List.of(
                        new Coordinates(6,0, GameDirection.DOWN, "-3"),
                        new Coordinates(7,0, GameDirection.DOWN, "-3")
                );

        List<Coordinates> heroNextCoords =
                List.of(
                        new Coordinates(0,1),
                        new Coordinates(1,1),
                        new Coordinates(1,2),
                        new Coordinates(1,3),
                        new Coordinates(2,3),
                        new Coordinates(2,4),
                        new Coordinates(2,5)
                );
        NearestRockFinder nearestRockFinder = new NearestRockFinder();

        Optional<Map<Coordinates, Integer>> optionalNearestRockMap =
                nearestRockFinder.findNearestRock(rockCoordsList, heroNextCoords, mapTab);

        Assertions.assertEquals(Optional.empty(), optionalNearestRockMap);
    }
}
