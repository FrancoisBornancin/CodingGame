package org.thefall.episode2.gameinit.gamelauncher;

import org.thefall.episode2.gameinit.staticdata.InitializedData;
import org.thefall.episode2.gameplay.Game;
import org.thefall.episode2.gameplay.elements.exit.ExitDoor;
import org.thefall.episode2.gameplay.nextblock.Coordinates;
import org.thefall.episode2.gameplay.rocks.RockBlocker;

import java.util.ArrayList;

public class TestGameLauncher implements GameLauncher {
    @Override
    public void launchGame(InitializedData initializedData) {
        Game game = new Game();
        GameServices gameServices = new GameServiceInitializer().init(initializedData);
        Coordinates heroCoordinates = gameServices.heroCoordinates;
        ExitDoor exitDoor = gameServices.exitDoor;
        gameServices.rockBlocker = new RockBlocker(gameServices.funnelCoordinatesListUpdater, gameServices.mapTab);
        gameServices.rockList = new ArrayList<>();

        while (heroNotOnExitDoor(heroCoordinates, exitDoor)){
            game.play(gameServices);
        }
    }

    private boolean heroNotOnExitDoor(Coordinates heroCoordinates, ExitDoor exitDoor){
        return !heroOnExitDoor(heroCoordinates, exitDoor);
    }

    private boolean heroOnExitDoor(Coordinates heroCoordinates, ExitDoor exitDoor){
        return heroCoordinates.cordX == exitDoor.cordX && heroCoordinates.cordY == exitDoor.cordY;
    }
}
