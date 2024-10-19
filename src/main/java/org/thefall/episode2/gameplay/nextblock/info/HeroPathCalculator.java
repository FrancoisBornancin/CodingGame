package org.thefall.episode2.gameplay.nextblock.info;

import org.thefall.episode2.gameplay.GameResponse;
import org.thefall.episode2.gameplay.elements.exit.ExitDoor;
import org.thefall.episode2.gameplay.map.NextMapValueRetriever;
import org.thefall.episode2.gameplay.nextblock.Coordinates;
import org.thefall.episode2.gameplay.nextblock.FunnelCoordinatesListUpdater;
import org.thefall.episode2.gameplay.nextblock.GameDirection;
import org.thefall.episode2.gameplay.nextblock.builder.NextBlockBuilder;
import org.thefall.episode2.gameplay.nextblock.builder.NextCoordinatesRetriever;
import org.thefall.episode2.gameplay.nextblock.builder.TurnBlockMapBuilder;
import org.thefall.episode2.gameplay.nextblock.caching.CoordinatesCache;
import org.thefall.episode2.gameplay.nextblock.caching.CoordinatesCacheCommand;
import org.thefall.episode2.gameplay.nextblock.caching.CoordinatesCacheRetriever;

import java.util.Optional;

public class HeroPathCalculator {
    NextCoordinatesRetriever nextCoordinatesRetriever = new NextCoordinatesRetriever();
    public FunnelCoordinatesContainer funnelCoordinatesContainer;
    TurnBlockMapBuilder turnBlockMapBuilder;
    public ExitDoor exitDoor;
    CoordinatesCacheRetriever coordinatesCacheRetriever;
    MovableBlockQualifier movableBlockQualifier;
    CoordinatesCacheCommand coordinatesCacheCommand;
    public FunnelCoordinatesListUpdater funnelCoordinatesListUpdater;
    NextMapValueRetriever nextMapValueRetriever;
    NextBlockBuilder nextBlockBuilder;
    public String[][] mapTab;
    int maxSize = 0;
    int countTurn = 0;
    public HeroPathCalculator(FunnelCoordinatesContainer funnelCoordinatesContainer){
        this.nextCoordinatesRetriever = new NextCoordinatesRetriever();
        this.turnBlockMapBuilder = new TurnBlockMapBuilder();
        this.coordinatesCacheRetriever = new CoordinatesCacheRetriever();
        this.movableBlockQualifier = new MovableBlockQualifier();
        this.coordinatesCacheCommand = new CoordinatesCacheCommand(coordinatesCacheRetriever, movableBlockQualifier, funnelCoordinatesContainer);
        this.funnelCoordinatesContainer = funnelCoordinatesContainer;
        this.funnelCoordinatesListUpdater = new FunnelCoordinatesListUpdater(this.funnelCoordinatesContainer);
        this.nextMapValueRetriever = new NextMapValueRetriever();
        this.nextBlockBuilder = new NextBlockBuilder();
    }
    public void buildPath(Coordinates currentCoordinates){
        getInfo(currentCoordinates, null, null, false);
    }

    private FunnelCoordinatesContainer getInfo(Coordinates currentCoordinates, String possiblyNextMapValue, GameDirection gameDirection, boolean directionFromCache){
        countTurn++;
        String nextMapValue = possiblyNextMapValue;
        if(nextMapValue == null) nextMapValue = nextMapValueRetriever.getMapValue(currentCoordinates, mapTab);
        coordinatesCacheCommand.insert(currentCoordinates, nextMapValue);
        Optional<Coordinates> optionalNextCoordinates = nextCoordinatesRetriever.getNextCoordinatesPossible(currentCoordinates, nextMapValue);
        if(optionalNextCoordinates.isPresent()) {
            Coordinates newCoordinatesInfo = optionalNextCoordinates.get();
            Coordinates nextCoordinates = nextBlockBuilder.buildNextCoordinates(currentCoordinates, newCoordinatesInfo);

            if(directionFromCache) addGameResponse(nextCoordinates, gameDirection);
            else addGameResponse(nextCoordinates, null);

            if(nextCoordinates.cordX == exitDoor.cordX && nextCoordinates.cordY == exitDoor.cordY){
                funnelCoordinatesListUpdater.refactorGameResponseList();
                return funnelCoordinatesContainer;
            }

            return getInfo(nextCoordinates, null, gameDirection, false);
        }else{
                CoordinatesCache coordinatesCache = coordinatesCacheCommand.getLast();
                String nextBlockAfterTurnedValue = turnBlockMapBuilder.getNextBlockValueAfterTurned(coordinatesCache.gameDirection, coordinatesCache.nextMapValue);
                return getInfo(coordinatesCache.coordinates, nextBlockAfterTurnedValue, coordinatesCache.gameDirection, true);
        }
    }

    private void addGameResponse(Coordinates coordinates, GameDirection gameDirection){
        funnelCoordinatesListUpdater.addGameResponse(new GameResponse(coordinates, gameDirection));
    }
}
