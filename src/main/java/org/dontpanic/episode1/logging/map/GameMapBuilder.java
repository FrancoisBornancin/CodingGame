package org.dontpanic.episode1.logging.map;

import org.dontpanic.episode1.gameplay.elements.Elevator;
import org.dontpanic.episode1.gameplay.elements.FinishDoor;
import org.dontpanic.episode1.gameplay.elements.GameElements;
import org.dontpanic.episode1.gameplay.elements.StartingDoor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class GameMapBuilder {
    int mapWidth;
    int mapHeight;
    public List<String> convertMapCharTabToList(char[][] gameMapChar){
        return Arrays.stream(gameMapChar)
                .map(element -> new String(element))
                .toList();
    }

    public char[][] initCharTab(List<String> map){
        return initCharTab(map.get(0).length(), map.size());
    }

    public char[][] initCharTab(int width, int height){
        this.mapWidth = width;
        this.mapHeight = height;
        return new char[height][width];
    }

    public char[][] convertListToCharTab(List<String> map){
        char[][] charTab = initCharTab(map);
        for(int a = 0 ; a < charTab.length ; a++){
            for(int b = 0 ; b < charTab[0].length ; b++){
                charTab[a][b] = map.get(a).charAt(b);
            }
        }
        return charTab;
    }

    public char[][] initMap(char[][] gameMapChar){
        int length = gameMapChar.length;
        int width = gameMapChar[0].length;

        for(int a = 0 ; a < length ; a++){
            for(int b = 0 ; b < width ; b++){
                gameMapChar[a][b] = GameElements.WHITE_SPACE.value;
            }
        }

        return gameMapChar;
    }

    public char[][] putFinishDoorInMap(Map<Integer, Integer> finishDoorMap, char[][] gameMapChar){
        finishDoorMap.keySet().stream()
                .forEach(key -> {
                    int keyChar = key;
                    int value = finishDoorMap.get(key);
                    gameMapChar[keyChar][value] = GameElements.FINISH_DOOR.value;
                });
        return gameMapChar;
    }

    public char[][] putFinishDoorInMap(FinishDoor finishDoor, char[][] gameMapChar){
        gameMapChar[finishDoor.cordY][finishDoor.cordX] = GameElements.FINISH_DOOR.value;
        return gameMapChar;
    }

    public char[][] putStartingDoorInMap(StartingDoor startingDoor, char[][] gameMapChar){
        gameMapChar[startingDoor.cordY][startingDoor.cordX] = GameElements.STARTING_DOOR.value;
        return gameMapChar;
    }

    public char[][] putElevatorsInMap(Map<Integer, List<Integer>> elevatorMap, char[][] gameMapChar){
        elevatorMap.keySet().stream()
                .forEach(key -> {
                    int keyChar = key;
                    int value = elevatorMap.get(key).get(0);
                    gameMapChar[keyChar][value] = GameElements.ELEVATOR.value;
                });
        return gameMapChar;
    }

    public char[][] putElevatorsInMap(List<Elevator> elevatorList, char[][] gameMapChar){
        elevatorList.forEach(elevator -> gameMapChar[elevator.cordY][elevator.cordX] = GameElements.ELEVATOR.value);
        return gameMapChar;
    }

    public char[][] putStartingCloneInfoInMap(StartingDoor startingDoor, char[][] gameMapChar){
        gameMapChar[startingDoor.cordY][startingDoor.cordX] = GameElements.STARTING_DOOR.value;
        return gameMapChar;
    }
}
