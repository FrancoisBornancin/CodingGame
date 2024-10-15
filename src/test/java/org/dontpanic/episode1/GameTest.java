package org.dontpanic.episode1;

import org.dontpanic.episode1.gameinit.gamelauncher.GameLauncher;
import org.dontpanic.episode1.gameinit.gamelauncher.TestGameLauncher;
import org.dontpanic.episode1.gameinit.staticdata.InitializedData;
import org.dontpanic.episode1.gameinit.staticdata.StaticGameInitializedData;
import org.dontpanic.episode1.gameplay.clone.Clone;
import org.dontpanic.episode1.gameplay.clone.CloneDirection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GameTest {
    @Nested
    public class Reversing{
        private InitializedData initData(){
            Clone firstClone = new Clone(9,0, CloneDirection.RIGHT);
            StaticGameInitializedData staticGameInitializedData =
                    new StaticGameInitializedData(
                            1,
                            13,
                            new HashMap<>(),
                            Map.of(0, 2),
                            100
                    );

            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData = staticGameInitializedData;
            initializedData.firstClone = firstClone;

            return initializedData;
        }

        @Test
        void itShouldLaunchGame(){
            GameLauncher gameLauncher = new TestGameLauncher();
            gameLauncher.launchGame(initData());
        }
    }

    @Nested
    public class OneFloor{
        private InitializedData initData(){
            Clone firstClone = new Clone(1,0, CloneDirection.RIGHT);
            StaticGameInitializedData staticGameInitializedData =
                    new StaticGameInitializedData(
                            2,
                            13,
                            Map.of(0, List.of(7)),
                            Map.of(1, 1),
                            100
                    );

            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData = staticGameInitializedData;
            initializedData.firstClone = firstClone;

            return initializedData;
        }

        @Test
        void itShouldLaunchGame(){
            GameLauncher gameLauncher = new TestGameLauncher();
            gameLauncher.launchGame(initData());
        }
    }

    @Nested
    public class LowReverse{
        private InitializedData initData(){
            Clone firstClone = new Clone(9,0, CloneDirection.RIGHT);
            StaticGameInitializedData staticGameInitializedData =
                    new StaticGameInitializedData(
                            2,
                            13,
                            Map.of(0, List.of(3)),
                            Map.of(1, 0),
                            100
                    );

            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData = staticGameInitializedData;
            initializedData.firstClone = firstClone;

            return initializedData;
        }

        @Test
        void itShouldLaunchGame(){
            GameLauncher gameLauncher = new TestGameLauncher();
            gameLauncher.launchGame(initData());
        }
    }

    @Nested
    public class SeveralFloors{
        private InitializedData initData(){
            Clone firstClone = new Clone(4,0, CloneDirection.RIGHT);
            StaticGameInitializedData staticGameInitializedData =
                    new StaticGameInitializedData(
                            4,
                            24,
                            Map.of(
                                    0, List.of(19),
                                    1, List.of(4),
                                    2, List.of(19)
                            ),
                            Map.of(3, 2),
                            200
                    );

            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData = staticGameInitializedData;
            initializedData.firstClone = firstClone;

            return initializedData;
        }

        @Test
        void itShouldLaunchGame(){
            GameLauncher gameLauncher = new TestGameLauncher();
            gameLauncher.launchGame(initData());
        }
    }

    @Nested
    public class SixFloorsLotOfTowers{
        private InitializedData initData(){
            Clone firstClone = new Clone(17, 0, CloneDirection.RIGHT);
            StaticGameInitializedData staticGameInitializedData =
                    new StaticGameInitializedData(
                            7,
                            24,
                            Map.of(
                                    0, List.of(14),
                                    1, List.of(10),
                                    2, List.of(6),
                                    3, List.of(18),
                                    4, List.of(15),
                                    5, List.of(12)
                            ),
                            Map.of(6, 17),
                            200
                    );

            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData = staticGameInitializedData;
            initializedData.firstClone = firstClone;

            return initializedData;
        }

        @Test
        void itShouldLaunchGame(){
            GameLauncher gameLauncher = new TestGameLauncher();
            gameLauncher.launchGame(initData());
        }
    }

    @Nested
    public class FewTowers{
        private InitializedData initData(){
            Clone firstClone = new Clone(9, 0, CloneDirection.RIGHT);
            StaticGameInitializedData staticGameInitializedData =
                    new StaticGameInitializedData(
                            9,
                            24,
                            Map.of(
                                    0, List.of(12),
                                    1, List.of(10),
                                    2, List.of(12),
                                    3, List.of(10),
                                    4, List.of(12),
                                    5, List.of(10),
                                    6, List.of(12),
                                    7, List.of(10)
                            ),
                            Map.of(8, 12),
                            200
                    );

            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData = staticGameInitializedData;
            initializedData.firstClone = firstClone;

            return initializedData;
        }

        @Test
        void itShouldLaunchGame(){
            GameLauncher gameLauncher = new TestGameLauncher();
            gameLauncher.launchGame(initData());
        }
    }

    @Nested
    public class BigDistanceBetweenElevatorsFewTowers{
        private InitializedData initData(){
            Clone firstClone = new Clone(9, 0, CloneDirection.RIGHT);
            StaticGameInitializedData staticGameInitializedData =
                    new StaticGameInitializedData(
                            9,
                            24,
                            Map.of(
                                    0, List.of(13),
                                    1, List.of(15),
                                    2, List.of(11),
                                    3, List.of(9),
                                    4, List.of(7),
                                    5, List.of(9),
                                    6, List.of(7),
                                    7, List.of(2)
                            ),
                            Map.of(8, 12),
                            200
                    );

            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData = staticGameInitializedData;
            initializedData.firstClone = firstClone;

            return initializedData;
        }

        @Test
        void itShouldLaunchGame(){
            GameLauncher gameLauncher = new TestGameLauncher();
            gameLauncher.launchGame(initData());
        }
    }

    @Nested
    public class testCase1{
        private InitializedData initData(){
            Clone firstClone = new Clone(0, 0, CloneDirection.RIGHT);
            StaticGameInitializedData staticGameInitializedData =
                    new StaticGameInitializedData(
                            1,
                            7,
                            Map.of(),
                            Map.of(0, 6),
                            200
                    );

            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData = staticGameInitializedData;
            initializedData.firstClone = firstClone;

            return initializedData;
        }

        @Test
        void itShouldLaunchGame(){
            GameLauncher gameLauncher = new TestGameLauncher();
            gameLauncher.launchGame(initData());
        }
    }

    @Nested
    public class testCase2{
        private InitializedData initData(){
            Clone firstClone = new Clone(0, 0, CloneDirection.LEFT);
            StaticGameInitializedData staticGameInitializedData =
                    new StaticGameInitializedData(
                            1,
                            7,
                            Map.of(),
                            Map.of(0, 6),
                            200
                    );

            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData = staticGameInitializedData;
            initializedData.firstClone = firstClone;

            return initializedData;
        }

        @Test
        void itShouldLaunchGame(){
            GameLauncher gameLauncher = new TestGameLauncher();
            gameLauncher.launchGame(initData());
        }
    }

    @Nested
    public class testCase3{
        private InitializedData initData(){
            Clone firstClone = new Clone(0, 1, CloneDirection.RIGHT);
            StaticGameInitializedData staticGameInitializedData =
                    new StaticGameInitializedData(
                            2,
                            7,
                            Map.of(1, List.of(3)),
                            Map.of(0, 6),
                            200
                    );

            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData = staticGameInitializedData;
            initializedData.firstClone = firstClone;

            return initializedData;
        }

        @Test
        void itShouldLaunchGame(){
            GameLauncher gameLauncher = new TestGameLauncher();
            gameLauncher.launchGame(initData());
        }
    }

    @Nested
    public class testCase4{
        private InitializedData initData(){
            Clone firstClone = new Clone(0, 1, CloneDirection.LEFT);
            StaticGameInitializedData staticGameInitializedData =
                    new StaticGameInitializedData(
                            2,
                            7,
                            Map.of(1, List.of(3)),
                            Map.of(0, 6),
                            200
                    );

            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData = staticGameInitializedData;
            initializedData.firstClone = firstClone;

            return initializedData;
        }

        @Test
        void itShouldLaunchGame(){
            GameLauncher gameLauncher = new TestGameLauncher();
            gameLauncher.launchGame(initData());
        }
    }

    @Nested
    public class testCase5{
        private InitializedData initData(){
            Clone firstClone = new Clone(0, 1, CloneDirection.RIGHT);
            StaticGameInitializedData staticGameInitializedData =
                    new StaticGameInitializedData(
                            2,
                            7,
                            Map.of(
                                    1, List.of(3),
                                    0, List.of(1)
                            ),
                            Map.of(0, 6),
                            200
                    );

            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData = staticGameInitializedData;
            initializedData.firstClone = firstClone;

            return initializedData;
        }

        @Test
        void itShouldLaunchGame(){
            GameLauncher gameLauncher = new TestGameLauncher();
            gameLauncher.launchGame(initData());
        }
    }

    @Nested
    public class testCase6{
        private InitializedData initData(){
            Clone firstClone = new Clone(0, 1, CloneDirection.LEFT);
            StaticGameInitializedData staticGameInitializedData =
                    new StaticGameInitializedData(
                            2,
                            7,
                            Map.of(
                                    1, List.of(3),
                                    0, List.of(1)
                            ),
                            Map.of(0, 6),
                            200
                    );

            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData = staticGameInitializedData;
            initializedData.firstClone = firstClone;

            return initializedData;
        }

        @Test
        void itShouldLaunchGame(){
            GameLauncher gameLauncher = new TestGameLauncher();
            gameLauncher.launchGame(initData());
        }
    }

    @Nested
    public class testCase7{
        private InitializedData initData(){
            Clone firstClone = new Clone(0, 1, CloneDirection.RIGHT);
            StaticGameInitializedData staticGameInitializedData =
                    new StaticGameInitializedData(
                            2,
                            7,
                            Map.of(
                                    0, List.of(1)
                            ),
                            Map.of(1, 6),
                            200
                    );

            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData = staticGameInitializedData;
            initializedData.firstClone = firstClone;

            return initializedData;
        }

        @Test
        void itShouldLaunchGame(){
            GameLauncher gameLauncher = new TestGameLauncher();
            gameLauncher.launchGame(initData());
        }
    }

    @Nested
    public class testCase8{
        private InitializedData initData(){
            Clone firstClone = new Clone(0, 1, CloneDirection.LEFT);
            StaticGameInitializedData staticGameInitializedData =
                    new StaticGameInitializedData(
                            2,
                            7,
                            Map.of(
                                    0, List.of(1)
                            ),
                            Map.of(1, 6),
                            200
                    );

            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData = staticGameInitializedData;
            initializedData.firstClone = firstClone;

            return initializedData;
        }

        @Test
        void itShouldLaunchGame(){
            GameLauncher gameLauncher = new TestGameLauncher();
            gameLauncher.launchGame(initData());
        }
    }

    @Nested
    public class testCase9{
        private InitializedData initData(){
            Clone firstClone = new Clone(0, 2, CloneDirection.RIGHT);
            StaticGameInitializedData staticGameInitializedData =
                    new StaticGameInitializedData(
                            3,
                            7,
                            Map.of(
                                    0, List.of(1),
                                    1, List.of(1),
                                    2, List.of(3)
                            ),
                            Map.of(0, 5),
                            200
                    );

            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData = staticGameInitializedData;
            initializedData.firstClone = firstClone;

            return initializedData;
        }

        @Test
        void itShouldLaunchGame(){
            GameLauncher gameLauncher = new TestGameLauncher();
            gameLauncher.launchGame(initData());
        }
    }

    @Nested
    public class testCase10{
        private InitializedData initData(){
            Clone firstClone = new Clone(0, 2, CloneDirection.LEFT);
            StaticGameInitializedData staticGameInitializedData =
                    new StaticGameInitializedData(
                            3,
                            7,
                            Map.of(
                                    0, List.of(1),
                                    1, List.of(1),
                                    2, List.of(3)
                            ),
                            Map.of(0, 5),
                            200
                    );

            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData = staticGameInitializedData;
            initializedData.firstClone = firstClone;

            return initializedData;
        }

        @Test 
        void itShouldLaunchGame(){
            GameLauncher gameLauncher = new TestGameLauncher();
            gameLauncher.launchGame(initData());
        }
    }

    @Nested
    public class testCase11{
        private InitializedData initData(){
            Clone firstClone = new Clone(0, 2, CloneDirection.RIGHT);
            StaticGameInitializedData staticGameInitializedData =
                    new StaticGameInitializedData(
                            3,
                            7,
                            Map.of(
                                    0, List.of(0),
                                    1, List.of(1),
                                    2, List.of(2)
                            ),
                            Map.of(0, 5),
                            200
                    );

            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData = staticGameInitializedData;
            initializedData.firstClone = firstClone;

            return initializedData;
        }

        @Test
        void itShouldLaunchGame(){
            GameLauncher gameLauncher = new TestGameLauncher();
            gameLauncher.launchGame(initData());
        }
    }

    @Nested
    public class testCase12{
        private InitializedData initData(){
            Clone firstClone = new Clone(0, 2, CloneDirection.LEFT);
            StaticGameInitializedData staticGameInitializedData =
                    new StaticGameInitializedData(
                            3,
                            7,
                            Map.of(
                                    0, List.of(0),
                                    1, List.of(1),
                                    2, List.of(2)
                            ),
                            Map.of(0, 5),
                            200
                    );

            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData = staticGameInitializedData;
            initializedData.firstClone = firstClone;

            return initializedData;
        }

        @Test
        void itShouldLaunchGame(){
            GameLauncher gameLauncher = new TestGameLauncher();
            gameLauncher.launchGame(initData());
        }
    }

    @Nested
    public class testCase13{
        private InitializedData initData(){
            Clone firstClone = new Clone(0, 2, CloneDirection.RIGHT);
            StaticGameInitializedData staticGameInitializedData =
                    new StaticGameInitializedData(
                            3,
                            7,
                            Map.of(
                                    1, List.of(5),
                                    2, List.of(3)
                            ),
                            Map.of(2, 0),
                            200
                    );

            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData = staticGameInitializedData;
            initializedData.firstClone = firstClone;

            return initializedData;
        }

        @Test
        void itShouldLaunchGame(){
            GameLauncher gameLauncher = new TestGameLauncher();
            gameLauncher.launchGame(initData());
        }
    }

    @Nested
    public class testCase14{
        private InitializedData initData(){
            Clone firstClone = new Clone(0, 2, CloneDirection.LEFT);
            StaticGameInitializedData staticGameInitializedData =
                    new StaticGameInitializedData(
                            3,
                            7,
                            Map.of(
                                    1, List.of(5),
                                    2, List.of(3)
                            ),
                            Map.of(0, 2),
                            200
                    );

            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData = staticGameInitializedData;
            initializedData.firstClone = firstClone;

            return initializedData;
        }

        @Test
        void itShouldLaunchGame(){
            GameLauncher gameLauncher = new TestGameLauncher();
            gameLauncher.launchGame(initData());
        }
    }

    @Nested
    public class testCase1_bis{
        private InitializedData initData(){
            Clone firstClone = new Clone(6, 0, CloneDirection.RIGHT);
            StaticGameInitializedData staticGameInitializedData =
                    new StaticGameInitializedData(
                            1,
                            7,
                            Map.of(),
                            Map.of(0, 0),
                            200
                    );

            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData = staticGameInitializedData;
            initializedData.firstClone = firstClone;

            return initializedData;
        }

        @Test
        void itShouldLaunchGame(){
            GameLauncher gameLauncher = new TestGameLauncher();
            gameLauncher.launchGame(initData());
        }
    }

    @Nested
    public class testCase2_bis{
        private InitializedData initData(){
            Clone firstClone = new Clone(6, 0, CloneDirection.LEFT);
            StaticGameInitializedData staticGameInitializedData =
                    new StaticGameInitializedData(
                            1,
                            7,
                            Map.of(),
                            Map.of(0, 0),
                            200
                    );

            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData = staticGameInitializedData;
            initializedData.firstClone = firstClone;

            return initializedData;
        }

        @Test
        void itShouldLaunchGame(){
            GameLauncher gameLauncher = new TestGameLauncher();
            gameLauncher.launchGame(initData());
        }
    }

    @Nested
    public class testCase3_bis{
        private InitializedData initData(){
            Clone firstClone = new Clone(0, 0, CloneDirection.RIGHT);
            StaticGameInitializedData staticGameInitializedData =
                    new StaticGameInitializedData(
                            2,
                            7,
                            Map.of(0, List.of(3)),
                            Map.of(1, 6),
                            200
                    );

            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData = staticGameInitializedData;
            initializedData.firstClone = firstClone;

            return initializedData;
        }

        @Test
        void itShouldLaunchGame(){
            GameLauncher gameLauncher = new TestGameLauncher();
            gameLauncher.launchGame(initData());
        }
    }

    @Nested
    public class testCase4_bis{
        private InitializedData initData(){
            Clone firstClone = new Clone(0, 0, CloneDirection.LEFT);
            StaticGameInitializedData staticGameInitializedData =
                    new StaticGameInitializedData(
                            2,
                            7,
                            Map.of(0, List.of(3)),
                            Map.of(1, 6),
                            200
                    );

            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData = staticGameInitializedData;
            initializedData.firstClone = firstClone;

            return initializedData;
        }

        @Test
        void itShouldLaunchGame(){
            GameLauncher gameLauncher = new TestGameLauncher();
            gameLauncher.launchGame(initData());
        }
    }

    @Nested
    public class testCase5_bis{
        private InitializedData initData(){
            Clone firstClone = new Clone(0, 0, CloneDirection.RIGHT);
            StaticGameInitializedData staticGameInitializedData =
                    new StaticGameInitializedData(
                            2,
                            7,
                            Map.of(
                                    1, List.of(1),
                                    0, List.of(3)
                            ),
                            Map.of(1, 6),
                            200
                    );

            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData = staticGameInitializedData;
            initializedData.firstClone = firstClone;

            return initializedData;
        }

        @Test
        void itShouldLaunchGame(){
            GameLauncher gameLauncher = new TestGameLauncher();
            gameLauncher.launchGame(initData());
        }
    }

    @Nested
    public class testCase6_bis{
        private InitializedData initData(){
            Clone firstClone = new Clone(0, 0, CloneDirection.LEFT);
            StaticGameInitializedData staticGameInitializedData =
                    new StaticGameInitializedData(
                            2,
                            7,
                            Map.of(
                                    1, List.of(1),
                                    0, List.of(3)
                            ),
                            Map.of(1, 6),
                            200
                    );

            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData = staticGameInitializedData;
            initializedData.firstClone = firstClone;

            return initializedData;
        }

        @Test
        void itShouldLaunchGame(){
            GameLauncher gameLauncher = new TestGameLauncher();
            gameLauncher.launchGame(initData());
        }
    }

    @Nested
    public class testCase7_bis{
        private InitializedData initData(){
            Clone firstClone = new Clone(0, 0, CloneDirection.RIGHT);
            StaticGameInitializedData staticGameInitializedData =
                    new StaticGameInitializedData(
                            2,
                            7,
                            Map.of(
                                    1, List.of(1)
                            ),
                            Map.of(0, 6),
                            200
                    );

            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData = staticGameInitializedData;
            initializedData.firstClone = firstClone;

            return initializedData;
        }

        @Test
        void itShouldLaunchGame(){
            GameLauncher gameLauncher = new TestGameLauncher();
            gameLauncher.launchGame(initData());
        }
    }

    @Nested
    public class testCase8_bis{
        private InitializedData initData(){
            Clone firstClone = new Clone(0, 0, CloneDirection.LEFT);
            StaticGameInitializedData staticGameInitializedData =
                    new StaticGameInitializedData(
                            2,
                            7,
                            Map.of(
                                    1, List.of(1)
                            ),
                            Map.of(0, 6),
                            200
                    );

            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData = staticGameInitializedData;
            initializedData.firstClone = firstClone;

            return initializedData;
        }

        @Test
        void itShouldLaunchGame(){
            GameLauncher gameLauncher = new TestGameLauncher();
            gameLauncher.launchGame(initData());
        }
    }

    @Nested
    public class testCase9_bis{
        private InitializedData initData(){
            Clone firstClone = new Clone(0, 0, CloneDirection.RIGHT);
            StaticGameInitializedData staticGameInitializedData =
                    new StaticGameInitializedData(
                            3,
                            7,
                            Map.of(
                                    2, List.of(1),
                                    1, List.of(1),
                                    0, List.of(3)
                            ),
                            Map.of(2, 5),
                            200
                    );

            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData = staticGameInitializedData;
            initializedData.firstClone = firstClone;

            return initializedData;
        }

        @Test
        void itShouldLaunchGame(){
            GameLauncher gameLauncher = new TestGameLauncher();
            gameLauncher.launchGame(initData());
        }
    }

    @Nested
    public class testCase10_bis{
        private InitializedData initData(){
            Clone firstClone = new Clone(0, 0, CloneDirection.LEFT);
            StaticGameInitializedData staticGameInitializedData =
                    new StaticGameInitializedData(
                            3,
                            7,
                            Map.of(
                                    2, List.of(1),
                                    1, List.of(1),
                                    0, List.of(3)
                            ),
                            Map.of(2, 5),
                            200
                    );

            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData = staticGameInitializedData;
            initializedData.firstClone = firstClone;

            return initializedData;
        }

        @Test
        void itShouldLaunchGame(){
            GameLauncher gameLauncher = new TestGameLauncher();
            gameLauncher.launchGame(initData());
        }
    }

    @Nested
    public class testCase11_bis{
        private InitializedData initData(){
            Clone firstClone = new Clone(0, 0, CloneDirection.RIGHT);
            StaticGameInitializedData staticGameInitializedData =
                    new StaticGameInitializedData(
                            3,
                            7,
                            Map.of(
                                    2, List.of(0),
                                    1, List.of(1),
                                    0, List.of(3)
                            ),
                            Map.of(2, 5),
                            200
                    );

            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData = staticGameInitializedData;
            initializedData.firstClone = firstClone;

            return initializedData;
        }

        @Test
        void itShouldLaunchGame(){
            GameLauncher gameLauncher = new TestGameLauncher();
            gameLauncher.launchGame(initData());
        }
    }

    @Nested
    public class testCase12_bis{
        private InitializedData initData(){
            Clone firstClone = new Clone(0, 0, CloneDirection.LEFT);
            StaticGameInitializedData staticGameInitializedData =
                    new StaticGameInitializedData(
                            3,
                            7,
                            Map.of(
                                    2, List.of(0),
                                    1, List.of(1),
                                    0, List.of(3)
                            ),
                            Map.of(2, 5),
                            200
                    );

            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData = staticGameInitializedData;
            initializedData.firstClone = firstClone;

            return initializedData;
        }

        @Test
        void itShouldLaunchGame(){
            GameLauncher gameLauncher = new TestGameLauncher();
            gameLauncher.launchGame(initData());
        }
    }

    @Nested
    public class testCase13_bis{
        private InitializedData initData(){
            Clone firstClone = new Clone(0, 0, CloneDirection.RIGHT);
            StaticGameInitializedData staticGameInitializedData =
                    new StaticGameInitializedData(
                            3,
                            7,
                            Map.of(
                                    1, List.of(6),
                                    0, List.of(3)
                            ),
                            Map.of(2, 3),
                            200
                    );

            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData = staticGameInitializedData;
            initializedData.firstClone = firstClone;

            return initializedData;
        }

        @Test
        void itShouldLaunchGame(){
            GameLauncher gameLauncher = new TestGameLauncher();
            gameLauncher.launchGame(initData());
        }
    }

    @Nested
    public class testCase14_bis{
        private InitializedData initData(){
            Clone firstClone = new Clone(0, 0, CloneDirection.LEFT);
            StaticGameInitializedData staticGameInitializedData =
                    new StaticGameInitializedData(
                            3,
                            7,
                            Map.of(
                                    1, List.of(6),
                                    0, List.of(3)
                            ),
                            Map.of(2, 3),
                            200
                    );

            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData = staticGameInitializedData;
            initializedData.firstClone = firstClone;

            return initializedData;
        }

        @Test
        void itShouldLaunchGame(){
            GameLauncher gameLauncher = new TestGameLauncher();
            gameLauncher.launchGame(initData());
        }
    }
}
