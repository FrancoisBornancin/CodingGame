package org.thefall.episode1.logging.map;

import org.thefall.episode1.gameplay.elements.exit.ExitDoor;
import org.thefall.episode1.gameplay.elements.hero.Hero;
import org.thefall.episode1.gameplay.elements.support.BaseElement;
import org.thefall.episode1.gameplay.elements.support.GameElementsContainer;
import org.thefall.episode1.gameplay.elements.tunnel.TunnelElement;
import org.thefall.episode1.gameplay.elements.tunnel.TunnelMapElementRetriever;
import org.thefall.episode1.gameplay.nextblock.Coordinates;
import org.thefall.episode1.logging.errors.ElementOutOfMapHeight;
import org.thefall.episode1.logging.errors.ElementOutOfMapWidth;
import org.thefall.episode1.gameplay.map.MapBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameMapUpdater {
    int mapWidth;
    int mapHeight;
    private static String DELIMITER = " ";
    TunnelMapElementRetriever tunnelMapElementRetriever;

    public void updateExitDoorValues(GameElementsContainer gameElementsContainer, Coordinates coordinates){
        gameElementsContainer.exitDoor.previousValueRegistered = true;
        gameElementsContainer.exitDoor.previousCordX = gameElementsContainer.exitDoor.cordX;
        gameElementsContainer.exitDoor.previousCordY = gameElementsContainer.exitDoor.cordY;
        gameElementsContainer.exitDoor.cordX = coordinates.cordX;
        gameElementsContainer.exitDoor.cordY = coordinates.cordY;
    }
    public void updateGameMap(GameElementsContainer gameElementsContainer, TunnelElement tunnelElementToUpdate){
        GameMap gameMap = gameElementsContainer.gameMap;
        Hero hero = gameElementsContainer.hero;
        ExitDoor exitDoor = gameElementsContainer.exitDoor;
        this.tunnelMapElementRetriever = new TunnelMapElementRetriever();
        MapBuilder mapBuilder = new MapBuilder();

        String[][] stringTab = mapBuilder.convertListToStringTab(gameMap.map);
        mapWidth = mapBuilder.mapWidth;
        mapHeight = mapBuilder.mapHeight;

        if(tunnelElementToUpdate == TunnelElement.HERO) restorePreviousElement(stringTab, hero);
        else restorePreviousElement(stringTab, exitDoor);

        putElementInMap(exitDoor, stringTab);
        stringTab = putElementInMap(hero, stringTab);
        gameMap.map = convertMapCharTabToList(stringTab);
    }

    private List<String> convertMapCharTabToList(String[][] gameMapString){
        return Arrays.stream(gameMapString)
                .map(element -> Arrays.stream(element).collect(Collectors.joining(DELIMITER)))
                .toList();
    }

    private void restorePreviousElement(String[][] gameMapChar, BaseElement baseElement){
        secureMapIntegration(baseElement.previousCordX, baseElement.previousCordY);
        if(baseElement.previousValueRegistered){
            gameMapChar[baseElement.previousCordY][baseElement.previousCordX] = baseElement.previousValue;
        }
    }
    private String[][] putElementInMap(BaseElement baseElement, String[][] gameMapChar){
        secureMapIntegration(baseElement.cordX, baseElement.cordY);
        baseElement.previousCordX = baseElement.cordX;
        baseElement.previousCordY = baseElement.cordY;
        baseElement.previousValue = gameMapChar[baseElement.cordY][baseElement.cordX];
        baseElement.previousValueRegistered = true;
        String elementValue;
        if(baseElement instanceof Hero){
             elementValue = getTunnelElementMapValue(TunnelElement.HERO);
        }else{
            elementValue = getTunnelElementMapValue(TunnelElement.EXIT);
        }
        gameMapChar[baseElement.cordY][baseElement.cordX] = elementValue;
        return gameMapChar;
    }

    private String getTunnelElementMapValue(TunnelElement tunnelElement){
        return tunnelMapElementRetriever.getByTunnelElementValue(tunnelElement);
    }

    private void secureMapIntegration(int cordX, int cordY){
        if(cordX > mapWidth) throw new ElementOutOfMapWidth(cordX, mapWidth);
        if((cordY + 1) > mapHeight) throw new ElementOutOfMapHeight(cordY, mapHeight);
    }
}
