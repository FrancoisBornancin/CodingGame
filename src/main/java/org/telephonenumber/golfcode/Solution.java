package org.telephonenumber.golfcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    List<String> telephonNumberList;

    public static void main(String args[]) {
        Solution solution = new Solution();
        solution.telephonNumberList = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        System.err.println("N: " + N);
        for (int i = 0; i < N; i++) {
            String telephone = in.next();
            solution.telephonNumberList.add(telephone);
        }

        System.err.println("telephoneList: " + solution.telephonNumberList);

        Game game = new Game();
        System.out.println(game.play(solution));
    }
}
