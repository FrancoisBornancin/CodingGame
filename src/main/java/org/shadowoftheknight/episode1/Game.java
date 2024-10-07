package org.shadowoftheknight.episode1;

import java.util.Scanner;

public class Game {
    public static String DOWN = "D";
    public static String UP = "U";
    public static String LEFT = "L";
    public static String RIGHT = "R";
    public int actualX;
    public int actualY;
    public int beforeOneX;
    public int beforeOneY;
    public int maxWidth;
    public int maxHeight;

    public int minWidth;
    public int minHeight;
    public String actualBombdir;
    public String beforeBombdir;
    public int bombX;
    public int bombY;

    public String play(Player player){
        initValues(player);

        int countTurn = 0;

        // game loop
        while (this.possiblyContinueLoop(this.bombX, this.bombY, player.useCodeGymValues)) {
            countTurn ++;
            if(countTurn > player.N){
                return "YOU LOST";
            }else {
                if(this.actualBombdir == null) this.beforeBombdir = "";
                else this.beforeBombdir = this.actualBombdir;

                String bombDir = this.updateBombDir(player.scanner, player.useCodeGymValues);
                this.actualBombdir = bombDir;

                System.err.println("");

                if(this.actualBombdir.contains(DOWN)){
                    if(this.beforeBombdir.contains(UP)){
                        this.maxHeight = this.beforeOneY;
                        this.minHeight = this.actualY;
                    }
                    if(this.actualY == this.beforeOneY) {
                        this.updateValuesDuringEachTurn();
                        this.actualY = this.actualY + 1;
                    }
                    else {
                        this.updateValuesDuringEachTurn();
                        this.actualY = (int) Math.floor(this.actualY + (this.maxHeight - this.actualY)/2);
                    }
                }

                if(this.actualBombdir.contains(UP)){
                    if(this.beforeBombdir.contains(DOWN)) {
                        this.maxHeight = this.actualY;
                        this.minHeight = this.beforeOneY;
                    }
                    this.updateValuesDuringEachTurn();
                    this.actualY = (int) Math.floor(this.actualY - (this.actualY - this.minHeight)/2);
                }

                if(this.actualBombdir.contains(LEFT)){
                    if(this.beforeBombdir.contains(RIGHT)){
                        this.minWidth = this.beforeOneX;
                        this.maxWidth = this.actualX;
                    }
                    this.updateValuesDuringEachTurn();
                    this.actualX = (int) Math.floor(this.actualY - (this.actualX - this.minWidth)/2);
                }

                if(this.actualBombdir.contains(RIGHT)){
                    if(this.beforeBombdir.contains(LEFT)){
                        this.maxWidth = this.beforeOneX;
                        this.minWidth = this.actualX;
                    }
                    this.updateValuesDuringEachTurn();
                    this.actualX = (int) Math.floor(this.actualX + (this.maxWidth - this.actualX)/2);
                }

                System.err.println("");

                System.err.println("bombDir: " + this.actualBombdir);
                System.err.println("bombDirX: " + this.bombX + " bombDirY: " + this.bombY);
                System.err.println("player.actualX: " + this.actualX + " player.actualY: " + this.actualY);
                System.out.println(("" + this.actualX) + " " + ("" + this.actualY));

                updateValuesAfterEachTurn();
            }
        }
        return "YOU WIN";
    }

    private void updateValuesAfterEachTurn(){
        this.beforeBombdir = this.actualBombdir;
    }

    private void updateValuesDuringEachTurn(){
        this.beforeOneY = this.actualY;
        this.beforeOneX = this.actualX;
    }

    private void initValues(Player player){
        this.minHeight = 0;
        this.minWidth = 0;

        this.maxHeight = player.buildingHeight;
        this.maxWidth = player.buildingWidth;

        this.actualX = player.initialX;
        this.actualY = player.initialY;

        if(player.useCodeGymValues){
            this.bombX = 0;
            this.bombY = 0;
        }
    }

    private boolean possiblyContinueLoop(int bombX, int bombY, boolean useCodeGymValue){
        if(useCodeGymValue) return useCodeGymValue;
        else return !((this.actualX == bombX) && (this.actualY == bombY));
    }

    private String updateBombDir(Scanner input, boolean useCodeGymValue){
        if(useCodeGymValue) return input.next();
        else {
            String bombDir = "";
            if(bombY > actualY) bombDir += "D";
            if(bombY == actualY) bombDir += "";
            if(bombY < actualY) bombDir += "U";

            if(bombX > actualX) bombDir += "R";
            if(bombX == actualX) bombDir += "";
            if(bombX < actualX) bombDir += "L";

            return bombDir;
        }
    }
}