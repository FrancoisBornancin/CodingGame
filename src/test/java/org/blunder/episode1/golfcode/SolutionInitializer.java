package org.blunder.episode1.golfcode;

import java.util.List;

public class SolutionInitializer {
    public Solution initSolution(List<String> rowTab){
        Solution solution = new Solution();
        solution.rowTab = rowTab;
        solution.tabHeight = rowTab.size();
        solution.tabWidth = rowTab.get(0).length();

        return solution;
    }
}
