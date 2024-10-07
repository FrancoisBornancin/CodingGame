package org.thereisnospoon.episode1;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public List<String> play(Player player){
        List<String> elementsToPrint = new ArrayList<>();

        for(int height = 0 ; height < player.height ; height++){
            for(int width = 0 ; width < player.width ; width++){
                if(player.elements.get(height).charAt(width) == '0'){
                    String elementToPrint = (width + " " + height);
                    elementToPrint += " ";
                    if(isLastWidthIndex(width, player) || !nextWidthIsNode(height, width, player)) {
                        elementToPrint += "-1 -1";
                    }
                    if(nextWidthIsNode(height, width, player)) elementToPrint += ((width + 1) + " " + height);

                    elementToPrint += " ";

                    if(isLastHeightIndex(height, player) || !nextHeightIsNode(height, width, player)) {
                        elementToPrint += "-1 -1";
                    }
                    if(nextHeightIsNode(height, width, player)) elementToPrint += (width + " " + (height + 1));

                    elementsToPrint.add(elementToPrint);
                }
            }
        }

        return elementsToPrint;
    }

    private boolean isLastWidthIndex(int width, Player player){
        return width == (player.width - 1);
    }

    private boolean isLastHeightIndex(int height, Player player){
        return height == (player.height - 1);
    }

    private boolean nextWidthIsNode(int height, int width, Player player){
        try{
            return player.elements.get(height).charAt(width + 1) == '0';
        }catch (Exception e){
            return false;
        }
    }

    private boolean nextHeightIsNode(int height, int width, Player player){
        try {
            return player.elements.get(height + 1).charAt(width) == '0';
        }catch (Exception e){
            return false;
        }
    }
}