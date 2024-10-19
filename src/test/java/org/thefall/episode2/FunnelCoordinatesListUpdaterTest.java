package org.thefall.episode2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.thefall.episode2.gameplay.GameResponse;
import org.thefall.episode2.gameplay.nextblock.Coordinates;
import org.thefall.episode2.gameplay.nextblock.FunnelCoordinatesListUpdater;
import org.thefall.episode2.gameplay.nextblock.GameDirection;
import org.thefall.episode2.gameplay.nextblock.info.FunnelCoordinatesContainer;

import java.util.List;

public class FunnelCoordinatesListUpdaterTest {
    @Nested
    public class AddGameResponseMethod{
        @Test
        void itShouldOverWriteGameResponseDirection_case1(){
            FunnelCoordinatesContainer funnelCoordinatesContainer = new FunnelCoordinatesContainer();
            FunnelCoordinatesListUpdater funnelCoordinatesListUpdater = new FunnelCoordinatesListUpdater(funnelCoordinatesContainer);
            funnelCoordinatesContainer.funnelCoordinates =
                    List.of(
                            new GameResponse(new Coordinates(0,0), null)
                    );

            funnelCoordinatesListUpdater.addGameResponse(new GameResponse(new Coordinates(0,0), GameDirection.RIGHT));

            Assertions.assertEquals(GameDirection.RIGHT, funnelCoordinatesContainer.funnelCoordinates.get(0).gameDirection);
        }

        @Test
        void itShouldOverWriteGameResponseDirection_case2(){
            FunnelCoordinatesContainer funnelCoordinatesContainer = new FunnelCoordinatesContainer();
            FunnelCoordinatesListUpdater funnelCoordinatesListUpdater = new FunnelCoordinatesListUpdater(funnelCoordinatesContainer);
            funnelCoordinatesContainer.funnelCoordinates =
                    List.of(
                            new GameResponse(new Coordinates(0,0), GameDirection.RIGHT)
                    );

            funnelCoordinatesListUpdater.addGameResponse(new GameResponse(new Coordinates(0,0), GameDirection.LEFT));

            Assertions.assertEquals(GameDirection.LEFT, funnelCoordinatesContainer.funnelCoordinates.get(0).gameDirection);
        }
    }
}
