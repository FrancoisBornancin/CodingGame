package org.thereisnospoon.episode1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
public class Player {
    List<String> elements;
    int width;
    int height;

    public Player(){}

    public static void main(String args[]) {
        Game game = new Game();
        Scanner in = new Scanner(System.in);

        int width = in.nextInt(); // the number of cells on the X axis
        int height = in.nextInt(); // the number of cells on the Y axis
        System.err.println("width: " + width);
        System.err.println("height: " + height);

        if (in.hasNextLine()) {
            in.nextLine();
        }

        Player player = new Player();
        player.width = width;
        player.height = height;
        player.elements = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            player.elements.add(in.nextLine());
        }

        game.play(player).forEach(System.out::println);
    }
}
