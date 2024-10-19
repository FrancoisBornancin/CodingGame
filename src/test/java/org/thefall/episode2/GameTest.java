package org.thefall.episode2;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.thefall.episode2.gameinit.gamelauncher.GameLauncher;
import org.thefall.episode2.gameinit.gamelauncher.TestGameLauncher;
import org.thefall.episode2.gameinit.staticdata.InitializedData;
import org.thefall.episode2.gameinit.staticdata.StaticGameInitializedData;
import org.thefall.episode2.gameplay.elements.exit.ExitDoor;
import org.thefall.episode2.gameplay.nextblock.Coordinates;
import org.thefall.episode2.gameplay.nextblock.GameDirection;
import org.utils.PerformanceMesurer;

import java.util.List;

public class GameTest {
    @Nested
    public class brokenWellTest{
        private InitializedData initData(){
            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData =
                    new StaticGameInitializedData(
                            List.of(
                                    "0 0 -3 0 0",
                                    "0 0 2 0 0",
                                    "0 0 -3 0 0"
                            ),
                            2
                    );
            initializedData.heroCoordinates = new Coordinates(2, 0, GameDirection.DOWN);

            return initializedData;
        }
        @Test
        void doStuff(){
            GameLauncher gameLauncher = new TestGameLauncher();
            new PerformanceMesurer()
                    .mesure(() -> {
                        gameLauncher.launchGame(initData());
                    });
        }
    }

    @Nested
    public class brokenSewerTest{
        private InitializedData initData(){
            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData =
                    new StaticGameInitializedData(
                            List.of(
                                "0 -3 0 0 0 0 0 0",
                                "0 12 3 3 2 3 12 0",
                                "0 0 0 0 0 0 2 0",
                                "0 -12 3 2 2 3 13 0"
                            ),
                            1
                    );
            initializedData.heroCoordinates = new Coordinates(1, 0, GameDirection.DOWN);

            return initializedData;
        }
        @Test
        void doStuff(){
            GameLauncher gameLauncher = new TestGameLauncher();
            new PerformanceMesurer()
                    .mesure(() -> {
                        gameLauncher.launchGame(initData());
                    });
        }
    }

    @Nested
    public class brokenSecretPathsTest{
        private InitializedData initData(){
            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData =
                    new StaticGameInitializedData(
                            List.of(
                                "0 0 0 0 0 -3",
                                "8 3 3 2 2 10",
                                "2 0 0 0 10 13",
                                "11 3 -2 3 1 13",
                                "-3 10 0 0 2 0",
                                "0 6 3 3 4 13",
                                "0 3 0 13 -4 10",
                                "0 13 2 4 10 0",
                                "0 0 0 -3 0 0"
                            ),
                            3
                    );
            initializedData.heroCoordinates = new Coordinates(5, 0, GameDirection.DOWN);

            return initializedData;
        }
        @Test
        void doStuff(){
            GameLauncher gameLauncher = new TestGameLauncher();
            new PerformanceMesurer()
                    .mesure(() -> {
                        gameLauncher.launchGame(initData());
                    });
        }
    }

    @Nested
    public class mausoleumTest{
        private InitializedData initData(){
            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData =
                    new StaticGameInitializedData(
                            // Width: 12
                            // Height: 9
                            List.of(
                                "-3 12 8 6 3 2 7 2 7 0 0 0 0",
                                "11 5 13 0 0 0 3 0 3 0 0 0 0",
                                "0 11 2 2 3 3 8 2 -9 2 3 13 0",
                                "0 0 0 0 0 12 8 3 1 3 2 7 0",
                                "0 0 11 2 3 1 5 2 10 0 0 11 13",
                                "0 0 3 0 0 6 8 0 0 0 0 0 2",
                                "0 0 11 3 3 10 11 2 3 2 3 2 8",
                                "0 12 6 3 2 3 3 6 3 3 2 3 12",
                                "0 11 4 2 3 2 2 11 12 13 13 13 0",
                                "0 0 -3 12 7 8 13 13 4 5 4 10 0"
                            ),
                            2
                    );
            initializedData.heroCoordinates = new Coordinates(0, 0, GameDirection.DOWN);

            return initializedData;
        }
        @Test
        void doStuff(){
            GameLauncher gameLauncher = new TestGameLauncher();
            new PerformanceMesurer()
                    .mesure(() -> {
                        gameLauncher.launchGame(initData());
                    });
        }
    }

