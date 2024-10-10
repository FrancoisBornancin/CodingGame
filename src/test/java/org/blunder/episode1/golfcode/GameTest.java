package org.blunder.episode1.golfcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GameTest {

    @Test
    void itShouldHaveInfiniteLoop_case1(){
        Game game = new Game();

        Solution solution = new SolutionInitializer().initSolution(
                List.of(
                        "#####",
                        "#@  #",
                        "#   #",
                        "#   #",
                        "#####"
                )
        );

        List<String> expectedList =
                List.of("LOOP");

        List<String> calculatedList = game.play(solution);

        Assertions.assertFalse(calculatedList.isEmpty());
        Assertions.assertTrue(expectedList.containsAll(calculatedList));
    }

    @Test
    void brokenWall(){
        Game game = new Game();

        Solution solution = new SolutionInitializer().initSolution(
                List.of(
                    "##########",
                    "#        #",
                    "#  @     #",
                    "#  B     #",
                    "#  S   W #",
                    "# XXX    #",
                    "#  B   N #",
                    "# XXXXXXX#",
                    "#       $#",
                    "##########"
                )
        );

        List<String> expectedList =
                List.of("LOOP");

        List<String> calculatedList = game.play(solution);

        Assertions.assertFalse(calculatedList.isEmpty());
        Assertions.assertEquals(expectedList.size(), calculatedList.size());
        for(int a = 0 ; a < expectedList.size() ; a++){
            Assertions.assertEquals(expectedList.get(a), calculatedList.get(a));
        }
    }

    @Test
    void itShouldHaveInfiniteLoop_case2(){
        Game game = new Game();

        Solution solution = new SolutionInitializer().initSolution(
                List.of("###############",
                                "#      IXXXXX #",
                                "#  @          #",
                                "#E S          #",
                                "#             #",
                                "#  I          #",
                                "#  B          #",
                                "#  B   S     W#",
                                "#  B   T      #",
                                "#             #",
                                "#         T   #",
                                "#         B   #",
                                "#N          W$#",
                                "#        XXXX #",
                                "###############"
                )
        );

        List<String> expectedList =
                List.of("LOOP");

        List<String> calculatedList = game.play(solution);

        Assertions.assertFalse(calculatedList.isEmpty());
        Assertions.assertEquals(calculatedList.size(), expectedList.size());
        for(int a = 0 ; a < expectedList.size() ; a++){
            Assertions.assertEquals(expectedList.get(a), calculatedList.get(a));
        }
    }

    @Test
    void simpleMoves(){
        Game game = new Game();

        Solution solution = new SolutionInitializer().initSolution(
                List.of(
                        "#####",
                        "#@  #",
                        "#   #",
                        "#  $#",
                        "#####"
                )
        );

        List<String> expectedList =
                List.of(
                        "SOUTH",
                        "SOUTH",
                        "EAST",
                        "EAST"
                );

        List<String> calculatedList = game.play(solution);

        Assertions.assertFalse(calculatedList.isEmpty());
        Assertions.assertEquals(calculatedList.size(), expectedList.size());
        for(int a = 0 ; a < expectedList.size() ; a++){
            Assertions.assertEquals(expectedList.get(a), calculatedList.get(a));
        }
    }

    @Test
    void directionChanges(){
        Game game = new Game();

        Solution solution = new SolutionInitializer().initSolution(
                List.of(
                        "##########",
                        "#        #",
                        "#  S   W #",
                        "#        #",
                        "#  $     #",
                        "#        #",
                        "#@       #",
                        "#        #",
                        "#E     N #",
                        "##########"
                )
        );

        List<String> expectedList =
                List.of(
                        "SOUTH",
                        "SOUTH",
                        "EAST",
                        "EAST",
                        "EAST",
                        "EAST",
                        "EAST",
                        "EAST",
                        "NORTH",
                        "NORTH",
                        "NORTH",
                        "NORTH",
                        "NORTH",
                        "NORTH",
                        "WEST",
                        "WEST",
                        "WEST",
                        "WEST",
                        "SOUTH",
                        "SOUTH"
                );

        List<String> calculatedList = game.play(solution);

        Assertions.assertFalse(calculatedList.isEmpty());
        Assertions.assertEquals(calculatedList.size(), expectedList.size());
        for(int a = 0 ; a < expectedList.size() ; a++){
            Assertions.assertEquals(expectedList.get(a), calculatedList.get(a));
        }
    }

    @Test
    void breakerMode(){
        Game game = new Game();

        Solution solution = new SolutionInitializer().initSolution(
                List.of(
                    "##########",
                    "# @      #",
                    "# B      #",
                    "#XXX     #",
                    "# B      #",
                    "#    BXX$#",
                    "#XXXXXXXX#",
                    "#        #",
                    "#        #",
                    "##########"
                )
        );

        List<String> expectedList =
                List.of("SOUTH",
                        "SOUTH",
                        "SOUTH",
                        "SOUTH",
                        "EAST",
                        "EAST",
                        "EAST",
                        "EAST",
                        "EAST",
                        "EAST"
                );

        List<String> calculatedList = game.play(solution);

        Assertions.assertFalse(calculatedList.isEmpty());
        Assertions.assertEquals(calculatedList.size(), expectedList.size());
        for(int a = 0 ; a < expectedList.size() ; a++){
            Assertions.assertEquals(expectedList.get(a), calculatedList.get(a));
        }
    }

    @Test
    void obstacles(){
        Game game = new Game();

        Solution solution = new SolutionInitializer().initSolution(
                List.of(
                        "########",
                        "# @    #",
                        "#     X#",
                        "# XXX  #",
                        "#   XX #",
                        "#   XX #",
                        "#     $#",
                        "########"
                )
        );

        List<String> expectedList =
                List.of("SOUTH",
                        "EAST",
                        "EAST",
                        "EAST",
                        "SOUTH",
                        "EAST",
                        "SOUTH",
                        "SOUTH",
                        "SOUTH"
                );

        List<String> calculatedList = game.play(solution);

        Assertions.assertFalse(calculatedList.isEmpty());
        Assertions.assertEquals(calculatedList.size(), expectedList.size());
        for(int a = 0 ; a < expectedList.size() ; a++){
            Assertions.assertEquals(expectedList.get(a), calculatedList.get(a));
        }
    }

    @Test
    void priorities(){
        Game game = new Game();

        Solution solution = new SolutionInitializer().initSolution(
                List.of(
                    "########",
                    "#     $#",
                    "#      #",
                    "#      #",
                    "#  @   #",
                    "#      #",
                    "#      #",
                    "########"
                )
        );

        List<String> expectedList =
                List.of("SOUTH",
                        "SOUTH",
                        "EAST",
                        "EAST",
                        "EAST",
                        "NORTH",
                        "NORTH",
                        "NORTH",
                        "NORTH",
                        "NORTH"
                );

        List<String> calculatedList = game.play(solution);

        Assertions.assertFalse(calculatedList.isEmpty());
        Assertions.assertEquals(calculatedList.size(), expectedList.size());
        for(int a = 0 ; a < expectedList.size() ; a++){
            Assertions.assertEquals(expectedList.get(a), calculatedList.get(a));
        }
    }

    @Test
    void oneLigne(){
        Game game = new Game();

        Solution solution = new SolutionInitializer().initSolution(
                List.of(
                    "########",
                    "#      #",
                    "# @    #",
                    "# XX   #",
                    "#  XX  #",
                    "#   XX #",
                    "#     $#",
                    "########"
                )
        );

        List<String> expectedList =
                List.of("EAST",
                        "EAST",
                        "EAST",
                        "EAST",
                        "SOUTH",
                        "SOUTH",
                        "SOUTH",
                        "SOUTH"
                );

        List<String> calculatedList = game.play(solution);

        Assertions.assertFalse(calculatedList.isEmpty());
        Assertions.assertEquals(calculatedList.size(), expectedList.size());
        for(int a = 0 ; a < expectedList.size() ; a++){
            Assertions.assertEquals(expectedList.get(a), calculatedList.get(a));
        }
    }

    @Test
    void teleportation(){
        Game game = new Game();

        Solution solution = new SolutionInitializer().initSolution(
                List.of(
                    "##########",
                    "#    T   #",
                    "#        #",
                    "#        #",
                    "#        #",
                    "#@       #",
                    "#        #",
                    "#        #",
                    "#    T  $#",
                    "##########"
                )
        );

        List<String> expectedList =
                List.of("SOUTH",
                        "SOUTH",
                        "SOUTH",
                        "EAST",
                        "EAST",
                        "EAST",
                        "EAST",
                        "EAST",
                        "EAST",
                        "EAST",
                        "SOUTH",
                        "SOUTH",
                        "SOUTH",
                        "SOUTH",
                        "SOUTH",
                        "SOUTH",
                        "SOUTH"
                );

        List<String> calculatedList = game.play(solution);

        Assertions.assertFalse(calculatedList.isEmpty());
        Assertions.assertEquals(calculatedList.size(), expectedList.size());
        for(int a = 0 ; a < expectedList.size() ; a++){
            Assertions.assertEquals(expectedList.get(a), calculatedList.get(a));
        }
    }

    @Test
    void itShouldBeALoop(){
        Game game = new Game();

        Solution solution = new SolutionInitializer().initSolution(
                List.of(
                        " X ",
                        "X@X",
                        " X "
                )
        );

        List<String> expectedList = List.of("LOOP");

        List<String> calculatedList = game.play(solution);

        Assertions.assertFalse(calculatedList.isEmpty());
        Assertions.assertEquals(calculatedList.size(), expectedList.size());
        for(int a = 0 ; a < expectedList.size() ; a++){
            Assertions.assertEquals(expectedList.get(a), calculatedList.get(a));
        }
    }
}
