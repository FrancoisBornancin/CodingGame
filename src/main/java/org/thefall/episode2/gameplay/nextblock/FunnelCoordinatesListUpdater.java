package org.thefall.episode2.gameplay.nextblock;

import org.thefall.episode2.gameplay.GameResponse;
import org.thefall.episode2.gameplay.nextblock.builder.TurnBlockMapBuilder;
import org.thefall.episode2.gameplay.nextblock.info.FunnelCoordinatesContainer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class FunnelCoordinatesListUpdater {
    public FunnelCoordinatesContainer funnelCoordinatesContainer;
    public WaitGameResponseIterator waitGameResponseIterator;
    public TurnBlockMapBuilder turnBlockMapBuilder;

    public FunnelCoordinatesListUpdater(FunnelCoordinatesContainer funnelCoordinatesContainer) {
        this.funnelCoordinatesContainer = funnelCoordinatesContainer;
        this.waitGameResponseIterator = new WaitGameResponseIterator();
        this.turnBlockMapBuilder = new TurnBlockMapBuilder();
    }


    public void refactorGameResponseList(){
        List<GameResponse> reverseDirectionList =
            this.funnelCoordinatesContainer.funnelCoordinates.stream()
                    .filter(gameResponse -> gameResponse.gameDirection == GameDirection.REVERSE)
                    .toList();
        if(!reverseDirectionList.isEmpty()){
            this.waitGameResponseIterator.recalculatedReverseDirection(funnelCoordinatesContainer.funnelCoordinates);
        }
    }

    public void replaceNextFreeWaitResponse(Coordinates coordinates, int waitIndex){
        GameResponse waitGameResponse =
            funnelCoordinatesContainer.funnelCoordinates.get(waitIndex);
        waitGameResponse.coordinates = coordinates;
        waitGameResponse.gameDirection = GameDirection.RIGHT;
        waitGameResponse.coordinates.value = turnBlockMapBuilder.getNextBlockValueAfterTurned(GameDirection.RIGHT, waitGameResponse.coordinates.value);
    }

    public void addGameResponse(GameResponse gameResponse){
        if(this.funnelCoordinatesContainer.funnelCoordinates == null) this.funnelCoordinatesContainer.funnelCoordinates = new ArrayList<>();
        Optional<GameResponse> optionalGameResponse = this.contains(gameResponse.coordinates);
        if(optionalGameResponse.isPresent()){
            GameResponse gameResponseFromList = optionalGameResponse.get();
            gameResponseFromList.gameDirection = gameResponse.gameDirection;
        }else this.funnelCoordinatesContainer.funnelCoordinates.add(gameResponse);
    }

    private Optional<GameResponse> contains(Coordinates coordinates){
        if(this.funnelCoordinatesContainer.funnelCoordinates == null) return Optional.empty();
        return this.funnelCoordinatesContainer.funnelCoordinates.stream()
                .filter(gameResponseToTest -> gameResponseToTest.coordinates.cordX == coordinates.cordX && gameResponseToTest.coordinates.cordY == coordinates.cordY)
                .findFirst();
    }
}
