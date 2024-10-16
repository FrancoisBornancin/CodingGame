package org.thefall.episode1.gameinit.gamelauncher;

import org.thefall.episode1.gameinit.staticdata.InitializedData;
import org.thefall.episode1.gameinit.staticdata.StaticGameInitializedData;
import org.thefall.episode1.gameplay.elements.exit.ExitDoor;
import org.thefall.episode1.gameplay.elements.tunnel.TunnelMapElementRetriever;
import org.thefall.episode1.gameplay.nextblock.Coordinates;
import org.thefall.episode1.gameplay.nextblock.GameDirection;
import org.thefall.episode1.gameplay.map.MapBuilder;
import org.thefall.episode1.gameplay.nextblock.info.NextBlockInfo;
import org.thefall.episode1.gameplay.nextblock.info.NextBlockInfoCalculator;
import org.thefall.episode1.gameplay.nextblock.builder.NextBlockMapBuilder;
import org.thefall.episode1.gameplay.nextblock.nextdirection.NextDirectionCalculator;
import org.thefall.episode1.logging.BaseDataLogger;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ProdGameLauncher implements GameLauncher {
    private NextBlockInfoCalculator nextBlockInfoCalculator;
    private NextDirectionCalculator nextDirectionCalculator;
    private NextBlockInfo nextBlockInfo;

    @Override
    public void launchGame(InitializedData initializedData, BaseDataLogger baseDataLogger) {
        Scanner scanner = initializedData.scannerRemainingDatas;
        StaticGameInitializedData staticGameInitializedData = initializedData.staticGameInitializedData;
        MapBuilder mapBuilder = new MapBuilder();
        nextDirectionCalculator = new NextDirectionCalculator();
        TunnelMapElementRetriever tunnelMapElementRetriever = new TunnelMapElementRetriever();
        NextBlockMapBuilder nextBlockMapBuilder = new NextBlockMapBuilder(tunnelMapElementRetriever);
        nextBlockInfoCalculator = new NextBlockInfoCalculator(tunnelMapElementRetriever, nextBlockMapBuilder);
        String[][] mapTab = mapBuilder.convertListToStringTab(staticGameInitializedData.tunnelLinesList);
        nextBlockInfo = new NextBlockInfo();
        ExitDoor exitDoor =
                new ExitDoor(
                        staticGameInitializedData.exitDoorXCord,
                        mapBuilder.mapHeight - 1
                );

        nextBlockInfo.isANonBlockingBlock = false;
        nextBlockInfo.isAFunnelCase = false;

        Coordinates heroCoordinates = new Coordinates(0, 0, "");

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

//            baseDataLogger.logDynamicTurnsNumber(countTurn);
//            baseDataLogger.logDynamicDatas(initializedData.hero);

            if(!nextBlockInfo.isAFunnelCase || heroCoordinates.nextCoordinates == null){
                printNextCoordinates(mapTab, heroCoordinates, exitDoor, nextBlockInfo);
            }else{
                heroCoordinates.direction = heroCoordinates.nextCoordinates.direction;
                if(heroCoordinates.nextCoordinates.direction == GameDirection.DOWN){
                    System.out.println(heroCoordinates.nextCoordinates.cordX + " " + (heroCoordinates.nextCoordinates.cordY + 1));
                }else if(heroCoordinates.nextCoordinates.direction == GameDirection.LEFT){
                    System.out.println((heroCoordinates.nextCoordinates.cordX - 1) + " " + heroCoordinates.nextCoordinates.cordY);
                }else{
                    System.out.println((heroCoordinates.nextCoordinates.cordX + 1) + " " + heroCoordinates.nextCoordinates.cordY);
                }
                heroCoordinates.nextCoordinates = null;
            }
        }
    }

    private void printNextCoordinates(String[][] mapTab, Coordinates currentCoordinates, ExitDoor exitDoor, NextBlockInfo nextBlockInfo){
        Map<GameDirection, Coordinates> nearestValues = nextDirectionCalculator.getNearestDirections(currentCoordinates, mapTab);
        List<GameDirection> nextDirections = nearestValues.keySet().stream().toList();
        for(int a = 0 ; a < nextDirections.size() ; a++){
            GameDirection nearestDirection = nextDirections.get(a);
            Coordinates nextCoordinate = nearestValues.get(nearestDirection);
            currentCoordinates.direction = nearestDirection;
            if(nextCoordinate.cordX == exitDoor.cordX && nextCoordinate.cordY == exitDoor.cordY) System.out.println(nextCoordinate.cordX + " " + nextCoordinate.cordY);
            else {
                this.nextBlockInfo = nextBlockInfoCalculator.isNextBlockNonBlocking(mapTab, currentCoordinates, nextCoordinate, nextBlockInfo);
                if(nextBlockInfo.isANonBlockingBlock){
                    System.out.println(nextCoordinate.cordX + " " + nextCoordinate.cordY);
                    return;
                }
            }
        }
    }
}
