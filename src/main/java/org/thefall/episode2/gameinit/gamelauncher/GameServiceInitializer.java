package org.thefall.episode2.gameinit.gamelauncher;

import org.thefall.episode2.gameinit.staticdata.InitializedData;
import org.thefall.episode2.gameinit.staticdata.StaticGameInitializedData;
import org.thefall.episode2.gameplay.elements.exit.ExitDoor;
import org.thefall.episode2.gameplay.map.MapBuilder;
import org.thefall.episode2.gameplay.nextblock.Coordinates;
import org.thefall.episode2.gameplay.nextblock.FunnelCoordinatesListUpdater;
import org.thefall.episode2.gameplay.nextblock.builder.TurnBlockMapBuilder;
import org.thefall.episode2.gameplay.nextblock.info.HeroPathCalculator;
import org.thefall.episode2.gameplay.nextblock.info.FunnelCoordinatesContainer;

public class GameServiceInitializer {
    public GameServices init(InitializedData initializedData){
        StaticGameInitializedData staticGameInitializedData = initializedData.staticGameInitializedData;
        MapBuilder mapBuilder = new MapBuilder();
        String[][] mapTab = mapBuilder.convertListToStringTab(staticGameInitializedData.tunnelLinesList);
        ExitDoor exitDoor =
                new ExitDoor(
                        staticGameInitializedData.exitDoorXCord,
                        mapBuilder.mapHeight - 1
                );
        FunnelCoordinatesContainer funnelCoordinatesContainer = new FunnelCoordinatesContainer();
        GameServices gameServices = new GameServices(funnelCoordinatesContainer, mapTab, exitDoor);
        gameServices.heroCoordinates = initializedData.heroCoordinates;
        if(initializedData.heroCoordinates != null){
            gameServices.heroCoordinates.value = mapTab[initializedData.heroCoordinates.cordY][initializedData.heroCoordinates.cordX];
        }else gameServices.heroCoordinates = new Coordinates(0, 0, "");
        return gameServices;
    }
}
