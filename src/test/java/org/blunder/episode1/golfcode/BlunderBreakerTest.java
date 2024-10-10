package org.blunder.episode1.golfcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BlunderBreakerTest {
    @Test
    void itShouldBreakWhenHavingABeer(){
        BlunderBreaker blunderBreaker = new BlunderBreaker();
        Blunder blunder = new Blunder();
        MapScanner mapScanner = new MapScanner();

        blunder.drinkBeer();
        mapScanner.nextCordX = 2;
        mapScanner.nextCordY = 1;
        mapScanner.map =
            new ArrayList<>(
                    List.of(
                            "@  ",
                            "  X"
                    )
            );

        blunderBreaker.breakObstacle(blunder, mapScanner);

        Assertions.assertEquals(
                ' ',
                mapScanner.map.get(mapScanner.nextCordY).charAt(mapScanner.nextCordX)
        );
    }

    @Test
    void itShouldNotBreakWhenHavingNoBeer(){
        BlunderBreaker blunderBreaker = new BlunderBreaker();
        Blunder blunder = new Blunder();
        MapScanner mapScanner = new MapScanner();

        mapScanner.nextCordX = 2;
        mapScanner.nextCordY = 1;
        mapScanner.map =
                List.of(
                        "@  ",
                        "  X"
                );

        blunderBreaker.breakObstacle(blunder, mapScanner);

        Assertions.assertEquals(
                'X',
                mapScanner.map.get(mapScanner.nextCordY).charAt(mapScanner.nextCordX)
        );
    }

    @Test
    void itShouldNotBreakWhenHavingSecondBeer(){
        BlunderBreaker blunderBreaker = new BlunderBreaker();
        Blunder blunder = new Blunder();
        MapScanner mapScanner = new MapScanner();

        blunder.drinkBeer();
        blunder.drinkBeer();
        mapScanner.nextCordX = 2;
        mapScanner.nextCordY = 1;
        mapScanner.map =
            List.of(
                    "@  ",
                    "  X"
            );

        blunderBreaker.breakObstacle(blunder, mapScanner);

        Assertions.assertEquals(
                'X',
                mapScanner.map.get(mapScanner.nextCordY).charAt(mapScanner.nextCordX)
        );
    }

    @Test
    void itShouldStillBeBrokenAfterBeingBrokenOnce(){
        BlunderBreaker blunderBreaker = new BlunderBreaker();
        Blunder blunder = new Blunder();
        MapScanner mapScanner = new MapScanner();

        blunder.drinkBeer();
        mapScanner.nextCordX = 2;
        mapScanner.nextCordY = 1;
        mapScanner.map =
            new ArrayList<>(
                    List.of(
                            "@  ",
                            "  X"
                    )
            );

        blunderBreaker.breakObstacle(blunder, mapScanner);

        Assertions.assertEquals(
                ' ',
                mapScanner.map.get(mapScanner.nextCordY).charAt(mapScanner.nextCordX)
        );
    }
}
