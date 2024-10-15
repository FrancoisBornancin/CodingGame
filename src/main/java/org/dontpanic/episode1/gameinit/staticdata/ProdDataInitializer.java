package org.dontpanic.episode1.gameinit.staticdata;

import org.dontpanic.episode1.logging.BaseDataLogger;
import org.dontpanic.episode1.logging.ProdDataLogger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ProdDataInitializer implements DataInitializer{
    @Override
    public InitializedData initData(BaseDataLogger baseDataLogger) {
        Scanner scanner = new Scanner(System.in);
        int nbFloors = scanner.nextInt(); // number of floors
        int width = scanner.nextInt(); // width of the area
        int nbRounds = scanner.nextInt(); // maximum number of rounds
        int exitFloor = scanner.nextInt(); // floor on which the exit is found
        int exitPos = scanner.nextInt(); // position of the exit on its floor
        int nbTotalClones = scanner.nextInt(); // number of generated clones
        int nbAdditionalElevators = scanner.nextInt(); // ignore (always zero)
        int nbElevators = scanner.nextInt(); // number of elevators

        Map<Integer, List<Integer>> elevatorsMap = new HashMap<>();

        for (int i = 0; i < nbElevators; i++) {
            int elevatorFloor = scanner.nextInt(); // floor on which this elevator is found
            int elevatorPos = scanner.nextInt(); // position of the elevator on its floor

            List<Integer> elevatorPosList = elevatorsMap.get(elevatorFloor);
            if(elevatorPosList == null) {
                elevatorPosList = new ArrayList<>();
            }

            elevatorPosList.add(elevatorPos);
            Collections.sort(elevatorPosList);
            elevatorsMap.put(elevatorFloor, elevatorPosList);
        }

        Map<Integer, Integer> exitDoorMap = new HashMap<>();
        exitDoorMap.put(exitFloor, exitPos);

        InitializedData initializedData = new InitializedData();
        initializedData.scannerRemainingDatas = scanner;
        initializedData.staticGameInitializedData =
                new StaticGameInitializedData(
                     nbFloors,
                     width,
                     elevatorsMap,
                    exitDoorMap,
                        nbRounds
                );

        baseDataLogger.logStaticDatas(initializedData.staticGameInitializedData);

        return initializedData;
    }
}
