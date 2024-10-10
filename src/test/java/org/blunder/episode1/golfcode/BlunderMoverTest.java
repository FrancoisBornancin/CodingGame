package org.blunder.episode1.golfcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BlunderMoverTest {
    private void initMap(BlunderMover blunderMover, Blunder blunder, MapScanner mapScanner){
        new DataInitializer().initData(
                List.of(
                        "@  ",
                        " #$",
                        "   "
                ),
                blunderMover,
                blunder,
                mapScanner
        );
    }

    private void initPrioritiesMap(BlunderMover blunderMover){
        blunderMover.prioritiesMap =
                Map.of(PrioritiesInversor.NORMAL_PRIORITIES, List.of(Direction.FAKE, Direction.SOUTH, Direction.EAST, Direction.NORTH, Direction.WEST),
                        PrioritiesInversor.REVERSE_PRIORITIES, List.of(Direction.FAKE, Direction.WEST, Direction.NORTH, Direction.EAST, Direction.SOUTH)
                );
    }

    @Nested
    public class ReversePriorities {
        @Test @Disabled
        void itShouldGoWestWhenObstacle(){

            Assertions.assertTrue(false);

            BlunderMover blunderMover = new BlunderMover();
            Blunder blunder = new Blunder();
            MapScanner mapScanner = new MapScanner();
            initMap(blunderMover, blunder, mapScanner);

            blunderMover.prioritiesInversor = PrioritiesInversor.REVERSE_PRIORITIES;
            blunderMover.direction = Direction.SOUTH;
            blunder.coordinateX = 0;
            blunder.coordinateY = 2;

            blunderMover.move(blunder, mapScanner);

            Assertions.assertEquals(1, blunder.coordinateX);
            Assertions.assertEquals(2, blunder.coordinateY);
            Assertions.assertEquals(Direction.EAST, blunderMover.direction);
        }

        @Test @Disabled
        void itShouldGoWestNorthWhenObstacle(){

            Assertions.assertTrue(false);

            BlunderMover blunderMover = new BlunderMover();
            Blunder blunder = new Blunder();
            MapScanner mapScanner = new MapScanner();
            initMap(blunderMover, blunder, mapScanner);

            blunderMover.prioritiesInversor = PrioritiesInversor.REVERSE_PRIORITIES;
            blunderMover.direction = Direction.EAST;
            blunder.coordinateX = 2;
            blunder.coordinateY = 2;

            blunderMover.move(blunder, mapScanner);

            Assertions.assertEquals(2, blunder.coordinateX);
            Assertions.assertEquals(1, blunder.coordinateY);
            Assertions.assertEquals(Direction.NORTH, blunderMover.direction);
        }

        @Test @Disabled
        void itShouldGoWestNorthEastWhenObstacle(){

            Assertions.assertTrue(false);

            BlunderMover blunderMover = new BlunderMover();
            Blunder blunder = new Blunder();
            MapScanner mapScanner = new MapScanner();
            initMap(blunderMover, blunder, mapScanner);

            blunderMover.prioritiesInversor = PrioritiesInversor.REVERSE_PRIORITIES;
            blunderMover.direction = Direction.NORTH;
            blunder.coordinateX = 2;
            blunder.coordinateY = 0;

            blunderMover.move(blunder, mapScanner);

            Assertions.assertEquals(1, blunder.coordinateX);
            Assertions.assertEquals(0, blunder.coordinateY);
            Assertions.assertEquals(Direction.WEST, blunderMover.direction);
        }

        @Test @Disabled
        void itShouldStopWhenGoWestNorthEastSouthWest(){

            Assertions.assertTrue(false);

            BlunderMover blunderMover = new BlunderMover();
            Blunder blunder = new Blunder();
            MapScanner mapScanner = new MapScanner();
            initMap(blunderMover, blunder, mapScanner);

            blunderMover.prioritiesInversor = PrioritiesInversor.NORMAL_PRIORITIES;
            blunderMover.direction = Direction.WEST;
            blunder.coordinateX = 0;
            blunder.coordinateY = 2;

            blunderMover.move(blunder, mapScanner);

            Assertions.assertEquals(0, blunder.coordinateX);
            Assertions.assertEquals(1, blunder.coordinateY);
            Assertions.assertEquals(Direction.NORTH, blunderMover.direction);
        }

        @Test @Disabled
        void itShouldGoWestNorthEastSouthWhenObstacle(){

            Assertions.assertTrue(false);

            BlunderMover blunderMover = new BlunderMover();
            Blunder blunder = new Blunder();
            MapScanner mapScanner = new MapScanner();
            initMap(blunderMover, blunder, mapScanner);

            blunderMover.prioritiesInversor = PrioritiesInversor.REVERSE_PRIORITIES;
            blunderMover.direction = Direction.WEST;
            blunder.coordinateX = 0;
            blunder.coordinateY = 0;

            blunderMover.move(blunder, mapScanner);

            Assertions.assertEquals(0, blunder.coordinateX);
            Assertions.assertEquals(1, blunder.coordinateY);
            Assertions.assertEquals(Direction.SOUTH, blunderMover.direction);
        }

        @Test @Disabled
        void itShouldGoWestNorthForFirstObstacleAndWestForSecond(){

            Assertions.assertTrue(false);

            BlunderMover blunderMover = new BlunderMover();
            Blunder blunder = new Blunder();
            MapScanner mapScanner = new MapScanner();
            initMap(blunderMover, blunder, mapScanner);

            blunderMover.prioritiesInversor = PrioritiesInversor.REVERSE_PRIORITIES;
            blunderMover.direction = Direction.WEST;
            blunder.coordinateX = 0;
            blunder.coordinateY = 0;

            blunderMover.move(blunder, mapScanner);

            Assertions.assertEquals(0, blunder.coordinateX);
            Assertions.assertEquals(1, blunder.coordinateY);
            Assertions.assertEquals(Direction.SOUTH, blunderMover.direction);
        }
    }

    @Nested
    public class NormalPriorities {
        @Test
        void itShouldGoSouthEastNorthWhenObstacle(){
            BlunderMover blunderMover = new BlunderMover();
            Blunder blunder = new Blunder();
            MapScanner mapScanner = new MapScanner();
            initPrioritiesMap(blunderMover);
            mapScanner.map =
                List.of(
                        "   ",
                        "X X",
                        " X "
                );

            blunderMover.prioritiesInversor = PrioritiesInversor.NORMAL_PRIORITIES;
            blunderMover.direction = Direction.WEST;
            blunder.coordinateX = 1;
            blunder.coordinateY = 1;

            blunderMover.move(blunder, mapScanner);

            Assertions.assertEquals(1, blunder.coordinateX);
            Assertions.assertEquals(0, blunder.coordinateY);
            Assertions.assertEquals(Direction.NORTH, blunderMover.direction);
        }

        @Test
        void itShouldGoSouthWhenObstacle(){
            BlunderMover blunderMover = new BlunderMover();
            Blunder blunder = new Blunder();
            MapScanner mapScanner = new MapScanner();
            initPrioritiesMap(blunderMover);
            mapScanner.map =
                    List.of(
                            "   ",
                            "  X",
                            "   "
                    );

            blunderMover.prioritiesInversor = PrioritiesInversor.NORMAL_PRIORITIES;
            blunderMover.direction = Direction.EAST;
            blunder.coordinateX = 1;
            blunder.coordinateY = 1;

            blunderMover.move(blunder, mapScanner);

            Assertions.assertEquals(1, blunder.coordinateX);
            Assertions.assertEquals(2, blunder.coordinateY);
            Assertions.assertEquals(Direction.SOUTH, blunderMover.direction);
        }

        @Test
        void itShouldGoSouthEastWhenObstacle(){
            BlunderMover blunderMover = new BlunderMover();
            Blunder blunder = new Blunder();
            MapScanner mapScanner = new MapScanner();
            initPrioritiesMap(blunderMover);
            mapScanner.map =
                    List.of(
                            "   ",
                            "X  ",
                            " X "
                    );

            blunderMover.prioritiesInversor = PrioritiesInversor.NORMAL_PRIORITIES;
            blunderMover.direction = Direction.WEST;
            blunder.coordinateX = 1;
            blunder.coordinateY = 1;

            blunderMover.move(blunder, mapScanner);

            Assertions.assertEquals(2, blunder.coordinateX);
            Assertions.assertEquals(1, blunder.coordinateY);
            Assertions.assertEquals(Direction.EAST, blunderMover.direction);
        }

        @Test
        void itShouldGoSouthEastNorthWestWhenObstacle(){
            BlunderMover blunderMover = new BlunderMover();
            Blunder blunder = new Blunder();
            MapScanner mapScanner = new MapScanner();
            initPrioritiesMap(blunderMover);
            mapScanner.map =
                List.of(
                        " X ",
                        "  X",
                        " X "
                );

            blunderMover.prioritiesInversor = PrioritiesInversor.NORMAL_PRIORITIES;
            blunderMover.direction = Direction.NORTH;
            blunder.coordinateX = 1;
            blunder.coordinateY = 1;

            blunderMover.move(blunder, mapScanner);

            Assertions.assertEquals(0, blunder.coordinateX);
            Assertions.assertEquals(1, blunder.coordinateY);
            Assertions.assertEquals(Direction.WEST, blunderMover.direction);
        }

        @Test
        void itShouldGoSouthEastForFirstObstacleAndSouthForSecond(){
            BlunderMover blunderMover = new BlunderMover();
            Blunder blunder = new Blunder();
            MapScanner mapScanner = new MapScanner();
            initPrioritiesMap(blunderMover);
            mapScanner.map =
                    List.of(
                            "   ",
                            "  X",
                            " X "
                    );

            blunderMover.prioritiesInversor = PrioritiesInversor.NORMAL_PRIORITIES;
            blunderMover.direction = Direction.EAST;
            blunder.coordinateX = 1;
            blunder.coordinateY = 1;

            blunderMover.move(blunder, mapScanner);
            blunderMover.move(blunder, mapScanner);

            Assertions.assertEquals(1, blunder.coordinateX);
            Assertions.assertEquals(1, blunder.coordinateY);
            Assertions.assertEquals(Direction.SOUTH, blunderMover.direction);
        }

        @Test
        void itShouldStopWhenGoSouthEastNorthWestSouth(){
            BlunderMover blunderMover = new BlunderMover();
            Blunder blunder = new Blunder();
            MapScanner mapScanner = new MapScanner();
            mapScanner.map =
                    List.of(
                            " X ",
                            "X X",
                            " X "
                    );
            initPrioritiesMap(blunderMover);
            blunderMover.prioritiesInversor = PrioritiesInversor.NORMAL_PRIORITIES;
            blunderMover.direction = Direction.WEST;
            blunder.coordinateX = 1;
            blunder.coordinateY = 1;

            blunderMover.move(blunder, mapScanner);

            Assertions.assertEquals(1, blunder.coordinateX);
            Assertions.assertEquals(1, blunder.coordinateY);
            Assertions.assertEquals(Direction.WEST, blunderMover.direction);
        }
    }

    @Nested
    public class NoSpecificDirection {
        @Test @Disabled
        void itShouldKeepPreviousPositionsInMind(){
            BlunderMover blunderMover = new BlunderMover();
            Blunder blunder = new Blunder();
            MapScanner mapScanner = new MapScanner();
            initPrioritiesMap(blunderMover);
            mapScanner.map =
                List.of(
                        "@  ",
                        " # ",
                        "   "
                );

            blunderMover.direction = Direction.SOUTH;
            blunder.coordinateX = 0;
            blunder.coordinateY = 0;

            blunderMover.move(blunder, mapScanner);
            blunderMover.move(blunder, mapScanner);
            blunderMover.move(blunder, mapScanner);
            blunderMover.move(blunder, mapScanner);
            blunderMover.move(blunder, mapScanner);
            blunderMover.move(blunder, mapScanner);
            blunderMover.move(blunder, mapScanner);
            blunderMover.move(blunder, mapScanner);
            blunderMover.move(blunder, mapScanner);
            blunderMover.move(blunder, mapScanner);

            List<BlunderPosition> expectedBlunderPositionList =
                new ArrayList<>(
                    List.of(
                        new BlunderPosition(0, 0, Direction.SOUTH),
                        new BlunderPosition(0, 1, Direction.SOUTH),
                        new BlunderPosition(0, 2, Direction.SOUTH),
                        new BlunderPosition(1, 2, Direction.EAST),
                        new BlunderPosition(2, 2, Direction.EAST),
                        new BlunderPosition(2, 1, Direction.NORTH),
                        new BlunderPosition(2, 0, Direction.NORTH),
                        new BlunderPosition(1, 0, Direction.WEST),
                        new BlunderPosition(0, 0, Direction.WEST),
                        new BlunderPosition(0, 1, Direction.SOUTH)
                    )
                );

            List<BlunderPosition> calculatedPositionList =
                    blunderMover.blunderPositionList;

            Assertions.assertEquals(expectedBlunderPositionList.size(), calculatedPositionList.size());
            Assertions.assertEquals(
                    expectedBlunderPositionList.get(0).cordX,
                    calculatedPositionList.get(0).cordX
            );
            Assertions.assertEquals(
                    expectedBlunderPositionList.get(0).cordY,
                    calculatedPositionList.get(0).cordY
            );
            Assertions.assertEquals(
                    expectedBlunderPositionList.get(0).direction,
                    calculatedPositionList.get(0).direction
            );

            Assertions.assertEquals(
                    expectedBlunderPositionList.get(2).cordX,
                    calculatedPositionList.get(2).cordX
            );
            Assertions.assertEquals(
                    expectedBlunderPositionList.get(2).cordY,
                    calculatedPositionList.get(2).cordY
            );
            Assertions.assertEquals(
                    expectedBlunderPositionList.get(2).direction,
                    calculatedPositionList.get(2).direction
            );

            Assertions.assertEquals(
                    expectedBlunderPositionList.get(4).cordX,
                    calculatedPositionList.get(4).cordX
            );
            Assertions.assertEquals(
                    expectedBlunderPositionList.get(4).cordY,
                    calculatedPositionList.get(4).cordY
            );
            Assertions.assertEquals(
                    expectedBlunderPositionList.get(4).direction,
                    calculatedPositionList.get(4).direction
            );

            Assertions.assertEquals(
                    expectedBlunderPositionList.get(8).cordX,
                    calculatedPositionList.get(8).cordX
            );
            Assertions.assertEquals(
                    expectedBlunderPositionList.get(8).cordY,
                    calculatedPositionList.get(8).cordY
            );
            Assertions.assertEquals(
                    expectedBlunderPositionList.get(8).direction,
                    calculatedPositionList.get(8).direction
            );
        }

        @Test @Disabled
        void itShouldReversePrioritiesAfterInversor(){

            Assertions.assertTrue(false);

            BlunderMover blunderMover = new BlunderMover();
            Blunder blunder = new Blunder();
            MapScanner mapScanner = new MapScanner();
            initMap(blunderMover, blunder, mapScanner);

            blunderMover.direction = Direction.NORTH;
            blunder.coordinateX = 0;
            blunder.coordinateY = 1;

            blunderMover.move(blunder, mapScanner);

            Assertions.assertEquals(0, blunder.coordinateX);
            Assertions.assertEquals(0, blunder.coordinateY);
            Assertions.assertEquals(Direction.NORTH, blunderMover.direction);
        }

        @Test
        void itShouldKeepDirectionWhenNoObstacles_NORTH(){
            BlunderMover blunderMover = new BlunderMover();
            Blunder blunder = new Blunder();
            MapScanner mapScanner = new MapScanner();
            initMap(blunderMover, blunder, mapScanner);

            blunderMover.direction = Direction.NORTH;
            blunder.coordinateX = 0;
            blunder.coordinateY = 1;

            blunderMover.move(blunder, mapScanner);

            Assertions.assertEquals(0, blunder.coordinateX);
            Assertions.assertEquals(0, blunder.coordinateY);
            Assertions.assertEquals(Direction.NORTH, blunderMover.direction);
        }

        @Test
        void itShouldKeepDirectionWhenNoObstacles_SOUTH(){
            BlunderMover blunderMover = new BlunderMover();
            Blunder blunder = new Blunder();
            MapScanner mapScanner = new MapScanner();
            initMap(blunderMover, blunder, mapScanner);

            blunderMover.direction = Direction.SOUTH;
            blunder.coordinateX = 0;
            blunder.coordinateY = 0;

            blunderMover.move(blunder, mapScanner);

            Assertions.assertEquals(0, blunder.coordinateX);
            Assertions.assertEquals(1, blunder.coordinateY);
            Assertions.assertEquals(Direction.SOUTH, blunderMover.direction);
        }

        @Test
        void itShouldKeepDirectionWhenNoObstacles_EAST(){
            BlunderMover blunderMover = new BlunderMover();
            Blunder blunder = new Blunder();
            MapScanner mapScanner = new MapScanner();
            initMap(blunderMover, blunder, mapScanner);

            blunderMover.direction = Direction.EAST;
            blunder.coordinateX = 0;
            blunder.coordinateY = 0;

            blunderMover.move(blunder, mapScanner);

            Assertions.assertEquals(1, blunder.coordinateX);
            Assertions.assertEquals(0, blunder.coordinateY);
            Assertions.assertEquals(Direction.EAST, blunderMover.direction);
        }

        @Test
        void itShouldKeepDirectionWhenNoObstacles_WEST(){
            BlunderMover blunderMover = new BlunderMover();
            Blunder blunder = new Blunder();
            MapScanner mapScanner = new MapScanner();
            initMap(blunderMover, blunder, mapScanner);

            blunderMover.direction = Direction.WEST;
            blunder.coordinateX = 1;
            blunder.coordinateY = 0;

            blunderMover.move(blunder, mapScanner);

            Assertions.assertEquals(0, blunder.coordinateX);
            Assertions.assertEquals(0, blunder.coordinateY);
            Assertions.assertEquals(Direction.WEST, blunderMover.direction);
        }

        @Test
        void itShouldChangeDirectionWhenNoBreakableObstacles(){
            BlunderMover blunderMover = new BlunderMover();
            Blunder blunder = new Blunder();
            MapScanner mapScanner = new MapScanner();
            initMap(blunderMover, blunder, mapScanner);

            blunderMover.prioritiesInversor = PrioritiesInversor.NORMAL_PRIORITIES;
            blunderMover.direction = Direction.SOUTH;
            blunder.coordinateX = 1;
            blunder.coordinateY = 0;

            blunderMover.move(blunder, mapScanner);

            Assertions.assertEquals(2, blunder.coordinateX);
            Assertions.assertEquals(0, blunder.coordinateY);
            Assertions.assertEquals(Direction.EAST, blunderMover.direction);
        }

        @Test
        void itShouldChangeDirectionWhenBreakableObstaclesAndNoBeer(){
            BlunderMover blunderMover = new BlunderMover();
            Blunder blunder = new Blunder();

            initPrioritiesMap(blunderMover);
            blunderMover.prioritiesInversor = PrioritiesInversor.NORMAL_PRIORITIES;
            blunderMover.direction = Direction.EAST;

            blunder.coordinateX = 0;
            blunder.coordinateY = 0;

            MapScanner mapScanner = new MapScanner();
            mapScanner.map = new ArrayList<>(
                    List.of(
                            "      X ",
                            "        "
                    )
            );

            blunderMover.move(blunder, mapScanner);
            blunderMover.move(blunder, mapScanner);
            blunderMover.move(blunder, mapScanner);
            blunderMover.move(blunder, mapScanner);
            blunderMover.move(blunder, mapScanner);
            blunderMover.move(blunder, mapScanner);

            Assertions.assertEquals(5, blunder.coordinateX);
            Assertions.assertEquals(1, blunder.coordinateY);
        }

        @Test
        void itShouldChangeDirectionWhenSouthElement(){
            BlunderMover blunderMover = new BlunderMover();
            Blunder blunder = new Blunder();

            blunderMover.prioritiesInversor = PrioritiesInversor.NORMAL_PRIORITIES;
            blunderMover.direction = Direction.EAST;

            blunder.coordinateX = 0;
            blunder.coordinateY = 0;

            MapScanner mapScanner = new MapScanner();
            mapScanner.map = new ArrayList<>(
                    List.of(
                            " S ",
                            "   "
                    )
            );

            blunderMover.move(blunder, mapScanner);
            blunderMover.move(blunder, mapScanner);

            Assertions.assertEquals(1, blunder.coordinateX);
            Assertions.assertEquals(1, blunder.coordinateY);
        }

        @Test
        void itShouldChangeDirectionWhenNorthElement(){
            BlunderMover blunderMover = new BlunderMover();
            Blunder blunder = new Blunder();

            blunderMover.prioritiesInversor = PrioritiesInversor.NORMAL_PRIORITIES;
            blunderMover.direction = Direction.EAST;

            blunder.coordinateX = 0;
            blunder.coordinateY = 1;

            MapScanner mapScanner = new MapScanner();
            mapScanner.map = new ArrayList<>(
                    List.of(
                            "   ",
                            " N "
                    )
            );

            blunderMover.move(blunder, mapScanner);
            blunderMover.move(blunder, mapScanner);

            Assertions.assertEquals(1, blunder.coordinateX);
            Assertions.assertEquals(0, blunder.coordinateY);
        }

        @Test
        void itShouldChangeDirectionWhenEastElement(){
            BlunderMover blunderMover = new BlunderMover();
            Blunder blunder = new Blunder();

            blunderMover.prioritiesInversor = PrioritiesInversor.NORMAL_PRIORITIES;
            blunderMover.direction = Direction.NORTH;

            blunder.coordinateX = 1;
            blunder.coordinateY = 1;

            MapScanner mapScanner = new MapScanner();
            mapScanner.map = new ArrayList<>(
                    List.of(
                            " E ",
                            "   "
                    )
            );

            blunderMover.move(blunder, mapScanner);
            blunderMover.move(blunder, mapScanner);

            Assertions.assertEquals(2, blunder.coordinateX);
            Assertions.assertEquals(0, blunder.coordinateY);
        }

        @Test
        void itShouldChangeDirectionWhenWestElement(){
            BlunderMover blunderMover = new BlunderMover();
            Blunder blunder = new Blunder();

            blunderMover.prioritiesInversor = PrioritiesInversor.NORMAL_PRIORITIES;
            blunderMover.direction = Direction.NORTH;

            blunder.coordinateX = 1;
            blunder.coordinateY = 1;

            MapScanner mapScanner = new MapScanner();
            mapScanner.map = new ArrayList<>(
                    List.of(
                            " W ",
                            "   "
                    )
            );

            blunderMover.move(blunder, mapScanner);
            blunderMover.move(blunder, mapScanner);

            Assertions.assertEquals(0, blunder.coordinateX);
            Assertions.assertEquals(0, blunder.coordinateY);
        }

        @Test
        void itShouldKeepDirectionWhenBreakableObstaclesAndBeer(){
            BlunderMover blunderMover = new BlunderMover();
            Blunder blunder = new Blunder();

            blunderMover.prioritiesInversor = PrioritiesInversor.NORMAL_PRIORITIES;
            blunderMover.direction = Direction.EAST;

            blunder.coordinateX = 0;
            blunder.coordinateY = 0;

            MapScanner mapScanner = new MapScanner();
            mapScanner.map = new ArrayList<>(
                    List.of(
                            "  B   X ",
                            "        "
                    )
            );

            blunderMover.move(blunder, mapScanner);
            blunderMover.move(blunder, mapScanner);
            blunderMover.move(blunder, mapScanner);
            blunderMover.move(blunder, mapScanner);
            blunderMover.move(blunder, mapScanner);
            blunderMover.move(blunder, mapScanner);
            blunderMover.move(blunder, mapScanner);

            Assertions.assertEquals(7, blunder.coordinateX);
            Assertions.assertEquals(0, blunder.coordinateY);
        }

        @Test
        void itShouldGoToOtherTeleporter_case1(){
            BlunderMover blunderMover = new BlunderMover();
            Blunder blunder = new Blunder();
            MapScanner mapScanner = new MapScanner();
            new DataInitializer().initData(
                    List.of(
                            "@  ",
                            "  T",
                            "   ",
                            "   ",
                            "   ",
                            "T  "
                    ),
                    blunderMover,
                    blunder,
                    mapScanner
            );

            blunderMover.direction = Direction.SOUTH;
            blunder.coordinateX = 2;
            blunder.coordinateY = 0;

            blunderMover.move(blunder, mapScanner);

            Assertions.assertEquals(0, blunder.coordinateX);
            Assertions.assertEquals(5, blunder.coordinateY);
        }
    }

    @Nested
    public class blunderPath {
        @Test
        void bunderPathShouldBeUpdatedAfterEachMove(){
            BlunderMover blunderMover = new BlunderMover();
            Blunder blunder = new Blunder();
            MapScanner mapScanner = new MapScanner();
            initMap(blunderMover, blunder, mapScanner);

            blunderMover.prioritiesInversor = PrioritiesInversor.NORMAL_PRIORITIES;
            blunderMover.direction = Direction.SOUTH;
            blunder.coordinateX = 0;
            blunder.coordinateY = 0;

            blunderMover.move(blunder, mapScanner);
            blunderMover.move(blunder, mapScanner);
            blunderMover.move(blunder, mapScanner);
            blunderMover.move(blunder, mapScanner);
            blunderMover.move(blunder, mapScanner);

            Assertions.assertEquals(5, blunder.bunderPath.size());
        }

        @Test
        void bunderPathShouldBeUpdatedEvenWhenSeveralSucessivelyObstacles(){
            BlunderMover blunderMover = new BlunderMover();
            Blunder blunder = new Blunder();
            MapScanner mapScanner = new MapScanner();
            initMap(blunderMover, blunder, mapScanner);

            blunderMover.prioritiesInversor = PrioritiesInversor.NORMAL_PRIORITIES;
            blunderMover.direction = Direction.SOUTH;
            blunder.coordinateX = 0;
            blunder.coordinateY = 0;

            blunderMover.move(blunder, mapScanner);
            blunderMover.move(blunder, mapScanner);
            blunderMover.move(blunder, mapScanner);
            blunderMover.move(blunder, mapScanner);
            blunderMover.move(blunder, mapScanner);

            Assertions.assertEquals(5, blunder.bunderPath.size());
        }
    }
}
