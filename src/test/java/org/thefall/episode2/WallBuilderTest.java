package org.thefall.episode2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.thefall.episode2.gameplay.nextblock.Coordinates;
import org.thefall.episode2.gameplay.rocks.WallBuilder;

import java.util.List;
import java.util.Optional;

public class WallBuilderTest {
    @Test
    public void itShouldBuildWall_case1(){
        Coordinates coordinates = new Coordinates(0,0);
        coordinates.nextCoordinates =
                List.of(
                        new Coordinates(0,1,"3"),
                        new Coordinates(1,1,"8"),
                        new Coordinates(1,2,"-10")
                );


        WallBuilder wallBuilder = new WallBuilder();
        Optional<Coordinates> optionalWallCoordinates = wallBuilder.buildWallFor(coordinates,0);

        Assertions.assertTrue(optionalWallCoordinates.isPresent());
        Assertions.assertEquals(0, optionalWallCoordinates.get().cordX);
        Assertions.assertEquals(1, optionalWallCoordinates.get().cordY);
    }

    @Test
    public void itShouldBuildWall_case2(){
        Coordinates coordinates = new Coordinates(0,0);
        coordinates.nextCoordinates =
                List.of(
                        new Coordinates(0,1,"3"),
                        new Coordinates(1,1,"8"),
                        new Coordinates(1,2,"-10")
                );


        WallBuilder wallBuilder = new WallBuilder();

        Optional<Coordinates> optionalWallCoordinates = wallBuilder.buildWallFor(coordinates, 1);

        Assertions.assertTrue(optionalWallCoordinates.isPresent());

        Assertions.assertEquals(1, optionalWallCoordinates.get().cordX);
        Assertions.assertEquals(1, optionalWallCoordinates.get().cordY);
    }
}
