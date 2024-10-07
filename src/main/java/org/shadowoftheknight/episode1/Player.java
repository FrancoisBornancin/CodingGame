package org.shadowoftheknight.episode1;

import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
public class Player {
    boolean useCodeGymValues;
    int N;
    Scanner scanner;

    public Player(
            boolean useCodeGymValues,
            int N,
            Scanner scanner
    ){
        this.useCodeGymValues = useCodeGymValues;
        this.N = N;
        this.scanner = scanner;

        System.err.println("maxTurns: " + N);
    }

    public static void main(String args[]) {
        Game game = new Game();
        Scanner in = new Scanner(System.in);

        int buildingWidth = in.nextInt();
        int buildingHeight = in.nextInt();
        int N = in.nextInt();
        int batmanInitialX = in.nextInt();
        int batmanInitialY = in.nextInt();

        game.play(
                new Player(true, N, in),
                new Bomb(),
                new Batman(batmanInitialX, batmanInitialY),
                new Building(buildingWidth, buildingHeight)
        );
    }
}
