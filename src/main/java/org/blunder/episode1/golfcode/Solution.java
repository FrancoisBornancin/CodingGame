package org.blunder.episode1.golfcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    List<String> rowTab;
    int tabHeight;
    int tabWidth;

    public static void main(String args[]) {
        Solution solution = new Solution();
        Game game = new Game();

        Scanner in = new Scanner(System.in);
        solution.tabHeight = in.nextInt();
        solution.tabWidth = in.nextInt();

        System.err.println("L: " + solution.tabHeight);
        System.err.println("C: " + solution.tabWidth);

        solution.rowTab = new ArrayList<>();

        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < solution.tabHeight; i++) {
            String row = in.nextLine();
            System.err.println("row n°: " + row);
            solution.rowTab.add(row);
        }

        List<String> allDirections = game.play(solution);

        allDirections.forEach(System.out::println);
    }
}