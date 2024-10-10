package org.blunder.episode1.golfcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RowTabSimplifierTest {

    @Test
    void testCase1(){
        RowTabSimplifier rowTabSimplifier = new RowTabSimplifier();
        Solution solution = new SolutionInitializer().initSolution(
                List.of(
                        "#####",
                        "#@  #",
                        "#   #",
                        "#  $#",
                        "#####"
                )
        );

        List<String> expectedRowsTab =
                List.of(
                        "@  ",
                        "   ",
                        "  $"
                );

        rowTabSimplifier.simplify(solution);

        Assertions.assertFalse(rowTabSimplifier.simplify(solution).isEmpty());
        Assertions.assertTrue(expectedRowsTab.containsAll(rowTabSimplifier.simplify(solution)));
    }

    @Test
    void testCase2(){
        RowTabSimplifier rowTabSimplifier = new RowTabSimplifier();
        Solution solution = new SolutionInitializer().initSolution(
                List.of(
                "###############",
                "#  #@#I  T$#  #",
                "#  #    IB #  #",
                "#  #     W #  #",
                "#  #      ##  #",
                "#  #B XBN# #  #",
                "#  ##      #  #",
                "#  #       #  #",
                "#  #     W #  #",
                "#  #      ##  #",
                "#  #B XBN# #  #",
                "#  ##      #  #",
                "#  #       #  #",
                "#  #     W #  #",
                "#  #      ##  #",
                "#  #B XBN# #  #",
                "#  ##      #  #",
                "#  #       #  #",
                "#  #       #  #",
                "#  #      ##  #",
                "#  #  XBIT #  #",
                "#  #########  #",
                "#             #",
                "# ##### ##### #",
                "# #     #     #",
                "# #     #  ## #",
                "# #     #   # #",
                "# ##### ##### #",
                "#             #",
                "###############"
                )
        );

        List<String> expectedRowsTab =
                List.of(
      "  #@#I  T$#  ",
                "  #    IB #  ",
                "  #     W #  ",
                "  #      ##  ",
                "  #B XBN# #  ",
                "  ##      #  ",
                "  #       #  ",
                "  #     W #  ",
                "  #      ##  ",
                "  #B XBN# #  ",
                "  ##      #  ",
                "  #       #  ",
                "  #     W #  ",
                "  #      ##  ",
                "  #B XBN# #  ",
                "  ##      #  ",
                "  #       #  ",
                "  #       #  ",
                "  #      ##  ",
                "  #  XBIT #  ",
                "  #########  ",
                "             ",
                " ##### ##### ",
                " #     #     ",
                " #     #  ## ",
                " #     #   # ",
                " ##### ##### ",
                "             "
                );

        rowTabSimplifier.simplify(solution);

        Assertions.assertFalse(rowTabSimplifier.simplify(solution).isEmpty());
        Assertions.assertTrue(expectedRowsTab.containsAll(rowTabSimplifier.simplify(solution)));
    }
}
