package org.thefall.episode2.gameplay;

import org.thefall.episode2.gameinit.gamelauncher.GameServices;
import org.thefall.episode2.gameplay.nextblock.Coordinates;
import org.thefall.episode2.gameplay.nextblock.GameDirection;
import org.thefall.episode2.gameplay.nextblock.info.HeroPathCalculator;
import org.thefall.episode2.gameplay.nextblock.info.FunnelCoordinatesContainer;
import org.thefall.episode2.gameplay.rocks.RockBlocker;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Game {
    FunnelCoordinatesContainer funnelCoordinatesContainer;
    HeroPathCalculator heroPathCalculator;
    RockBlocker rockBlocker;
    public void play(GameServices gameServices){
        if(funnelCoordinatesContainer == null) init(gameServices);
        if(funnelCoordinatesContainer.funnelCoordinates == null || funnelCoordinatesContainer.funnelCoordinates.isEmpty()){
            heroPathCalculator.buildPath(gameServices.heroCoordinates);
            if(!funnelCoordinatesContainer.funnelCoordinates.isEmpty()) {
                doGameAction(gameServices);
            }
        }else{
            doGameAction(gameServices);
        }
    }

    private void init(GameServices gameServices){
        heroPathCalculator = gameServices.heroPathCalculator;
        funnelCoordinatesContainer = heroPathCalculator.funnelCoordinatesContainer;
        rockBlocker = gameServices.rockBlocker;
    }

    private void updateCoordinates(Coordinates currentCoordinates, GameResponse gameResponse){
        currentCoordinates.cordX = gameResponse.coordinates.cordX;
        currentCoordinates.cordY = gameResponse.coordinates.cordY;
        currentCoordinates.value = gameResponse.coordinates.value;
    }

    private void printResponse(GameResponse gameResponse){
        String responseToPrint = null;
        if(gameResponse.gameDirection != null) {
            responseToPrint = gameResponse.coordinates.cordX + " " + gameResponse.coordinates.cordY + (" " + gameResponse.gameDirection);
        }else {
            responseToPrint = "WAIT";
        }
        System.out.println(responseToPrint);
    }

    private void doGameAction(GameServices gameServices){
        rockBlocker.blockRock(gameServices.rockList);
        GameResponse gameResponse = funnelCoordinatesContainer.getGameResponse();
        printResponse(gameResponse);
        updateCoordinates(gameServices.heroCoordinates, gameResponse);
    }
}
