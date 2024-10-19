package org.thefall.episode1.gameinit.gamelauncher;

import org.thefall.episode1.gameinit.staticdata.InitializedData;
import org.thefall.episode1.gameplay.Game;
import org.thefall.episode1.gameplay.elements.exit.ExitDoor;
import org.thefall.episode1.gameplay.nextblock.Coordinates;

public class TestGameLauncher implements GameLauncher {
    @Override
    public void launchGame(InitializedData initializedData) {
        Game game = new Game();
        GameServices gameServices = new GameServiceInitializer().init(initializedData);
        Coordinates heroCoordinates = gameServices.heroCoordinates;
        ExitDoor exitDoor = gameServices.exitDoor;

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
