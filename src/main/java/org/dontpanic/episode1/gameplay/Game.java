package org.dontpanic.episode1.gameplay;

import org.dontpanic.episode1.gameinit.staticdata.InitializedData;
import org.dontpanic.episode1.gameplay.clone.Clone;
import org.dontpanic.episode1.gameplay.clone.CloneCoordinatesDirectionUpdater;
import org.dontpanic.episode1.gameplay.clone.CloneDirection;
import org.dontpanic.episode1.gameplay.clone.CloneInitializer;
import org.dontpanic.episode1.gameplay.clone.LeadingCloneBlocker;
import org.dontpanic.episode1.gameplay.coordinates.YAxisDirectionCalculator;
import org.dontpanic.episode1.gameplay.elements.GameElementBuilder;
import org.dontpanic.episode1.gameplay.elements.GameElementsContainer;
import org.dontpanic.episode1.gameplay.elements.StartingDoor;
import org.dontpanic.episode1.logging.map.MapLogger;
import org.dontpanic.episode1.logging.BaseDataLogger;

import java.util.List;

public class Game {
    public GameAction play(GameServices gameServices, String startingCloneDirection, int startingCloneFloor, int startingClonePos){
        int countTurn = gameServices.countTurn;
        GameElementsContainer gameElementsContainer = gameServices.gameElementsContainer;
        CloneInitializer cloneInitializer = gameServices.cloneInitializer;
        MapLogger mapLogger = gameServices.mapLogger;
        CloneCoordinatesDirectionUpdater cloneCoordinatesDirectionUpdater = gameServices.cloneCoordinatesDirectionUpdater;
        LeadingCloneBlocker leadingCloneBlocker = gameServices.leadingCloneBlocker;
        CurrentGameAction currentGameAction = gameServices.currentGameAction;
        InitializedData initializedData = gameServices.initializedData;
        BaseDataLogger baseDataLogger = gameServices.baseDataLogger;
        GameElementBuilder gameElementBuilder = gameServices.gameElementBuilder;
        YAxisDirectionCalculator yAxisDirectionCalculator = gameServices.yAxisDirectionCalculator;

        baseDataLogger.logDynamicTurnNumber(countTurn);

        CloneDirection cloneStartingDirection;
        if(startingCloneDirection.equals(CloneDirection.LEFT.value)) cloneStartingDirection = CloneDirection.LEFT;
        else cloneStartingDirection = CloneDirection.RIGHT;

        if(countTurn == 1){
            baseDataLogger.logStartingCloneInfos(startingCloneFloor, startingClonePos, startingCloneDirection);
            StartingDoor startingDoor = new StartingDoor(startingClonePos, startingCloneFloor);
            initializedData.startingDoor = startingDoor;
            gameElementsContainer.startingDoor = startingDoor;
            gameElementBuilder.initElementContainers(gameElementsContainer, initializedData);
            yAxisDirectionCalculator.calculateDirection();
            gameElementsContainer.yAxisDirection = yAxisDirectionCalculator.yAxisDirection;
            mapLogger.initMap();
        }

        if((countTurn % 3) == 0){
            cloneInitializer.addNewClone(gameElementsContainer, cloneStartingDirection);
        }

        leadingCloneBlocker.blockClone(gameElementsContainer, currentGameAction);
        cloneCoordinatesDirectionUpdater.updateClonesCoordinatesAndDirection(gameElementsContainer);

        mapLogger.updateGameMap();
        mapLogger.logMap();

        System.out.println(currentGameAction.gameAction.value);
        return GameAction.WAIT;
    }
}
