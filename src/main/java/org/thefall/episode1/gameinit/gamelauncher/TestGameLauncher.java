package org.thefall.episode1.gameinit.gamelauncher;

import org.thefall.episode1.gameinit.staticdata.InitializedData;
import org.thefall.episode1.gameplay.Game;
import org.thefall.episode1.gameplay.elements.exit.ExitDoor;
import org.thefall.episode1.gameplay.elements.hero.Hero;
import org.thefall.episode1.logging.BaseDataLogger;

public class TestGameLauncher implements GameLauncher {
    @Override
    public void launchGame(InitializedData initializedData, BaseDataLogger baseDataLogger) {
        Game game = new Game();

        baseDataLogger.logStaticDatas(initializedData.staticGameInitializedData);

        Hero hero = initializedData.hero;
        ExitDoor exitDoor = initializedData.exitDoor;

        int countTurn = 0;
        while (heroNotOnExitDoor(hero, exitDoor)){

            countTurn++;
            baseDataLogger.logDynamicTurnsNumber(countTurn);
            baseDataLogger.logDynamicDatas(initializedData.hero);

            game.play();
        }
    }

    private boolean heroNotOnExitDoor(Hero hero, ExitDoor exitDoor){
        return !heroOnExitDoor(hero, exitDoor);
    }

    private boolean heroOnExitDoor(Hero hero, ExitDoor exitDoor){
        return hero.cordX == exitDoor.cordX && hero.cordY == exitDoor.cordY;
    }
}
