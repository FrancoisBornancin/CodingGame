package org.dontpanic.episode1.logging.map;

import org.dontpanic.episode1.gameinit.staticdata.InitializedData;
import org.dontpanic.episode1.gameplay.elements.GameElementsContainer;

import java.io.PrintStream;

public class TestMapLogger implements MapLogger{
    PrintStream printStream = System.out;
    private GameMapUpdater gameMapUpdater;
    private GameMapInitializer gameMapInitializer;
    private GameMap gameMap;
    private GameElementsContainer gameElementsContainer;
    private InitializedData initializedData;
    public TestMapLogger(GameMap gameMap, GameElementsContainer gameElementsContainer, InitializedData initializedData){
        this.gameMapUpdater = new GameMapUpdater();
        this.gameMapInitializer = new GameMapInitializer();
        this.gameMap = gameMap;
        this.gameElementsContainer = gameElementsContainer;
        this.initializedData = initializedData;
    }
    @Override
    public void logMap(){
        printStream.println("gameMap: ");
        this.gameMap.map.forEach(line -> printStream.println("    " + line));
    }

    @Override
    public void updateGameMap() {
        this.gameMapUpdater.updateGameMap(gameMap, gameElementsContainer);
    }

    @Override
    public void initMap() {
        this.gameMap.map = this.gameMapInitializer.initMap(initializedData);
    }
}
