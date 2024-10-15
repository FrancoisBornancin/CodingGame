package org.dontpanic.episode1.logging.map;

import org.dontpanic.episode1.gameplay.clone.Clone;
import org.dontpanic.episode1.gameplay.clone.CloneState;
import org.dontpanic.episode1.gameplay.elements.CloneElementConvertor;
import org.dontpanic.episode1.gameplay.elements.Elevator;
import org.dontpanic.episode1.gameplay.elements.GameElements;
import org.dontpanic.episode1.gameplay.elements.GameElementsContainer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameMapUpdater {
    public void updateGameMap(GameMap gameMap, GameElementsContainer gameElementsContainer){
        GameMapBuilder gameMapBuilder = new GameMapBuilder();
        char[][] charTab = gameMapBuilder.convertListToCharTab(gameMap.map);

        rebuildGameMap(gameElementsContainer, charTab, gameMapBuilder);

        List<Clone> cloneList = gameElementsContainer.cloneList;
        char[][] finalCharTab = charTab;
        cloneList.stream()
                    .forEach(clone -> {
                        putCloneInCharTab(finalCharTab, clone, gameElementsContainer.elevatorList);
                    });

        List<String> listToReverse = new ArrayList<>(gameMapBuilder.convertMapCharTabToList(charTab));
        Collections.reverse(listToReverse);

        gameMap.map = listToReverse;
        System.err.println();
    }

    private void rebuildGameMap(GameElementsContainer gameElementsContainer, char[][] charTab, GameMapBuilder gameMapBuilder){
        gameMapBuilder.initMap(charTab);
        gameMapBuilder.putFinishDoorInMap(gameElementsContainer.finishDoor, charTab);
        gameMapBuilder.putStartingDoorInMap(gameElementsContainer.startingDoor, charTab);
        gameMapBuilder.putElevatorsInMap(gameElementsContainer.elevatorList, charTab);
    }

    private void putCloneInCharTab(char[][] charTab, Clone clone, List<Elevator> elevatorList){
        Character cloneElementValue;
        if(clone.state == CloneState.NOT_BLOCKED){
            cloneElementValue = CloneElementConvertor.cloneQualifierToElementMap.get(clone.qualifier).value;
        }
        else cloneElementValue = CloneElementConvertor.cloneStateToElementMap.get(clone.state).value;
        charTab[clone.cordY][clone.cordX] = cloneElementValue;
        putCloneOnElevatorInCharTab(charTab, elevatorList, clone);
    }

    private void putCloneOnElevatorInCharTab(char[][] charTab, List<Elevator> elevatorList, Clone clone){
        if(!elevatorList.isEmpty()){
            for(int a = 0 ; a < elevatorList.size() ; a++){
                Elevator elevator = elevatorList.get(a);
                if(elevator.cordX == clone.cordX && elevator.cordY == clone.cordY){
                    charTab[clone.cordY][clone.cordX] = GameElements.CLONE_ON_ELEVATOR.value;
                }
            }
        }
    }
}
