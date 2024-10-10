package org.blunder.episode1.golfcode;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public List<String> play(Solution solution){
        List<String> rowsTab = new RowTabSimplifier().simplify(solution);
        BlunderMover blunderMover = new BlunderMover();
        Blunder blunder = new Blunder();
        MapScanner mapScanner = new MapScanner();
        new DataInitializer().initData(rowsTab, blunderMover, blunder, mapScanner);

        while (blunderMover.movements == Movements.CONTINUE){
            blunderMover.move(blunder, mapScanner);
        }

        if(blunderMover.movements == Movements.STOP){
            return blunder.bunderPath.stream()
                    .map(direction -> direction.value)
                    .toList();
        }else return List.of("LOOP");
    }
}
