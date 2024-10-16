package org.thefall.episode1.gameinit.staticdata;

import java.util.List;
import java.util.Map;

public class StaticGameInitializedData {
    public List<String> tunnelLinesList;
    public int mapWidth;
    public int mapHeight;
    public int exitDoorXCord;

    public StaticGameInitializedData(List<String> tunnelLinesList, int mapWidth, int mapHeight, int exitDoorXCord) {
        this.tunnelLinesList = tunnelLinesList;
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.exitDoorXCord = exitDoorXCord;
    }

    public StaticGameInitializedData(List<String> tunnelLinesList, int exitDoorXCord) {
        this.tunnelLinesList = tunnelLinesList;
        this.mapWidth = tunnelLinesList.get(0).length();
        this.mapHeight = tunnelLinesList.size();
        this.exitDoorXCord = exitDoorXCord;
    }
}
