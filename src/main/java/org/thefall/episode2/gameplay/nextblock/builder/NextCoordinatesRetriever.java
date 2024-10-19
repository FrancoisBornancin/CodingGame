package org.thefall.episode2.gameplay.nextblock.builder;

import org.thefall.episode2.gameplay.nextblock.Coordinates;

import java.util.Optional;

public class NextCoordinatesRetriever {
    NextBlockMapBuilder nextBlockMapBuilder;
    public NextCoordinatesRetriever() {
        nextBlockMapBuilder = new NextBlockMapBuilder();
    }

    public Optional<Coordinates> getNextCoordinatesPossible(Coordinates coordinates, String nextMapValue){
        try{
            if(nextMapValue.equals("0")) return Optional.empty();
            Coordinates nextCoordinatesValues = nextBlockMapBuilder.buildMap().get(coordinates.value).get(coordinates.direction).get(nextMapValue);
            if(nextCoordinatesValues == null) return Optional.empty();
            else return Optional.of(nextCoordinatesValues);
        }catch (NullPointerException e){
            return Optional.empty();
        }
    }
}