    @Nested
    public class complexUndergroundTest{
        private InitializedData initData(){
            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData =
                    new StaticGameInitializedData(
                            List.of(
                                "0 0 0 0 0 0 -3 0 0 0 0 0 0",
                                "0 0 0 8 3 3 5 2 2 8 2 3 13",
                                "0 0 11 5 13 0 3 0 0 3 0 0 2",
                                "0 10 10 0 3 0 2 0 11 4 10 0 2",
                                "0 3 0 0 2 0 2 0 2 0 3 0 3",
                                "0 2 0 12 10 10 1 2 10 0 3 12 10",
                                "12 6 0 2 0 3 2 12 3 3 10 4 -13",
                                "11 -1 2 -6 2 -6 6 -6 2 3 2 -6 -10"
                            ),
                            1
                    );
            initializedData.heroCoordinates = new Coordinates(6, 0, GameDirection.DOWN);

            return initializedData;
        }
        @Test
        void doStuff(){
            GameLauncher gameLauncher = new TestGameLauncher();
            new PerformanceMesurer()
                    .mesure(() -> {
                        gameLauncher.launchGame(initData());
                    });
        }
    }

    @Nested
    public class rock1Test{
        private InitializedData initData(){
            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData =
                    new StaticGameInitializedData(
                            List.of(
                                    "0 0 0 0 0 0 0 0 -3 0",
                                    "0 7 -2 3 -2 3 -2 3 11 0",
                                    "0 -7 -2 2 2 2 2 2 2 -2",
                                    "0 6 -2 2 2 2 2 2 2 -2",
                                    "0 -7 -2 2 2 2 2 2 2 -2",
                                    "0 8 -2 2 2 2 2 2 2 -2",
                                    "0 -7 -2 2 2 2 2 2 2 -2",
                                    "0 -3 0 0 0 0 0 0 0 0"
                            ),
                            1
                    );
            initializedData.heroCoordinates = new Coordinates(8, 0, GameDirection.DOWN);

            return initializedData;
        }
        @Test
        void doStuff(){
            GameLauncher gameLauncher = new TestGameLauncher();
            new PerformanceMesurer()
                    .mesure(() -> {
                        gameLauncher.launchGame(initData());
                    });
        }
    }

    @Nested
    public class rock2Test{
        private InitializedData initData(){
            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData =
                    new StaticGameInitializedData(
                            List.of(
                                "0 -3 0 -3 0 -3 0 -3 -3 0",
                                "0 7 -2 3 -2 2 -2 3 11 0",
                                "0 -7 -2 -2 -2 -2 2 -2 2 -2",
                                "0 6 -2 -2 -2 -2 -2 2 -2 -2",
                                "0 -7 -2 -2 -2 -2 2 -2 2 -2",
                                "0 8 -2 -2 -2 -2 -2 2 -2 -2",
                                "0 -7 -2 -2 -2 -2 2 -2 2 -2",
                                "0 -3 0 0 0 0 0 0 0 0"
                            ),
                            1
                    );
            initializedData.heroCoordinates = new Coordinates(8, 0, GameDirection.DOWN);

            return initializedData;
        }
        @Test
        void doStuff(){
            GameLauncher gameLauncher = new TestGameLauncher();
            new PerformanceMesurer()
                    .mesure(() -> {
                        gameLauncher.launchGame(initData());
                    });
        }
    }
}
