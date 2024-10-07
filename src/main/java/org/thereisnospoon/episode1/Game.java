package org.thereisnospoon.episode1;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public List<String> play(Player player){
        List<String> elementsToPrint = new ArrayList<>();
        LineScanner lineScanner = new LineScanner();
        ColumnScanner columnScanner = new ColumnScanner();

        for(int height = 0 ; height < player.height ; height++){
            for(int width = 0 ; width < player.width ; width++){
                if(isNode(height, width, player)){
                    String elementToPrint = (width + " " + height);
                    elementToPrint += " ";

                    elementToPrint += lineScanner.getRightNodeAsString(player.elements.get(height), width, height);

                    elementToPrint += " ";

                    elementToPrint += columnScanner.getUnderNodeAsString(player.elements, width, height);

                    elementsToPrint.add(elementToPrint);
                }
            }
        }

        return elementsToPrint;
    }

    private boolean isNode(int height, int width, Player player){
        return player.elements.get(height).charAt(width) == '0';
    }
}