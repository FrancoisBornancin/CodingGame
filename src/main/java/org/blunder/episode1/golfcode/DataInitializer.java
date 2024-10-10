package org.blunder.episode1.golfcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataInitializer {
    public void initData(
            List<String> rowMap,
            BlunderMover blunderMover,
            Blunder blunder,
            MapScanner mapScanner
    ){
        blunder.bunderPath = new ArrayList<>();

        blunderMover.direction = Direction.SOUTH;

        blunderMover.prioritiesMap =
            Map.of(PrioritiesInversor.NORMAL_PRIORITIES, List.of(Direction.FAKE, Direction.SOUTH, Direction.EAST, Direction.NORTH, Direction.WEST),
                   PrioritiesInversor.REVERSE_PRIORITIES, List.of(Direction.FAKE, Direction.WEST, Direction.NORTH, Direction.EAST, Direction.SOUTH)
            );

        mapScanner.initElements(rowMap, blunder);
    }
}
