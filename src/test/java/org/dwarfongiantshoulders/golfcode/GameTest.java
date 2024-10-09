package org.dwarfongiantshoulders.golfcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GameTest {
    @Test
    void itShouldBe3MaxRelationship(){
        Game game = new Game();
        List<Node> relationShipList =
                List.of(
                        new Node(1, 2),
                        new Node(1, 3),
                        new Node(3, 4)
                );

        Assertions.assertEquals(3, game.play(relationShipList));
    }
}
