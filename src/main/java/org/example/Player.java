package org.example;

import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
public class Player {
    boolean useCodeGymValues;
    int buildingWidth; // width of the building.
    int buildingHeight; // height of the building.
    int N; // maximum number of turns before game over.
    int initialX;
    int initialY;
    Scanner scanner;

    public Player(
            boolean useCodeGymValues,
            int buildingWidth,
            int buildingHeight,
            int N,
            int initialX,
            int initialY,
            Scanner scanner
    ){
        this.useCodeGymValues = useCodeGymValues;
        this.buildingWidth = buildingWidth;
        this.buildingHeight = buildingHeight;
        this.N = N;
        this.initialX = initialX;
        this.initialY = initialY;
        this.scanner = scanner;

        System.err.println("buildingWidth: " + buildingWidth);
        System.err.println("buildingHeight: " + buildingHeight);
        System.err.println("maxTurns: " + N);
        System.err.println("initialX: " + initialX);
        System.err.println("initialY: " + initialY);
    }

    public static void main(String args[]) {
        Game game = new Game();
        Scanner in = new Scanner(System.in);

        Player player = new Player(true, in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in);

        game.play(player);
    }
}
