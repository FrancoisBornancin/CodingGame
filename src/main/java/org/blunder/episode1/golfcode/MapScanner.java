package org.blunder.episode1.golfcode;

import java.util.ArrayList;
import java.util.List;

public class MapScanner {
    int cursor;
    List<String> map;
    List<ElementTeleporter> teleporterElements;
    int nextCordX;
    int nextCordY;

    public void initElements(List<String> rowsTab, Blunder blunder){
        map = rowsTab;

        int width = map.get(0).length();
        int height = map.size();

        boolean hasRowsTabFinishedInitialized = false;

        for(int a = 0 ; a < height ; a++){
            for(int b = 0 ; b < width ; b++){
                if(map.get(a).charAt(b) == ElementsQualifiers.TELEPORTER){
                    addTeleporterElement(b, a);
                }
                if(map.get(a).charAt(b) == ElementsQualifiers.START_ELEMENT){
                    blunder.coordinateX = b;
                    blunder.coordinateY = a;

                    hasRowsTabFinishedInitialized = true;
                }
            }

            if(hasRowsTabFinishedInitialized) {
                cursor = a;
                return;
            }
        }
    }

    public void findRemainingTeleports(){
        if(teleporterElements == null) teleporterElements = new ArrayList<>();
        if(teleporterElements.size() == 2) return;

        int width = map.get(0).length();
        int height = map.size();

        for(int a = (cursor + 1) ; a < height ; a++){
            for(int b = 0 ; b < width ; b++){
                if(map.get(a).charAt(b) == ElementsQualifiers.TELEPORTER){
                    addTeleporterElement(b, a);
                    if(teleporterElements.size() == 2) return;
                }
            }
        }
    }

    private void addTeleporterElement(int cordX, int cordY){
        ElementTeleporter teleporterElement = new ElementTeleporter(cordX, cordY);

        if(teleporterElements == null) teleporterElements = new ArrayList<>();

        teleporterElements.add(teleporterElement);
    }
}
