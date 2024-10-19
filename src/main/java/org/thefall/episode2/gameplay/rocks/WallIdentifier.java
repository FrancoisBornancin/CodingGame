package org.thefall.episode2.gameplay.rocks;

import org.thefall.episode2.gameplay.map.NextMapValueRetriever;
import org.thefall.episode2.gameplay.nextblock.Coordinates;
import org.thefall.episode2.gameplay.nextblock.builder.NextBlockBuilder;
import org.thefall.episode2.gameplay.nextblock.builder.NextCoordinatesRetriever;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Optional;

public class WallIdentifier {
    NextMapValueRetriever nextMapValueRetriever;

    NextCoordinatesRetriever nextCoordinatesRetriever;
    NextBlockBuilder nextBlockBuilder;

    public WallIdentifier(){
        this.nextCoordinatesRetriever = new NextCoordinatesRetriever();
        this.nextBlockBuilder = new NextBlockBuilder();
        this.nextMapValueRetriever = new NextMapValueRetriever();
    }

    public boolean hasNoWall(Coordinates rockCoordinates, String[][] mapTab){
        String nextMapValue = nextMapValueRetriever.getMapValue(rockCoordinates, mapTab);
        Optional<Coordinates> optionalNextCoordinates =
                nextCoordinatesRetriever.getNextCoordinatesPossible(rockCoordinates, nextMapValue);

        if(optionalNextCoordinates.isEmpty()) return false;
        else {
            ListIterator<Coordinates> listIterator = rockCoordinates.nextCoordinates.listIterator();

            while (listIterator.hasNext()){
                Coordinates nextCoordinatesToCheck = listIterator.next();
                if(!listIterator.hasNext()) return true;
                String nextMapValueToCheck = nextMapValueRetriever.getMapValue(nextCoordinatesToCheck, mapTab);
                Optional<Coordinates> optionalNextNextCoordinates =
                        nextCoordinatesRetriever.getNextCoordinatesPossible(nextCoordinatesToCheck, nextMapValueToCheck);

                if(optionalNextNextCoordinates.isEmpty()) return false;
            }
        }
        return false;
    }
}
