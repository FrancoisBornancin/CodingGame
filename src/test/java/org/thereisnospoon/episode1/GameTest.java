package org.thereisnospoon.episode1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GameTest {
    @Test
    void testExemple(){
        Player player = new Player();

        player.elements =
                List.of(
                    "00",
                    "0."
                );
        player.width = 2;
        player.height = 2;

        Game game = new Game();

        Assertions.assertEquals(
                List.of(
                        "0 0 1 0 0 1",
                        "1 0 -1 -1 -1 -1",
                        "0 1 -1 -1 -1 -1"
                ),
                game.play(player)
        );
    }
}
