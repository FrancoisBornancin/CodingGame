package org.blunder.episode1.golfcode;

import java.util.List;

public class Blunder {
    int coordinateX;
    int coordinateY;

    List<Direction> bunderPath;

    int beers;

    public void drinkBeer(){
        if(beers == 1) beers = 0;
        else beers++;
    }
}
