package org.dwarfongiantshoulders.golfcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GameTest {
    @Test
    void itShouldBe3MaxRelationship_case1(){
        Game game = new Game();
        List<Node> relationShipList =
                List.of(
                        new Node(1, 2),
                        new Node(1, 3),
                        new Node(3, 4)
                );

        Assertions.assertEquals(3, game.play(relationShipList));
    }

    @Test
    void itShouldBe3MaxRelationship_case2(){
        Game game = new Game();
        List<Node> relationShipList =
                List.of(
                        new Node(2, 3),
                        new Node(8, 9),
                        new Node(1, 2),
                        new Node(6, 3)
                );

        Assertions.assertEquals(3, game.play(relationShipList));
    }

    @Test
    void itShouldBe4MaxRelationship(){
        Game game = new Game();
        List<Node> relationShipList =
                List.of(
                        new Node(1, 2),
                        new Node(1, 3),
                        new Node(3, 4),
                        new Node(2, 4),
                        new Node(2, 5),
                        new Node(10, 11),
                        new Node(10, 1),
                        new Node(10, 3)
                );

        Assertions.assertEquals(4, game.play(relationShipList));
    }

    @Test
    void itShouldBe5MaxRelationship(){
        Game game = new Game();
        List<Node> relationShipList =
                List.of(
                        new Node(7, 2),
                        new Node(8, 9),
                        new Node(1, 6),
                        new Node(6, 9),
                        new Node(1, 7),
                        new Node(1, 2),
                        new Node(3, 9),
                        new Node(2, 3),
                        new Node(6, 3)
                );

        Assertions.assertEquals(5, game.play(relationShipList));
    }
}
