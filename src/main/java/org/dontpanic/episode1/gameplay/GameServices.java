package org.dontpanic.episode1.gameplay;

import org.dontpanic.episode1.gameinit.staticdata.InitializedData;
import org.dontpanic.episode1.gameplay.clone.CloneCoordinatesDirectionUpdater;
import org.dontpanic.episode1.gameplay.clone.CloneInitializer;
import org.dontpanic.episode1.gameplay.clone.LeadingCloneBlocker;
import org.dontpanic.episode1.gameplay.clone.LeadingCloneUpdater;
import org.dontpanic.episode1.gameplay.coordinates.YAxisDirection;
import org.dontpanic.episode1.gameplay.coordinates.YAxisDirectionCalculator;
import org.dontpanic.episode1.gameplay.elements.GameElementBuilder;
import org.dontpanic.episode1.gameplay.elements.GameElementsContainer;
import org.dontpanic.episode1.logging.ProdDataLogger;
import org.dontpanic.episode1.logging.TestDataLogger;
import org.dontpanic.episode1.logging.map.MapLogger;
import org.dontpanic.episode1.logging.map.TestMapLogger;
import org.dontpanic.episode1.logging.map.GameMap;
import org.dontpanic.episode1.logging.map.GameMapInitializer;
import org.dontpanic.episode1.logging.map.GameMapUpdater;
import org.dontpanic.episode1.logging.BaseDataLogger;
import org.dontpanic.episode1.logging.map.ProdMapLogger;
import org.dontpanic.episode1.utils.Environment;

import java.util.ArrayList;

public class GameServices {
    public int countTurn;
    public GameElementsContainer gameElementsContainer;
    public CloneInitializer cloneInitializer;
    public MapLogger mapLogger;
    public CloneCoordinatesDirectionUpdater cloneCoordinatesDirectionUpdater;
    public GameMapUpdater gameMapUpdater;
    public GameMapInitializer gameMapInitializer;
    public LeadingCloneUpdater leadingCloneUpdater;
    public LeadingCloneBlocker leadingCloneBlocker;
    public GameMap gameMap;
    public CurrentGameAction currentGameAction;
    public InitializedData initializedData;
    public BaseDataLogger baseDataLogger;
    public GameElementBuilder gameElementBuilder;
    public YAxisDirectionCalculator yAxisDirectionCalculator;
    public GameServices(InitializedData initializedData, Environment environment){
        this.initializedData = initializedData;
        gameElementBuilder = new GameElementBuilder();
        gameElementsContainer = new GameElementsContainer();
        cloneInitializer = new CloneInitializer();
        cloneCoordinatesDirectionUpdater = new CloneCoordinatesDirectionUpdater();
        gameMapUpdater = new GameMapUpdater();
        gameMapInitializer = new GameMapInitializer();
        leadingCloneUpdater = new LeadingCloneUpdater();
        leadingCloneBlocker = new LeadingCloneBlocker();
        gameMap = new GameMap();
        currentGameAction = new CurrentGameAction();
        gameElementsContainer.cloneList = new ArrayList<>();
        gameElementsContainer.elevatorList = new ArrayList<>();
        yAxisDirectionCalculator = new YAxisDirectionCalculator(gameElementsContainer);

        if(environment == Environment.PROD) {
            mapLogger = new ProdMapLogger();
            baseDataLogger = new ProdDataLogger();
        }
        else {
            mapLogger = new TestMapLogger(gameMap, gameElementsContainer, initializedData);
            baseDataLogger = new TestDataLogger();
        }
    }


}
