package org.thefall.episode2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.thefall.episode2.gameplay.GameResponse;
import org.thefall.episode2.gameplay.nextblock.Coordinates;
import org.thefall.episode2.gameplay.nextblock.GameDirection;
import org.thefall.episode2.gameplay.nextblock.WaitGameResponseIterator;

import java.util.List;

public class WaitGameResponseIteratorTest {
    @Test
    void itShouldRecalculateReverseDirection(){
        WaitGameResponseIterator waitGameResponseIterator = new WaitGameResponseIterator();
        List<GameResponse> initialGameResponseList =
            List.of(
                    new GameResponse(new Coordinates(0,0), null),
                    new GameResponse(new Coordinates(0,0), null),
                    new GameResponse(new Coordinates(0,0), null),
                    new GameResponse(new Coordinates(0,0), null),
                    new GameResponse(new Coordinates(1,1), GameDirection.REVERSE),
                    new GameResponse(new Coordinates(0,0), null),
                    new GameResponse(new Coordinates(0,0), null),
                    new GameResponse(new Coordinates(2,2), GameDirection.REVERSE)
            );

        waitGameResponseIterator.recalculatedReverseDirection(initialGameResponseList);
        List<GameResponse> expectedGameResponseList =
                List.of(
                        new GameResponse(new Coordinates(0,0), null),
                        new GameResponse(new Coordinates(0,0), null),
                        new GameResponse(new Coordinates(0,0), null),
                        new GameResponse(new Coordinates(1,1), GameDirection.RIGHT),
                        new GameResponse(new Coordinates(1,1), GameDirection.RIGHT),
                        new GameResponse(new Coordinates(0,0), null),
                        new GameResponse(new Coordinates(2,2), GameDirection.RIGHT),
                        new GameResponse(new Coordinates(2,2), GameDirection.RIGHT)
                );

        for(int a = 0 ; a < expectedGameResponseList.size() ; a++){
            Assertions.assertEquals(expectedGameResponseList.get(a).gameDirection, initialGameResponseList.get(a).gameDirection);
            Assertions.assertEquals(expectedGameResponseList.get(a).coordinates.cordX, initialGameResponseList.get(a).coordinates.cordX);
            Assertions.assertEquals(expectedGameResponseList.get(a).coordinates.cordY, initialGameResponseList.get(a).coordinates.cordY);
        }

    }
}
