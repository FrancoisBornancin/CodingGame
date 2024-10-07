package org.shadowoftheknight.episode1;

import java.util.Scanner;

public class Bomb {
    public static String DOWN = "D";
    public static String UP = "U";
    public static String LEFT = "L";
    public static String RIGHT = "R";
    public String actualDir;
    public String beforeDir;
    public int coordinateX;
    public int coordinateY;

    public Bomb(){};

    public Bomb(int coordinateX, int coordinateY){
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public void updateBeforeDirection(){
        if(this.actualDir == null) this.beforeDir = "";
        else this.beforeDir = this.actualDir;
    }

    public void updateActualDirection(Player player, Batman batman){
        String bombDir = this.updateDirection(player.scanner, player.useCodeGymValues, batman);
        this.actualDir = bombDir;
    }

    public void updateBeforeDirectionAfterEachTurn(){
        this.beforeDir = this.actualDir;
    }

    private String updateDirection(Scanner input, boolean useCodeGymValue, Batman batman){
        if(useCodeGymValue) return input.next();
        else {
            String bombDir = "";
            if(this.coordinateY > batman.actualY) bombDir += "D";
            if(this.coordinateY == batman.actualY) bombDir += "";
            if(this.coordinateY < batman.actualY) bombDir += "U";

            if(this.coordinateX > batman.actualX) bombDir += "R";
            if(this.coordinateX == batman.actualX) bombDir += "";
            if(this.coordinateX < batman.actualX) bombDir += "L";

            return bombDir;
        }
    }
}
