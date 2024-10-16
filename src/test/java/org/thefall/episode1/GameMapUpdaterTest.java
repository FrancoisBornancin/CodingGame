package org.thefall.episode1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.thefall.episode1.gameplay.elements.exit.ExitDoor;
import org.thefall.episode1.gameplay.elements.hero.Hero;
import org.thefall.episode1.gameplay.elements.support.GameElementsContainer;
import org.thefall.episode1.gameplay.elements.tunnel.TunnelElement;
import org.thefall.episode1.logging.errors.ElementOutOfMapHeight;
import org.thefall.episode1.logging.errors.ElementOutOfMapWidth;
import org.thefall.episode1.logging.map.GameMap;
import org.thefall.episode1.logging.map.GameMapUpdater;

import java.util.List;

public class GameMapUpdaterTest {
    @Test
    void itShouldPrintMapWithHeroCoordinates_case1(){
        Hero hero = new Hero(0, 0);
        ExitDoor exitDoor = new ExitDoor(2, 0);
        GameMap gameMap = new GameMap();
        GameElementsContainer gameElementsContainer = new GameElementsContainer();
        gameElementsContainer.exitDoor = exitDoor;
        gameElementsContainer.hero = hero;
        gameElementsContainer.gameMap = gameMap;
        GameMapUpdater gameMapUpdater = new GameMapUpdater();

        gameMap.map = List.of("0 0 0");

        gameMapUpdater.updateGameMap(gameElementsContainer, TunnelElement.HERO);

        List<String> expectedMap = List.of("H 0 E");
        for(int a = 0 ; a < expectedMap.size() ; a++){
            Assertions.assertEquals(expectedMap.get(a), gameMap.map.get(a));
        }
    }

    @Test
    void itShouldUpdateMapWhenHeroCoordinatesChanges(){
        Hero hero = new Hero(0, 0);
        ExitDoor exitDoor = new ExitDoor(2, 0);
        GameMap gameMap = new GameMap();
        GameElementsContainer gameElementsContainer = new GameElementsContainer();
        gameElementsContainer.exitDoor = exitDoor;
        gameElementsContainer.hero = hero;
        gameElementsContainer.gameMap = gameMap;
        GameMapUpdater gameMapUpdater = new GameMapUpdater();

        gameMap.map = List.of("0 0 0");

        gameMapUpdater.updateGameMap(gameElementsContainer, TunnelElement.HERO);

        List<String> firstExpectedMap = List.of("H 0 E");
        for(int a = 0 ; a < firstExpectedMap.size() ; a++){
            Assertions.assertEquals(firstExpectedMap.get(0), gameMap.map.get(0));
        }

        hero.cordX = 2;
        gameMapUpdater.updateGameMap(gameElementsContainer, TunnelElement.HERO);

        List<String> secondExpectedMap = List.of("0 0 H");
        for(int a = 0 ; a < secondExpectedMap.size() ; a++){
            Assertions.assertEquals(secondExpectedMap.get(0), gameMap.map.get(0));
        }
    }

    @Test
    void itShouldUpdateMapWhenExitDoorCoordinatesChanges(){
        Hero hero = new Hero(0, 0);
        ExitDoor exitDoor = new ExitDoor(2, 0);
        GameMap gameMap = new GameMap();
        GameElementsContainer gameElementsContainer = new GameElementsContainer();
        gameElementsContainer.exitDoor = exitDoor;
        gameElementsContainer.hero = hero;
        gameElementsContainer.gameMap = gameMap;
        GameMapUpdater gameMapUpdater = new GameMapUpdater();

        gameMap.map = List.of("0 0 0");

        gameMapUpdater.updateGameMap(gameElementsContainer, TunnelElement.EXIT);

        List<String> firstExpectedMap = List.of("H 0 E");
        for(int a = 0 ; a < firstExpectedMap.size() ; a++){
            Assertions.assertEquals(firstExpectedMap.get(0), gameMap.map.get(0));
        }

        exitDoor.cordX = 1;
        gameMapUpdater.updateGameMap(gameElementsContainer, TunnelElement.EXIT);

        List<String> secondExpectedMap = List.of("H E 0");
        for(int a = 0 ; a < secondExpectedMap.size() ; a++){
            Assertions.assertEquals(secondExpectedMap.get(0), gameMap.map.get(0));
        }
    }

    @Test
    void itShouldAddExitDoorToMap(){
        Hero hero = new Hero(0, 0);
        ExitDoor exitDoor = new ExitDoor(2, 1);
        GameMap gameMap = new GameMap();
        GameElementsContainer gameElementsContainer = new GameElementsContainer();
        gameElementsContainer.exitDoor = exitDoor;
        gameElementsContainer.hero = hero;
        gameElementsContainer.gameMap = gameMap;
        GameMapUpdater gameMapUpdater = new GameMapUpdater();

        gameMap.map = List.of(
                "0 0 0",
                "0 0 0"
        );

        gameMapUpdater.updateGameMap(gameElementsContainer, TunnelElement.HERO);

        List<String> firstExpectedMap = List.of(
                "H 0 0",
                "0 0 E"
        );
        for(int a = 0 ; a < firstExpectedMap.size() ; a++){
            Assertions.assertEquals(firstExpectedMap.get(0), gameMap.map.get(0));
        }
    }

    @Test
    void itShouldPrintIfElementCordXIsOutOfBondsRight(){
        Hero hero = new Hero(4, 0);
        ExitDoor exitDoor = new ExitDoor(2, 0);
        GameMap gameMap = new GameMap();
        GameElementsContainer gameElementsContainer = new GameElementsContainer();
        gameElementsContainer.exitDoor = exitDoor;
        gameElementsContainer.hero = hero;
        gameElementsContainer.gameMap = gameMap;
        GameMapUpdater gameMapUpdater = new GameMapUpdater();

        gameMap.map = List.of("0 0 0");

        Assertions.assertThrows(
                ElementOutOfMapWidth.class,
                () -> gameMapUpdater.updateGameMap(gameElementsContainer, TunnelElement.HERO)
        );
    }

    @Test
    void itShouldPrintIfElementCordYIsOutOfBondsDown(){
        Hero hero = new Hero(0, 1);
        ExitDoor exitDoor = new ExitDoor(2, 0);
        GameMap gameMap = new GameMap();
        GameElementsContainer gameElementsContainer = new GameElementsContainer();
        gameElementsContainer.exitDoor = exitDoor;
        gameElementsContainer.hero = hero;
        gameElementsContainer.gameMap = gameMap;
        GameMapUpdater gameMapUpdater = new GameMapUpdater();

        gameMap.map = List.of("0 0 0");

        Assertions.assertThrows(
                ElementOutOfMapHeight.class,
                () -> gameMapUpdater.updateGameMap(gameElementsContainer, TunnelElement.HERO)
        );
    }
}
