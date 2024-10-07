package org.shadowoftheknight.episode1;

import java.util.Scanner;

public class Bomb {
    public String dir;
    public int coordinateX;
    public int coordinateY;

    public Bomb(){};

    public Bomb(int coordinateX, int coordinateY){
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public String updateDirection(Scanner input, boolean useCodeGymValue, Game game){
        if(useCodeGymValue) return input.next();
        else {
            String bombDir = "";
            if(this.coordinateY > game.actualY) bombDir += "D";
            if(this.coordinateY == game.actualY) bombDir += "";
            if(this.coordinateY < game.actualY) bombDir += "U";

            if(this.coordinateX > game.actualX) bombDir += "R";
            if(this.coordinateX == game.actualX) bombDir += "";
            if(this.coordinateX < game.actualX) bombDir += "L";

            return bombDir;
        }
    }
}
