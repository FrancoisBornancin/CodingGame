package org.dontpanic.episode1.gameinit.gamelauncher;

import org.dontpanic.episode1.gameplay.GameAction;
import org.dontpanic.episode1.gameplay.GameServices;
import org.dontpanic.episode1.gameplay.Game;
import org.dontpanic.episode1.gameinit.staticdata.InitializedData;
import org.dontpanic.episode1.logging.ProdDataLogger;
import org.dontpanic.episode1.utils.Environment;

public class ProdGameLauncher implements GameLauncher {
    @Override
    public void launchGame(InitializedData initializedData) {
        GameServices gameServices = new GameServices(initializedData, Environment.PROD);
        Game game = new Game();

        while (true) {
            gameServices.countTurn++;
            gameServices.currentGameAction.gameAction = GameAction.WAIT;

            int cloneFloor = initializedData.scannerRemainingDatas.nextInt(); // floor of the leading clone
            int clonePos = initializedData.scannerRemainingDatas.nextInt(); // position of the leading clone on its floor
            String direction = initializedData.scannerRemainingDatas.next(); // direction of the leading clone: LEFT or RIGHT

            game.play(gameServices, direction, cloneFloor, clonePos);
        }
    }
}
