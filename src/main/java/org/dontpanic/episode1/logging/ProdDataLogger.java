package org.dontpanic.episode1.logging;

import org.dontpanic.episode1.gameinit.staticdata.StaticGameInitializedData;

import java.io.PrintStream;
import java.util.List;

public class ProdDataLogger implements BaseDataLogger{
    PrintStream printStream = System.err;

    @Override
    public void logStaticDatas(StaticGameInitializedData staticGameInitializedData){
        printStream.println("maxNbRounds: " + staticGameInitializedData.maxNbRounds);
        printStream.println("nbFloors: " + staticGameInitializedData.nbFloors);
        printStream.println("mapWidth: " + staticGameInitializedData.mapWidth);
        printStream.println("elevatorsMap: " + staticGameInitializedData.elevatorsMap);
        new MapPrinter<Integer, List<Integer>>().printMap(staticGameInitializedData.elevatorsMap);
        printStream.println("exitDoor: " + staticGameInitializedData.finishDoor);
        new MapPrinter<Integer, Integer>().printMap(staticGameInitializedData.finishDoor);
    }

    @Override
    public void logStartingCloneInfos(int floor, int position, String direction){
        printStream.println("LeadingClone informations: ");
        if(floor != -1){
            printStream.println("    Floor: " + floor);
            printStream.println("    Position: " + position);
            printStream.println("    Direction: " + direction);
        }else {
            printStream.println("    no information");
        }
    }

    @Override
    public void logDynamicTurnNumber(int turn) {
        printStream.println("turn n°: " + turn);
    }
}
