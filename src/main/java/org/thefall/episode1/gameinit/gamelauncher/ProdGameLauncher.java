package org.thefall.episode1.gameinit.gamelauncher;

import org.thefall.episode1.gameinit.staticdata.InitializedData;
import org.thefall.episode1.gameplay.Game;
import org.thefall.episode1.gameplay.nextblock.Coordinates;
import org.thefall.episode1.gameplay.nextblock.GameDirection;

import java.util.Scanner;

public class ProdGameLauncher implements GameLauncher {


    @Override
    public void launchGame(InitializedData initializedData) {
        Game game = new Game();
        Scanner scanner = initializedData.scannerRemainingDatas;
        GameServices gameServices = new GameServiceInitializer().init(initializedData);
        Coordinates heroCoordinates = gameServices.heroCoordinates;
        String[][] mapTab = gameServices.mapTab;

        int countTurn = 0;
        while (true) {
            countTurn++;

            int XI = scanner.nextInt();
            int YI = scanner.nextInt();
            String POS = scanner.next();

            heroCoordinates.cordX = XI;
            heroCoordinates.cordY = YI;
            heroCoordinates.value = mapTab[heroCoordinates.cordY][heroCoordinates.cordX];

            if(countTurn == 1){
                if(POS.equals(String.valueOf(GameDirection.RIGHT))) heroCoordinates.direction = GameDirection.RIGHT;
                else if(POS.equals(String.valueOf(GameDirection.LEFT))) heroCoordinates.direction = GameDirection.LEFT;
                else heroCoordinates.direction = GameDirection.DOWN;
            }

            game.play(gameServices);
        }
    }
}
