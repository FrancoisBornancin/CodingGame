package org.thefall.episode2.gameplay.rocks;

import org.thefall.episode2.gameplay.nextblock.Coordinates;
import org.thefall.episode2.gameplay.nextblock.info.MovableBlockQualifier;

import java.util.List;
import java.util.Optional;

public class WallBuilder {
    MovableBlockQualifier movableBlockQualifier;
    public WallBuilder() {
        this.movableBlockQualifier = new MovableBlockQualifier();
    }

    public Optional<Coordinates> buildWallFor(Coordinates coordinates, int waitIndex){
        System.err.println("waitIndex: " + waitIndex);
        System.err.println("coordinates.cordY: " + coordinates.cordY);
        System.err.println("coordinates.cordX: " + coordinates.cordX);
        System.err.println("coordinates.value: " + coordinates.value);
        System.err.println("coordinates.nextCoordinates.size(): " + coordinates.nextCoordinates.size());


        Optional<Coordinates> optionalMovableCoordinates =
            coordinates.nextCoordinates.stream()
                .peek(coordinatesToPrint -> System.err.println("innerCord.value: " + coordinatesToPrint.value))
                .skip(waitIndex)
                .filter(coordinate -> movableBlockQualifier.isMovable(coordinate.value))
                .findFirst();

        return optionalMovableCoordinates;
    }
}
