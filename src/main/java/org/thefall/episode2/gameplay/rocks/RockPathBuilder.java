package org.thefall.episode2.gameplay.rocks;

import org.thefall.episode2.gameplay.map.NextMapValueRetriever;
import org.thefall.episode2.gameplay.nextblock.Coordinates;
import org.thefall.episode2.gameplay.nextblock.builder.NextBlockBuilder;
import org.thefall.episode2.gameplay.nextblock.builder.NextCoordinatesRetriever;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class RockPathBuilder {
    NextMapValueRetriever nextMapValueRetriever;
    NextBlockBuilder nextBlockBuilder;
    NextCoordinatesRetriever nextCoordinatesRetriever;
    public RockPathBuilder() {
        this.nextMapValueRetriever = new NextMapValueRetriever();
        this.nextBlockBuilder = new NextBlockBuilder();
        this.nextCoordinatesRetriever = new NextCoordinatesRetriever();
    }
    public List<Coordinates> buildPath(Coordinates rockCoordinates, String[][] mapTab, List<Coordinates> nextCoordinatesList){
        String nextMapValue = nextMapValueRetriever.getMapValue(rockCoordinates, mapTab);
        Optional<Coordinates> optionalNextCoordinates = nextCoordinatesRetriever.getNextCoordinatesPossible(rockCoordinates, nextMapValue);
        if(optionalNextCoordinates.isPresent()){
            Coordinates newCoordinatesInfo = optionalNextCoordinates.get();
            Coordinates nextCoordinates = nextBlockBuilder.buildNextCoordinates(rockCoordinates, newCoordinatesInfo);
            nextCoordinatesList.add(nextCoordinates);
            buildPath(nextCoordinates, mapTab, nextCoordinatesList);
        }
        return nextCoordinatesList;
    }

    public void truncatePath(Coordinates rockCoordinates, int commCordIndex){
        int elementToTruncate = rockCoordinates.nextCoordinates.size() - commCordIndex;

        Collections.reverse(rockCoordinates.nextCoordinates);

        for(int a = 0 ; a < elementToTruncate ; a++){
            rockCoordinates.nextCoordinates.remove(0);
        }

        Collections.reverse(rockCoordinates.nextCoordinates);
    }
}
