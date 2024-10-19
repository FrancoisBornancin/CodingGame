package org.thefall.episode2.gameinit.gamelauncher;

import org.thefall.episode2.gameinit.staticdata.InitializedData;
import org.thefall.episode2.gameplay.Game;
import org.thefall.episode2.gameplay.nextblock.Coordinates;
import org.thefall.episode2.gameplay.nextblock.GameDirection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProdGameLauncher implements GameLauncher {


    @Override
    public void launchGame(InitializedData initializedData) {
        Game game = new Game();
        Scanner scanner = initializedData.scannerRemainingDatas;
        GameServices gameServices = new GameServiceInitializer().init(initializedData);
        Coordinates heroCoordinates = gameServices.heroCoordinates;
        String[][] mapTab = gameServices.mapTab;

        gameServices.countTurn = 0;
        while (true) {
            gameServices.countTurn++;

            int XI = scanner.nextInt();
            int YI = scanner.nextInt();
            String POS = scanner.next();

            List<Coordinates> rockList = new ArrayList<>();
            int R = scanner.nextInt(); // the number of rocks currently in the grid.
            for (int i = 0; i < R; i++) {
                int XR = scanner.nextInt();
                int YR = scanner.nextInt();

                Coordinates coordinates = new Coordinates(XR, YR);


                String POSR = scanner.next();

                System.err.println("rock n°: " + (i + 1) + ": ");
                System.err.println("rock.cordX: " + XR);
                System.err.println("rock.cordY: " + YR);
                System.err.println("rock.POSR: " + POSR);

                initDirection(coordinates, POSR);

                System.err.println("rock.direction: " + coordinates.direction);

                coordinates.value = mapTab[coordinates.cordY][coordinates.cordX];
                System.err.println("rock.value: " + coordinates.value);

                rockList.add(coordinates);
            }

            gameServices.rockList = rockList;

            heroCoordinates.cordX = XI;
            heroCoordinates.cordY = YI;
            heroCoordinates.value = mapTab[heroCoordinates.cordY][heroCoordinates.cordX];

            if(gameServices.countTurn == 1){
                initDirection(heroCoordinates, POS);
            }

            System.err.println("hero.cordX: " + heroCoordinates.cordX);
            System.err.println("hero.cordY: " + heroCoordinates.cordY);
            System.err.println("hero.direction: " + heroCoordinates.direction);

            game.play(gameServices);
        }
    }

    private void initDirection(Coordinates coordinates, String entrancePosition){
        if(entrancePosition.equals(String.valueOf(GameDirection.RIGHT))) coordinates.direction = GameDirection.LEFT;
        else if(entrancePosition.equals(String.valueOf(GameDirection.LEFT))) coordinates.direction = GameDirection.RIGHT;
        else coordinates.direction = GameDirection.DOWN;
    }
}
