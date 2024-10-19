package org.thefall.episode1.gameinit.gamelauncher;

import org.thefall.episode1.gameinit.staticdata.InitializedData;
import org.thefall.episode1.gameinit.staticdata.StaticGameInitializedData;
import org.thefall.episode1.gameplay.elements.exit.ExitDoor;
import org.thefall.episode1.gameplay.map.MapBuilder;
import org.thefall.episode1.gameplay.nextblock.Coordinates;

public class GameServiceInitializer {
    public GameServices init(InitializedData initializedData){
        GameServices gameServices = new GameServices();
        StaticGameInitializedData staticGameInitializedData = initializedData.staticGameInitializedData;
        MapBuilder mapBuilder = new MapBuilder();
        gameServices.mapTab = mapBuilder.convertListToStringTab(staticGameInitializedData.tunnelLinesList);
        gameServices.heroCoordinates = initializedData.heroCoordinates;
        if(initializedData.heroCoordinates != null){
            gameServices.heroCoordinates.value = gameServices.mapTab[initializedData.heroCoordinates.cordY][initializedData.heroCoordinates.cordX];
        }else gameServices.heroCoordinates = new Coordinates(0, 0, "");
        gameServices.exitDoor =
                new ExitDoor(
                        staticGameInitializedData.exitDoorXCord,
                        mapBuilder.mapHeight - 1
                );

        return gameServices;
    }
}
