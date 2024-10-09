package org.dwarfongiantshoulders.golfcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String args[]) {
        Game game = new Game();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of relationships of influence

        System.err.println("number of relationships: " + n);

        List<Node> relationShipList = new ArrayList<>();

        for (int a = 0; a < n; a++) {
            int x = in.nextInt(); // a relationship of influence between two people (x influences y)
            int y = in.nextInt();

            relationShipList.add(new Node(x, y));

            System.err.println("n°:" + (a + 1) + "  " + x + " -> " + y);
        }

        System.err.println("relationShipList: " + relationShipList);

        System.out.println(game.play(relationShipList));
    }
}
