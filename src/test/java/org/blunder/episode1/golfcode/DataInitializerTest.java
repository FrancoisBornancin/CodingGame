package org.blunder.episode1.golfcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DataInitializerTest {
    @Test
    void itShouldInitCoordinates_case1(){
        BlunderMover blunderMover = new BlunderMover();
        Blunder blunder = new Blunder();
        new DataInitializer().initData(
                List.of(
                        "@  ",
                        "   ",
                        "  $"
                ),
                blunderMover,
                blunder,
                new MapScanner()
        );

        Assertions.assertEquals(0, blunder.coordinateX);
        Assertions.assertEquals(0, blunder.coordinateY);
    }

    @Test
    void itShouldInitCoordinates_case2(){
        BlunderMover blunderMover = new BlunderMover();
        Blunder blunder = new Blunder();
        new DataInitializer().initData(
                List.of(
                        "        ",
                        "  S   W ",
                        "        ",
                        "  $     ",
                        "        ",
                        "@       ",
                        "        ",
                        "E     N "
                ),
                blunderMover,
                blunder,
                new MapScanner()
        );

        Assertions.assertEquals(0, blunder.coordinateX);
        Assertions.assertEquals(5, blunder.coordinateY);
    }

    @Test
    void itShouldInitCoordinates_case3(){
        BlunderMover blunderMover = new BlunderMover();
        Blunder blunder = new Blunder();
        new DataInitializer().initData(
                List.of(
                        "  #@#I  T$#  ",
                        "  #    IB #  ",
                        "  #     W #  ",
                        "  #      ##  ",
                        "  #B XBN# #  ",
                        "  ##      #  ",
                        "  #       #  ",
                        "  #     W #  ",
                        "  #      ##  ",
                        "  #B XBN# #  ",
                        "  ##      #  ",
                        "  #       #  ",
                        "  #     W #  ",
                        "  #      ##  ",
                        "  #B XBN# #  ",
                        "  ##      #  ",
                        "  #       #  ",
                        "  #       #  ",
                        "  #      ##  ",
                        "  #  XBIT #  ",
                        "  #########  ",
                        "             ",
                        " ##### ##### ",
                        " #     #     ",
                        " #     #  ## ",
                        " #     #   # ",
                        " ##### ##### ",
                        "             "
                ),
                blunderMover,
                blunder,
                new MapScanner()
        );

        Assertions.assertEquals(3, blunder.coordinateX);
        Assertions.assertEquals(0, blunder.coordinateY);
    }
}
