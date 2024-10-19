package org.thefall.episode1;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.thefall.episode1.gameinit.gamelauncher.GameLauncher;
import org.thefall.episode1.gameinit.gamelauncher.TestGameLauncher;
import org.thefall.episode1.gameinit.staticdata.InitializedData;
import org.thefall.episode1.gameinit.staticdata.StaticGameInitializedData;
import org.thefall.episode1.gameplay.elements.exit.ExitDoor;
import org.thefall.episode1.gameplay.nextblock.Coordinates;
import org.thefall.episode1.gameplay.nextblock.GameDirection;
import org.utils.PerformanceMesurer;

import java.util.List;

public class GameTest {

    @Nested
    public class wellTest{
        private InitializedData initData(){
            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData =
                    new StaticGameInitializedData(
                            List.of(
                                    "0 3 0",
                                    "0 3 0",
                                    "0 3 0"
                            ),
                            1
                    );
            initializedData.heroCoordinates = new Coordinates(1, 0, GameDirection.DOWN);
            initializedData.exitDoor = new ExitDoor(1, 2);

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
    public class sewerTest{
        private InitializedData initData(){
            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData =
                    new StaticGameInitializedData(
                            List.of(
                                "0 3 0 0 0 0 0 0",
                                "0 11 2 2 2 2 13 0",
                                "0 0 0 0 0 0 3 0",
                                "0 12 2 2 2 2 10 0"
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
    public class secretPathTest{
        private InitializedData initData(){
            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData =
                    new StaticGameInitializedData(
                            List.of(
                                "0 0 0 0 0 3",
                                "8 2 2 2 2 10",
                                "3 0 0 0 12 13",
                                "11 2 2 2 1 10",
                                "2 13 0 0 3 0",
                                "0 7 2 2 4 13",
                                "0 3 0 12 4 10",
                                "0 11 2 5 10 0"
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
    public class labyrinthTest{
        private InitializedData initData(){
            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData =
                    new StaticGameInitializedData(
                            List.of(
                                "3 12 8 6 2 2 8 2 9 0 0 0 0",
                                "11 5 10 0 0 0 3 0 3 0 0 0 0",
                                "0 11 2 2 2 2 6 2 1 2 2 13 0",
                                "0 0 0 0 0 12 8 2 1 2 2 9 0",
                                "0 0 12 2 2 1 4 2 10 0 0 11 13",
                                "0 0 3 0 0 7 9 0 0 0 0 0 3",
                                "0 0 11 2 2 10 11 2 2 2 2 2 9",
                                "0 12 8 2 2 2 2 8 2 2 2 2 10",
                                "0 11 4 2 2 2 2 10 12 13 12 13 0",
                                "0 0 3 12 8 8 13 12 4 5 5 10 0"
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
    public class mausoleumTest{
        private InitializedData initData(){
            InitializedData initializedData = new InitializedData();
            initializedData.staticGameInitializedData =
                    new StaticGameInitializedData(
                            List.of(
                        "0 0 0 0 3 0 0 0 0",
                                "0 12 2 2 10 12 2 13 0",
                                "12 10 0 0 0 11 2 9 0",
                                "11 2 2 2 2 2 13 3 0",
                                "0 12 8 8 8 13 3 3 0",
                                "12 4 5 1 10 3 3 3 0",
                                "3 7 1 4 13 7 5 6 13",
                                "11 10 3 7 10 11 4 8 4",
                                "0 12 6 10 12 2 6 10 3",
                                "12 1 2 2 10 12 8 8 10",
                                "7 10 0 0 0 7 1 4 2",
                                "3 0 0 12 13 7 9 3 0",
                                "11 2 2 5 6 4 5 10 0",
                                "0 0 12 5 13 3 3 0 0",
                                "0 0 11 10 3 11 10 0 0"
                            ),
                            4
                    );
            initializedData.heroCoordinates = new Coordinates(4, 0, GameDirection.DOWN);

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
