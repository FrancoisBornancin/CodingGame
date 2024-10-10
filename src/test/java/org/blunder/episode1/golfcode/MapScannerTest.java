package org.blunder.episode1.golfcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MapScannerTest {

    @Nested
    public class InitElements{
        @Test
        void itShouldInitElementsWithOnlyBlunderCoordinates(){
            MapScanner mapScanner = new MapScanner();
            Blunder blunder = new Blunder();
            mapScanner.initElements(
                    List.of(
                            "@  ",
                            "  T",
                            "T  "
                    ),
                    blunder
            );

            Assertions.assertNull(mapScanner.teleporterElements);
        }

        @Test
        void itShouldInitElementsWithOneTeleporter(){
            MapScanner mapScanner = new MapScanner();
            BlunderMover blunderMover = new BlunderMover();
            Blunder blunder = new Blunder();
            mapScanner.initElements(
                    List.of(
                            "@ T",
                            "T  "
                    ),
                    blunder
            );

            Assertions.assertEquals(1, mapScanner.teleporterElements.size());
            ElementTeleporter elementTeleporter = mapScanner.teleporterElements.get(0);
            Assertions.assertEquals(2, elementTeleporter.coordinateX);
            Assertions.assertEquals(0, elementTeleporter.coordinateY);
        }

        @Test
        void itShouldInitElementsWithTwoTeleporter(){
            MapScanner mapScanner = new MapScanner();
            BlunderMover blunderMover = new BlunderMover();
            Blunder blunder = new Blunder();
            mapScanner.initElements(
                    List.of(
                            "  T",
                            "T @"
                    ),
                    blunder
            );

            Assertions.assertEquals(2, mapScanner.teleporterElements.size());

            ElementTeleporter elementTeleporter1 = mapScanner.teleporterElements.get(0);
            Assertions.assertEquals(2, elementTeleporter1.coordinateX);
            Assertions.assertEquals(0, elementTeleporter1.coordinateY);

            ElementTeleporter elementTeleporter2 = mapScanner.teleporterElements.get(1);
            Assertions.assertEquals(0, elementTeleporter2.coordinateX);
            Assertions.assertEquals(1, elementTeleporter2.coordinateY);
        }
    }

    @Nested
    public class FindRemaingReporters{
        @Test
        void itShouldFindRemainingTeleporter_case1(){
            MapScanner mapScanner = new MapScanner();
            BlunderMover blunderMover = new BlunderMover();
            Blunder blunder = new Blunder();
            List<String> rowsTab =
                List.of(
                        "   ",
                        "T @",
                        "T  "
                );
            mapScanner.initElements(rowsTab, blunder);
            mapScanner.findRemainingTeleports();

            Assertions.assertEquals(2, mapScanner.teleporterElements.size());

            ElementTeleporter elementTeleporter1 = mapScanner.teleporterElements.get(0);
            Assertions.assertEquals(0, elementTeleporter1.coordinateX);
            Assertions.assertEquals(1, elementTeleporter1.coordinateY);

            ElementTeleporter elementTeleporter2 = mapScanner.teleporterElements.get(1);
            Assertions.assertEquals(0, elementTeleporter2.coordinateX);
            Assertions.assertEquals(2, elementTeleporter2.coordinateY);
        }

        @Test
        void itShouldFindRemainingTeleporter_case2(){
            MapScanner mapScanner = new MapScanner();
            BlunderMover blunderMover = new BlunderMover();
            Blunder blunder = new Blunder();
            List<String> rowsTab =
                List.of(
                        "   ",
                        "  @",
                        "T T"
                );
            mapScanner.initElements(rowsTab, blunder);
            mapScanner.findRemainingTeleports();

            Assertions.assertEquals(2, mapScanner.teleporterElements.size());

            ElementTeleporter elementTeleporter1 = mapScanner.teleporterElements.get(0);
            Assertions.assertEquals(0, elementTeleporter1.coordinateX);
            Assertions.assertEquals(2, elementTeleporter1.coordinateY);

            ElementTeleporter elementTeleporter2 = mapScanner.teleporterElements.get(1);
            Assertions.assertEquals(2, elementTeleporter2.coordinateX);
            Assertions.assertEquals(2, elementTeleporter2.coordinateY);
        }

        @Test
        void itShouldFindNoTeleporter(){
            MapScanner mapScanner = new MapScanner();
            BlunderMover blunderMover = new BlunderMover();
            Blunder blunder = new Blunder();
            List<String> rowsTab =
                List.of(
                        "T T",
                        "  @"
                );
            mapScanner.initElements(rowsTab, blunder);
            mapScanner.findRemainingTeleports();

            Assertions.assertEquals(2, mapScanner.teleporterElements.size());

            ElementTeleporter elementTeleporter1 = mapScanner.teleporterElements.get(0);
            Assertions.assertEquals(0, elementTeleporter1.coordinateX);
            Assertions.assertEquals(0, elementTeleporter1.coordinateY);

            ElementTeleporter elementTeleporter2 = mapScanner.teleporterElements.get(1);
            Assertions.assertEquals(2, elementTeleporter2.coordinateX);
            Assertions.assertEquals(0, elementTeleporter2.coordinateY);
        }
    }
}
