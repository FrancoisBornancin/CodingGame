package org.telephonenumber.golfcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GameTest {
    @Test
    void testCase1(){
        Game game = new Game();
        Solution solution = new Solution();
        solution.telephonNumberList =
                new ArrayList<>(
                    List.of(
                            "0467123456"
                    )
                );

        Assertions.assertEquals(
                "10",
                game.play(solution)
        );
    }

    @Test
    void testCase2(){
        Game game = new Game();
        Solution solution = new Solution();
        solution.telephonNumberList =
                new ArrayList<>(
                        List.of(
                                "0123456789",
                                "1123456789"
                        )
                );

        Assertions.assertEquals(
                "20",
                game.play(solution)
        );
    }
}
