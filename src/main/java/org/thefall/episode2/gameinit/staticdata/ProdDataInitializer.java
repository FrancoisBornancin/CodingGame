package org.thefall.episode2.gameinit.staticdata;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProdDataInitializer implements DataInitializer {
    @Override
    public InitializedData initData() {
        Scanner scanner = new Scanner(System.in);
        int mapWidth = scanner.nextInt(); // number of columns.
        int mapHeight = scanner.nextInt(); // number of rows.

        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        List<String> tunnelLinesList = new ArrayList<>();

        for (int i = 0; i < mapHeight; i++) {
            String LINE = scanner.nextLine(); // represents a line in the grid and contains W integers. Each integer represents one room of a given type.
            tunnelLinesList.add(LINE);
        }
        int exitDoorXCord = scanner.nextInt(); // the coordinate along the X axis of the exit (not useful for this first mission, but must be read).

        InitializedData initializedData = new InitializedData();
        initializedData.scannerRemainingDatas = scanner;
        initializedData.staticGameInitializedData =
                new StaticGameInitializedData(tunnelLinesList, mapWidth, mapHeight, exitDoorXCord);

        tunnelLinesList.forEach(line -> System.err.println(line));

        return initializedData;
    }
}
