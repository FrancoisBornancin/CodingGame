package org.thefall.episode1.gameplay;

import org.thefall.episode1.gameinit.gamelauncher.GameServices;
import org.thefall.episode1.gameplay.elements.exit.ExitDoor;
import org.thefall.episode1.gameplay.nextblock.info.NextBlockInfo;
import org.thefall.episode1.gameplay.nextblock.info.NextBlockInfoCalculator;

public class Game {
    NextBlockInfo nextBlockInfo;
    NextBlockInfoCalculator nextBlockInfoCalculator;
    ExitDoor exitDoor;
    String[][] mapTab;
    public void play(GameServices gameServices){
        if(nextBlockInfo == null) init(gameServices);
        if(nextBlockInfo.funnelCoordinates == null || nextBlockInfo.funnelCoordinates.isEmpty()){
            nextBlockInfoCalculator.isNextBlockNonBlocking(gameServices.heroCoordinates, nextBlockInfo, exitDoor, mapTab);
            if(!nextBlockInfo.funnelCoordinates.isEmpty()) nextBlockInfo.printFirst(gameServices.heroCoordinates);
        }else{
            nextBlockInfo.printFirst(gameServices.heroCoordinates);
        }
    }

    private void init(GameServices gameServices){
        nextBlockInfo = gameServices.nextBlockInfo;
        nextBlockInfoCalculator = gameServices.nextBlockInfoCalculator;
        exitDoor = gameServices.exitDoor;
        mapTab = gameServices.mapTab;
    }
}
