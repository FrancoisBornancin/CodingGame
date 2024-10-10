package org.blunder.episode1.golfcode;

import java.util.ArrayList;
import java.util.List;

public class RowTabSimplifier {
    public List<String> simplify(Solution solution){
        return new ArrayList<>(
            solution.rowTab.stream()
                .skip(1)
                .map(row -> row.substring(1, row.length() - 1))
                .limit(solution.tabHeight - 2)
                .toList()
        );
    }
}
