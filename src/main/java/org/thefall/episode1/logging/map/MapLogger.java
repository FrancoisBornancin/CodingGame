package org.thefall.episode1.logging.map;

import java.io.PrintStream;

public class MapLogger {
    PrintStream printStream = System.out;
    private GameMap gameMap;
    public MapLogger(GameMap gameMap){
        this.gameMap = gameMap;
    }

    public void logMap(){
        printStream.println("gameMap: ");
        this.gameMap.map.forEach(line -> printStream.println("    " + line));
    }
}
