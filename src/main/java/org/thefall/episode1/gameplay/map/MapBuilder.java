package org.thefall.episode1.gameplay.map;

import java.util.List;

public class MapBuilder {
    private static String DELIMITER = " ";
    public int mapWidth;
    public int mapHeight;
    public String[][] convertListToStringTab(List<String> map){
        String[][] stringTab = initStringTab(map);
        for(int a = 0 ; a < stringTab.length ; a++){
            String[] stringLineTab = map.get(a).split(DELIMITER);
            for(int b = 0 ; b < stringTab[0].length ; b++){
                stringTab[a][b] = stringLineTab[b];
            }
        }
        return stringTab;
    }

    private String[][] initStringTab(List<String> map){
        int mapWidth = map.get(0).split(DELIMITER).length;
        return initStringTab(mapWidth, map.size());
    }

    private String[][] initStringTab(int width, int height){
        this.mapWidth = width;
        this.mapHeight = height;
        return new String[height][width];
    }
}
